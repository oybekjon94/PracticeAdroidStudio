package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expandablelistview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val groupList = mutableListOf<String>()
        val childMap = mutableMapOf<String,List<String>>()
        repeat(5){groupId ->
            groupList.add( "Group $groupId")
            val childNumber = Random.nextInt(10)
            val tempList = mutableListOf<String>()
            repeat(childNumber){childId->
                tempList.add("Child $childId in Group $groupId")
            }
            childMap["Group $groupId"] = tempList
        }
        val adapter = CustomAdapter(this,groupList,childMap)
        binding.expandableListV.setAdapter(adapter)


    }
}