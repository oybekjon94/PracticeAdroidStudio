package com.example.recyclerviewgalery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewgalery.databinding.ActivityImageViewBinding
import com.example.recyclerviewgalery.databinding.ActivityMainBinding

class ImageViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intent.getIntExtra("image",R.drawable.banana)

        binding.imageView2.setImageResource(imageId)
    }
}