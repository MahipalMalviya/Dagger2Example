package com.dagger2example

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSharedPrefComponent.builder().sharedPrefModule(SharedPrefModule(this)).build().inject(this)

        btnSave?.setOnClickListener {
            sharedPreferences.edit().putString("userName",inUsername?.text.toString().trim()).apply()
            sharedPreferences.edit().putString("number",inNumber?.text.toString().trim()).apply()
            Toast.makeText(this,"Data saved",Toast.LENGTH_LONG).show()
        }

        btnGet?.setOnClickListener {
            Toast.makeText(this,"Data fetched",Toast.LENGTH_LONG).show()
            inUsername.setText(sharedPreferences.getString("userName",""))
            inNumber.setText(sharedPreferences.getString("number",""))
        }
    }
}
