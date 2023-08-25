package com.example.listviewarrayadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewarrayadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fruits = arrayListOf<FruitModel>(
        FruitModel("olma",R.drawable.banana),
        FruitModel("olma",R.drawable.apple),
        FruitModel("olma",R.drawable.banana),
        FruitModel("olma",R.drawable.apple)
    )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomAdapter(this,fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${fruits[position]} tanlandi",Toast.LENGTH_SHORT).show()
            Intent(this,FruitImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)

            }

        }
    }
}