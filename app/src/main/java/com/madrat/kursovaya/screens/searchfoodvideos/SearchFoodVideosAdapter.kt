package com.madrat.kursovaya.screens.searchfoodvideos

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListSearchFoodVideosBinding
import com.madrat.kursovaya.screens.searchfoodvideos.model.Video

class SearchFoodVideosAdapter: RecyclerView.Adapter<
    SearchFoodVideosAdapter.SearchFoodVideosHolder
>() {
    private val listOfVideos = ArrayList<Video>()

    fun updateListOfVideos(newListOfVideos: ArrayList<Video>) {
        listOfVideos.clear()
        listOfVideos.addAll(newListOfVideos)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodVideosHolder {
        val binding = ListSearchFoodVideosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchFoodVideosHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchFoodVideosHolder, position: Int)
        = holder.bind(listOfVideos[position])

    override fun getItemCount(): Int
        = listOfVideos.size

    inner class SearchFoodVideosHolder(
        private val binding: ListSearchFoodVideosBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            with(binding) {
                title.text = video.title
    
                videoPreviewImage.load(video.thumbnail)
    
                watchVideoOnYoutubeButton.setOnClickListener {
                    val videoUrl = root.context.getString(
                        R.string.base_url_youtube,
                        video.youTubeId
                    )
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(videoUrl)
                    root.context.startActivity(intent)
                }
            }
        }
    }
}