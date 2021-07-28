package com.madrat.kursovaya.screens.searchmenuitems.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MenuItem(
    @field:SerializedName("id")
    @field:Expose
    val id: Int,

    @field:SerializedName("title")
    @field:Expose
    val title: String,

    @field:SerializedName("restaurantChain")
    @field:Expose
    val restaurantChain: String,

    @field:SerializedName("image")
    @field:Expose
    val imageUrl: String,

    @field:SerializedName("imageType")
    @field:Expose
    val imageType: String,

    @field:SerializedName("readableServingSize")
    @field:Expose
    val readableServingSize: String?,

    @field:SerializedName("servingSize")
    @field:Expose
    val servingSize: String?
)