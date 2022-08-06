package com.jordan.myrepository.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.jordan.myrepository.R
import com.jordan.myrepository.databinding.ActivityMainBinding
import com.jordan.myrepository.utils.setStartDestinationNav

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setupNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        return true
    }

    override fun onBackPressed() {
        navController.popBackStack().let {
            if (it.not()) {
                super.onBackPressed()
            }
        }
    }

    private fun setupNavigation() {
        navController.setStartDestinationNav(R.navigation.navigation_main) { R.id.profileFragment }
    }
}