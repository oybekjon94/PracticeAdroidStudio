package com.example.recyclerviewaddrem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaddrem.databinding.ItemListLayoutBinding

class MyCustomAdapter(val list: List<String>)
    :RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>() {

    private var recyclerViewListener:RecyclerViewListener?= null

    inner class MyViewHolder(val binding: ItemListLayoutBinding):
    RecyclerView.ViewHolder(binding.root){

        init {
            binding.clearBtn.setOnClickListener {
                recyclerViewListener?.onDeleteBtnClick(adapterPosition)
            }
        }

        fun bind(title:String){
            binding.addTv.text = title
        }
    }

    fun setListener(listener: RecyclerViewListener){
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = list[position]
        holder.bind(title)
    }
}