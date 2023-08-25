package com.example.fristmultplepageapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fristmultplepageapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

       sharedPreferences = getSharedPreferences("db", Context.MODE_PRIVATE)

       binding.nameTv.text = sharedPreferences.getString("name","")
       binding.surnameTv.text = sharedPreferences.getString("surname","")
       binding.ageTv.text = sharedPreferences.getString("age","")

        binding.clearBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            finish()
        }

        binding.nextBtn.setOnClickListener {
            Intent(this,ThirdActivity::class.java).apply {
                startActivity(this)
            }

        }
    }
}