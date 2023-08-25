package com.example.fristmultplepageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fristmultplepageapp.databinding.ActivityGridViewBinding

class GridViewAc : AppCompatActivity() {
    private lateinit var binding: ActivityGridViewBinding
    private val imageList = arrayListOf<Int>(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GalreyAdapter(context = this,imageList)
        binding.gridview.adapter = adapter

    }
}