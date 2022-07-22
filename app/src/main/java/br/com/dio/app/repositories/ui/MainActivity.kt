package br.com.dio.app.repositories.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import br.com.dio.app.repositories.R
import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.core.createDialog
import br.com.dio.app.repositories.core.createProgressDialog
import br.com.dio.app.repositories.core.hideSoftKeyboard
import br.com.dio.app.repositories.databinding.ActivityMainBinding
import br.com.dio.app.repositories.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    companion object{
        private const val TAG = "TAG"
    }

    private val dialog by lazy { createProgressDialog()}
    private val viewModelRepos:MainViewModel by viewModel()
    private val adapter by lazy { RepoListAdapter() }
    //private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.rvRepos.adapter = adapter

        viewModelRepos.repos.observe(this){
            when(it){
                MainViewModel.State.Loading -> dialog.create()
                is MainViewModel.State.Error ->{
                    dialog.dismiss()
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                }
                is MainViewModel.State.Success ->{
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val searchView = menu.findItem(R.id.iSearch).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { search ->
            viewModelRepos.getListRepositories(search)
        }
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
    // Log.w(TAG,"onQueryTextChange: $newText")
        return false
    }


}