package br.com.dio.app.mqds.repositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import br.com.dio.app.mqds.repositories.R
import br.com.dio.app.mqds.repositories.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val search = menu.findItem(R.id.iSearch).actionView as SearchView
        search.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.w("SUBMIT","Enviando texto: ${query.toString()}")
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.w("CHANGE","Alterando texto: ${newText.toString()}")
        return false
    }
}