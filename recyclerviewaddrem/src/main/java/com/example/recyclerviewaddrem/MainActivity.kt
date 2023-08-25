package com.example.recyclerviewaddrem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewaddrem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<String>()

        val customAdapter = MyCustomAdapter(list)

        binding.recyclerView.adapter = customAdapter

        customAdapter.setListener(object :RecyclerViewListener{
            override fun onItemClick(position: Int) {

            }

            override fun onDeleteBtnClick(position: Int) {
                list.removeAt(position)
                customAdapter.notifyItemRemoved(position)
            }
        })

        binding.addBtn.setOnClickListener {
            val title = binding.addEt.text.toString()
            if(title.isNotBlank()){
                list.add(title.trim())
                customAdapter.notifyItemInserted(list.size)
                binding.addEt.text.clear()
            }
        }
    }
}