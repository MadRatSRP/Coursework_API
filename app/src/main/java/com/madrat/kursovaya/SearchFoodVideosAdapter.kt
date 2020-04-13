package com.madrat.kursovaya

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_search_food_videos.*

class SearchFoodVideosAdapter
    : RecyclerView.Adapter<SearchFoodVideosAdapter.SearchFoodVideosHolder>() {
    private val listOfVideos = ArrayList<Video>()

    fun updateListOfVideos(newListOfVideos: ArrayList<Video>) {
        listOfVideos.clear()
        listOfVideos.addAll(newListOfVideos)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodVideosHolder
            = SearchFoodVideosHolder(parent.inflate(R.layout.list_search_food_videos))

    override fun onBindViewHolder(holder: SearchFoodVideosHolder, position: Int)
            = holder.bind(listOfVideos[position])

    override fun getItemCount(): Int
            = listOfVideos.size

    inner class SearchFoodVideosHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(video: Video) {
            textView.text = video.youTubeId
        }
    }
}