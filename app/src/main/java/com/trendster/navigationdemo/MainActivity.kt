 package com.trendster.navigationdemo

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration

     private lateinit var listener : NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        navigationView.setupWithNavController(navController)

        setupActionBarWithNavController(navController , appBarConfiguration)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->

            if (destination.id == R.id.firstFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))
            }else if(destination.id == R.id.secondFragment) {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))
            }

        }
    }

     override fun onPause() {
         super.onPause()
         navController.addOnDestinationChangedListener(listener)
     }

     override fun onResume() {
         super.onResume()
         navController.removeOnDestinationChangedListener(listener)
     }

     override fun onSupportNavigateUp(): Boolean {
         val navController  = findNavController(R.id.fragment)
         return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
     }

 }