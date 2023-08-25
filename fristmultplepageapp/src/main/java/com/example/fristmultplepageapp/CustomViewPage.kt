package com.example.fristmultplepageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fristmultplepageapp.databinding.ActivityCustomViewPageBinding

class CustomViewPage : AppCompatActivity() {

    private val fruit = arrayListOf<FruitModel>(
        FruitModel("Olma",R.drawable.apple),
        FruitModel("nok",R.drawable.banana),
        FruitModel("banana",R.drawable.apple),
        FruitModel("uzum",R.drawable.banana),
        FruitModel("shaftoli",R.drawable.apple),
    )
    private lateinit var binding:ActivityCustomViewPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}