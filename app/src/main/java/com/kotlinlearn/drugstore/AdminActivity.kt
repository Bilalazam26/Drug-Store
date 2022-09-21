package com.kotlinlearn.drugstore

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kotlinlearn.drugstore.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_admin) as NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment_activity_admin)
        val navBar = binding.adminNavView
        navBar.setupWithNavController(navController)

    }
}