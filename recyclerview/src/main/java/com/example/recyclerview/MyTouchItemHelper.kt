package com.example.recyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class MyTouchItemHelper():ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN or ItemTouchHelper.UP,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder,
    ): Boolean {

        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition

        onItemMoved(fromPosition,toPosition)

        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        onItemSwipeToDelete(viewHolder.adapterPosition)
    }
    abstract fun onItemSwipeToDelete(position:Int)

    abstract fun onItemMoved(from:Int,to:Int)

}