package com.example.galerygridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.galerygridview.databinding.ActivitySecondImBinding

class SecondImAc : AppCompatActivity() {
    private lateinit var binding: ActivitySecondImBinding
    private val imageList = arrayListOf<String>(
        "olma","nok","banana"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondImBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0->binding.imageView2.setImageResource(R.drawable.apple)
            1->binding.imageView2.setImageResource(R.drawable.banana)
            2->binding.imageView2.setImageResource(R.drawable.apple)
            3->binding.imageView2.setImageResource(R.drawable.banana)
            4->binding.imageView2.setImageResource(R.drawable.apple)
            5->binding.imageView2.setImageResource(R.drawable.banana)
            6->binding.imageView2.setImageResource(R.drawable.apple)
            7->binding.imageView2.setImageResource(R.drawable.banana)
            8->binding.imageView2.setImageResource(R.drawable.apple)
            9->binding.imageView2.setImageResource(R.drawable.banana)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}