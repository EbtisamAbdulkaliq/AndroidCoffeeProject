package com.example.coffeestoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // If you want to load the MainFragment on activity start
        if (savedInstanceState == null) {
            replaceFragment(MainFragment())
        }
    }

    // This method is used to replace the fragment in the fragment_container
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)  // This adds the replace action to the back stack
            commit()
        }
    }
}
