package com.madrat.kursovaya.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.model.search_menu_items.MenuItem
import com.madrat.kursovaya.util.inflate
import com.madrat.kursovaya.util.loadImageFromUrl
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_search_food_videos.*
import kotlinx.android.synthetic.main.list_search_food_videos.title
import kotlinx.android.synthetic.main.list_search_menu_items.*

class SearchMenuItemsAdapter
    : RecyclerView.Adapter<SearchMenuItemsAdapter.SearchMenuItemsHolder>() {
    private val listOfMenuItems = ArrayList<MenuItem>()

    fun updateListOfMenuItems(newListOfMenuItems: ArrayList<MenuItem>) {
        listOfMenuItems.clear()
        listOfMenuItems.addAll(newListOfMenuItems)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMenuItemsHolder
            = SearchMenuItemsHolder(parent.inflate(R.layout.list_search_menu_items))

    override fun onBindViewHolder(holder: SearchMenuItemsHolder, position: Int)
            = holder.bind(listOfMenuItems[position])

    override fun getItemCount(): Int
            = listOfMenuItems.size

    inner class SearchMenuItemsHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(menuItem: MenuItem) {
            title.text = menuItem.title

            image.loadImageFromUrl(menuItem.imageUrl)

            containerView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(menuItem.imageUrl)
                containerView.context.startActivity(intent)
            }
        }
    }
}