package com.example.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homepage.activity.DarslarActivity
import com.example.homepage.databinding.DarslarBinding
import com.example.homepage.model.DarslarModel

class DarsAdapter(val items: List<DarslarModel>): RecyclerView.Adapter<DarsAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: DarslarBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(DarslarBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.binding.caytegoryImg.setImageResource(item.img)
        holder.binding.categoryTxt.text = item.name
        holder.itemView.setOnClickListener {
            // Activitydan itemni boshqarish
            (holder.itemView.context as DarslarActivity).onItemClick(item)
        }
    }

}