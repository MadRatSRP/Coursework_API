package com.madrat.kursovaya.screens.searchmenuitems

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.madrat.kursovaya.databinding.ListSearchMenuItemsBinding
import com.madrat.kursovaya.screens.searchmenuitems.model.MenuItem

class SearchMenuItemsAdapter: RecyclerView.Adapter<
    SearchMenuItemsAdapter.SearchMenuItemsHolder
>() {
    private val listOfMenuItems = ArrayList<MenuItem>()
    
    fun updateListOfMenuItems(newListOfMenuItems: ArrayList<MenuItem>) {
        listOfMenuItems.clear()
        listOfMenuItems.addAll(newListOfMenuItems)
        this.notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMenuItemsHolder {
        val binding = ListSearchMenuItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchMenuItemsHolder(binding)
    }
    
    override fun onBindViewHolder(holder: SearchMenuItemsHolder, position: Int)
        = holder.bind(listOfMenuItems[position])
    
    override fun getItemCount(): Int
        = listOfMenuItems.size
    
    inner class SearchMenuItemsHolder(
        private val binding: ListSearchMenuItemsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: MenuItem) {
            with(binding) {
                title.text = menuItem.title
                
                image.load(menuItem.imageUrl)
                
                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(menuItem.imageUrl)
                    root.context.startActivity(intent)
                }
            }
        }
    }
}