package com.example.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistview.databinding.ChildLayoutBinding
import com.example.expandablelistview.databinding.GroupLayoutBinding

class CustomAdapter(
    context: Context,
    val groupList:List<String>,
    val childMap:Map<String,List<String>>
    ):BaseExpandableListAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        val groupName = groupList[p0]
        return childMap[groupName]?.size ?:0
    }

    override fun getGroup(p0: Int): Any {
        return groupList[p0]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val groupName = groupList[groupPosition]
        return childMap[groupName]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?,
    ): View {
        val binding:GroupLayoutBinding = if (convertView == null){
            GroupLayoutBinding.inflate(inflater,convertView,false)
        }else{
            GroupLayoutBinding.bind(convertView)
        }
        binding.groupTv.text = groupList[groupPosition]
        return binding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?,
    ): View {
        val groupName = groupList[groupPosition]
        val childName = childMap[groupName]?.get(groupPosition)

        val binding:ChildLayoutBinding = if (convertView == null){
            ChildLayoutBinding.inflate(inflater,parent,false)
        }else{
            ChildLayoutBinding.bind(convertView)
        }
        binding.childTv.text = childName
        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}