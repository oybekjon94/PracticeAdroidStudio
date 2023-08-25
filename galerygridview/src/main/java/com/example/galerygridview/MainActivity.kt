package com.example.galerygridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.galerygridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val imageList = arrayListOf<Int>(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple,
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.apple
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GaleryAdapter(context = this,imageList)

        binding.gridView.adapter = adapter
        
        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${imageList[position]} tanladingiz",Toast.LENGTH_SHORT).show()
            Intent(this,SecondImAc::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}