package com.example.doodling

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main.*

class Main : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener{

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.first -> {
                var first_fragmant = List()
                supportFragmentManager.beginTransaction().replace(R.id.fragment, first_fragmant).commit()
                return true
            }
            R.id.second -> {
                var second_fragment = Write()
                supportFragmentManager.beginTransaction().replace(R.id.fragment, second_fragment).commit()
                return true
            }
        }
        return false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        bottom_menu.run {
            
        }

        bottom_menu.setOnNavigationItemSelectedListener(this)
    }
}