package com.example.fristmultplepageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.fristmultplepageapp.databinding.ActivityViewListPageBinding

class ViewListPage : AppCompatActivity() {

    private val fruits = arrayListOf<String>("Olma","Nok","banana","o'rik","shaftoli")

    private lateinit var binding: ActivityViewListPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewListPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${fruits[position]} tanlandi",Toast.LENGTH_SHORT).show()
            Intent(this,FruitImage::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
                finish()
            }
        }
    }
}