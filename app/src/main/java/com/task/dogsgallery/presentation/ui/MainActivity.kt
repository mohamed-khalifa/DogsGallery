package com.task.dogsgallery.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.task.dogsgallery.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var navController: NavController? = null

    fun setupActionBar(toolBar: Toolbar) {
        setSupportActionBar(toolBar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController?.let {
            setupActionBarWithNavController(this, it)
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        navController?.navigateUp() == true || super.onSupportNavigateUp()
}