package com.example.recyclerviewgalery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewgalery.databinding.ActivityGalleryBinding
import com.example.recyclerviewgalery.databinding.ActivityMainBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf<Int>(
            R.drawable.apple,
            R.drawable.apple1,
            R.drawable.apple,
            R.drawable.banana3,
            R.drawable.apple,
            R.drawable.banana1,
            R.drawable.apple,
            R.drawable.apple,
            R.drawable.apple1,
            R.drawable.apple,
            R.drawable.banana3,
            R.drawable.apple,
            R.drawable.banana1,
            R.drawable.apple,
        )

        val galleryAdapter = GalleryAdapter(list)

        binding.recyclerView.adapter = galleryAdapter
        val myManager = StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)

        binding.recyclerView.apply {
            adapter = galleryAdapter
            layoutManager = myManager
        }

        galleryAdapter.setListener(object :RecyclerViewListener{
            override fun onItemClick(position: Int) {
                Intent(this@GalleryActivity,ImageViewActivity::class.java).apply {
                    putExtra("image",list[position])
                    startActivity(this)

                }

            }
        })
    }
}