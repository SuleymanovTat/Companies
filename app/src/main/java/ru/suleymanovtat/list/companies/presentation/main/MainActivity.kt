package ru.suleymanovtat.list.companies.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.suleymanovtat.list.companies.R
import ru.suleymanovtat.list.companies.presentation.companies.CompaniesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.container, CompaniesFragment.newInstance()).commit()
        }
    }
}
