package com.example.fristmultplepageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.fristmultplepageapp.databinding.ListItemBinding

class CustomAdapter(context: Context,val fruitList:ArrayList<FruitModel>)
    :ArrayAdapter<FruitModel>(context,R.layout.list_item,fruitList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding:ListItemBinding = if(convertView == null){
            ListItemBinding.inflate(LayoutInflater.from(context),parent,false)

        }else{
            ListItemBinding.bind(convertView)
        }

        binding.fruitNameTv.text = fruitList[position].name
        binding.fruitIm.setImageResource(fruitList[position].image)

        return binding.root
    }
}