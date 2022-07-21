package br.com.dio.app.repositories.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import br.com.dio.app.repositories.R
import br.com.dio.app.repositories.databinding.ActivityMainBinding
import br.com.dio.app.repositories.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    companion object{
        private const val TAG = "TAG"
    }
    private val viewModel by viewModel<MainViewModel>()
    // private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        /*viewModel.repos.observe(this){

        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)
        val searchView = menu.findItem(R.id.iSearch).actionView as SearchView
        //searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.w(TAG,"onQueryTextChange: $query")
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.w(TAG,"onQueryTextChange: $newText")
        return false
    }
}