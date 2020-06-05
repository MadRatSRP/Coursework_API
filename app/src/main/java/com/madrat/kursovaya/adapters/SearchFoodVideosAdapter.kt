package com.madrat.kursovaya.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.util.inflate
import com.madrat.kursovaya.util.loadImageFromUrl
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
            title.text = video.title

            video_preview_image.loadImageFromUrl(video.thumbnail)

            watch_video_on_youtube_button.setOnClickListener {
                val videoUrl = containerView.context.getString(
                    R.string.base_url_youtube, video.youTubeId
                )
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(videoUrl)
                containerView.context.startActivity(intent)
            }
        }
    }
}