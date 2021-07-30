package com.madrat.kursovaya.screens.mainactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ActivityMainBinding
import com.madrat.kursovaya.util.AppDependencies
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeRetrofit()
        initializeViewBinding()
        initializeViews(this)
    }
    private fun initializeViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun initializeRetrofit() {
        val baseUrl = getString(R.string.URL)
    
        val client = OkHttpClient.Builder().apply {
            connectTimeout(
                10,
                TimeUnit.SECONDS
            )
            writeTimeout(
                10,
                TimeUnit.SECONDS
            )
            readTimeout(
                30,
                TimeUnit.SECONDS
            )
            addInterceptor(
                ChuckerInterceptor.Builder(this@MainActivity).apply {
                    alwaysReadResponseBody(true)
                }.build()
            )
        }.build()
    
        val retrofit = Retrofit.Builder().apply {
            baseUrl(baseUrl)
            addConverterFactory(
                GsonConverterFactory.create()
            )
            addCallAdapterFactory(
                RxJava3CallAdapterFactory.create()
            )
            client(client)
        }.build()
        
        AppDependencies.retrofit = retrofit
    }
    private fun initializeViews(activity: MainActivity) {
        with(binding) {
            setSupportActionBar(toolbar)
    
            val navController = Navigation.findNavController(
                activity,
                R.id.nav_host_fragment
            )
    
            val drawerToggle = ActionBarDrawerToggle(
                activity,
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(drawerToggle)
            drawerToggle.syncState()
    
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
    
            NavigationUI.setupWithNavController(
                navigationView,
                navController
            )
            NavigationUI.setupActionBarWithNavController(
                activity,
                navController,
                drawerLayout
            )
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onDestroy() {
        AppDependencies.dismiss()
        super.onDestroy()
    }
}
