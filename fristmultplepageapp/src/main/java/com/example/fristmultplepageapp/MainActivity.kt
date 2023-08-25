package com.example.fristmultplepageapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.fristmultplepageapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)

        binding.person.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_anim))
        binding.editTextText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.left_anim))
        binding.editTextText2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_anim))
        binding.editTextText3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.left_anim))
        binding.nextPage.startAnimation(AnimationUtils.loadAnimation(this,R.anim.btn_bottom))
        binding.nextPage.startAnimation(AnimationUtils.loadAnimation(this,R.anim.btn_bottom))


        binding.nextPage.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val surname = binding.editTextText2.text.toString()
            val age = binding.editTextText3.text.toString()


            if (name.isNotBlank() && surname.isNotBlank() && age.isNotBlank()){
                sharedPreferences.edit().putString("name",name).apply()
                sharedPreferences.edit().putString("surname",surname).apply()
                sharedPreferences.edit().putString("age",age).apply()

                val intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Malumotlaringiz kiritilishi shart!",Toast.LENGTH_SHORT).show()
            }

        }
    }

}