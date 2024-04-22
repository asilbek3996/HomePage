package com.example.homepage

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.homepage.databinding.ActivityMainBinding
import com.example.homepage.fragments.FavoriteFragment
import com.example.homepage.fragments.HomeFragment
import com.example.homepage.fragments.ProfileFragment
import com.example.homepage.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val homeFragment = HomeFragment.newInstance()
    val favoriteFragment = FavoriteFragment.newInstance()
    val quizFragment = QuizFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()
    var activeFragment: Fragment = homeFragment
    lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, homeFragment, homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, favoriteFragment, favoriteFragment.tag).hide(favoriteFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, quizFragment, quizFragment.tag).hide(quizFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, profileFragment, profileFragment.tag).hide(profileFragment)
            .commit()

        supportFragmentManager.beginTransaction().show(activeFragment).commit()
        val bottomN = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val tvMain = findViewById<TextView>(R.id.tvMain)

        bottomN.setOnItemSelectedListener {
            if (it.itemId == R.id.home) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment)
                    .commit()
                activeFragment = homeFragment
                tvMain.text = "Asosiy"
            } else if (it.itemId == R.id.favorite) {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(favoriteFragment).commit()
                activeFragment = favoriteFragment
                tvMain.text = "Tanlanganlar"
            } else if (it.itemId == R.id.settings) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(quizFragment)
                    .commit()
                activeFragment = quizFragment
                tvMain.text = "Testlar"
            } else if (it.itemId == R.id.profile) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(profileFragment)
                    .commit()
                activeFragment = profileFragment
                tvMain.text = "Profil"
            }
            return@setOnItemSelectedListener true

        }

    }
}