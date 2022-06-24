package com.example.mycapstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mycapstone.databinding.ActivityMainBinding
import com.example.mycapstone.presentation.AllUsersViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val allUsersViewModel:AllUsersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            if (destination.id == R.id.loginFragment) {
                bottomNavigation.visibility= View.GONE
            } else if (destination.id == R.id.signupFragment) {
                bottomNavigation.visibility= View.GONE
            } else if (destination.id == R.id.successFragment) {
                bottomNavigation.visibility= View.GONE
            } else if (destination.id == R.id.forgotPasswordFragment) {
                bottomNavigation.visibility= View.GONE
            } else {
                bottomNavigation.visibility= View.VISIBLE
            }
        }

        val data=allUsersViewModel.getAllUsers("jimmie","klein")
        data.observe(this, Observer {
            Log.v("TAG",data.value.toString())
        })


    }
}