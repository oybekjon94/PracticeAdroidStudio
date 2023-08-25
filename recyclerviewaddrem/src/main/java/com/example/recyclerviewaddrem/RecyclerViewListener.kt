package com.example.recyclerviewaddrem

interface RecyclerViewListener {
    fun onItemClick(position:Int)

    fun onDeleteBtnClick(position: Int)
}