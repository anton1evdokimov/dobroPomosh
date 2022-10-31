package com.dobro.dobro.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.dobro.dobro.R
import com.dobro.dobro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val calendarButton = findViewById<Button>(R.id.calendarButton)
//        calendarButton.setOnClickListener {
//        }

        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()
        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Home()).commit()
                R.id.coffeeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Calendar()).commit()
                R.id.accountBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Account()).commit()
            }

            return@setOnItemSelectedListener true
        }
        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu
    }
}