package com.example.gochicken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class PhotoActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var favoritesFragment: FavoritesFragment
    lateinit var libraryFragment: LibraryFragment
    lateinit var searchFragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val navigation_view_bottom = findViewById<BottomNavigationView>(R.id.navigation_view_bottom)
        navigation_view_bottom.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navi_favorites -> {
                favoritesFragment = FavoritesFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_frame, favoritesFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.navi_library -> {
                libraryFragment = LibraryFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_frame, libraryFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.navi_search -> {
                searchFragment = SearchFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_frame, searchFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return false
    }
}