package com.ifs21016.dinopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ifs21016.dinopedia.databinding.ActivityMainBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnMainPage: Button = findViewById(R.id.btn_main_page)
        btnMainPage.setOnClickListener{
            val mainIntent: Intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(mainIntent)
        }


    }
}