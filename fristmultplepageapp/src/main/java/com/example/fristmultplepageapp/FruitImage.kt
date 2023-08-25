package com.example.fristmultplepageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.fristmultplepageapp.databinding.ActivityFruitImageBinding
import com.example.fristmultplepageapp.databinding.ActivityViewListPageBinding

class FruitImage : AppCompatActivity() {
    private lateinit var binding: ActivityFruitImageBinding
    private val fruits = arrayListOf<String>("Olma","Nok","banana","o'rik","shaftoli")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFruitImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)

        supportActionBar?.title = fruits[position]

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0->binding.imageView2.setImageResource(R.drawable.banana)
            1->binding.imageView2.setImageResource(R.drawable.apple)
            2->binding.imageView2.setImageResource(R.drawable.banana)
            3->binding.imageView2.setImageResource(R.drawable.apple)
            4->binding.imageView2.setImageResource(R.drawable.banana)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}