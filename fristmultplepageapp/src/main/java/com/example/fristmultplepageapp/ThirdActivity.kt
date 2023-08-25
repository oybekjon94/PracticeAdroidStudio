package com.example.fristmultplepageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fristmultplepageapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       binding.listViewBtn.setOnClickListener {
           Intent(this,ViewListPage::class.java).apply {
               startActivity(this)
               finish()
           }

       }

        binding.customAdBtn.setOnClickListener {
            Intent(this,CustomViewPage::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        binding.gridViewBtn.setOnClickListener {
            Intent(this,GridViewAc::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}