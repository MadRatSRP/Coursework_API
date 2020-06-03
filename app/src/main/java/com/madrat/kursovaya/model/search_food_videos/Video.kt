package com.madrat.kursovaya.model.search_food_videos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Video(
    @field:SerializedName("title")
    @field:Expose
    val title: String,

    @field:SerializedName("length")
    @field:Expose
    val length: Int,

    @field:SerializedName("rating")
    @field:Expose
    val rating: Float,

    @field:SerializedName("shortTitle")
    @field:Expose
    val shortTitle: String,

    @field:SerializedName("thumbnail")
    @field:Expose
    val thumbnail: String,

    @field:SerializedName("views")
    @field:Expose
    val views: Int,

    @field:SerializedName("youTubeId")
    @field:Expose
    val youTubeId: String
)