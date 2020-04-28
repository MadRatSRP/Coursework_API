package com.madrat.kursovaya.model.search_food_videos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchFoodVideosResponse(
    @field:SerializedName("videos")
    @field:Expose
    val videos: ArrayList<Video>,

    @field:SerializedName("totalResults")
    @field:Expose
    val totalResults: Int
)