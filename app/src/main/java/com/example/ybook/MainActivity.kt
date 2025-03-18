package com.example.ybook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ybook.databinding.ActivityMainBinding
import androidx.room.Room
import com.example.ybook.data.AppDatabase
import com.example.ybook.ui.notifications.NotificationsViewModel
import com.example.ybook.ui.summary.SumarriesViewModel
import com.example.ybook.ui.summary.SumarryAdapter
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val searchViewModel: SumarriesViewModel =
            ViewModelProvider(this).get(SumarriesViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val sumarryAdapter = SumarryAdapter()
        recyclerView.adapter = sumarryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchViewModel.searchTerm(it).observe(this@MainActivity) {
                        sumarries -> sumarryAdapter.setSumarries(sumarries)
                    }
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


        navView.setupWithNavController(navController)
    }




}