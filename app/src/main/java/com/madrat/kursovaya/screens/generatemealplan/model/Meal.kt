package com.madrat.kursovaya.screens.generatemealplan.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meal(
    @field:SerializedName("id")
    @field:Expose
    val id: Int,

    @field:SerializedName("title")
    @field:Expose
    val title: String,

    @field:SerializedName("imageType")
    @field:Expose
    val imageType: String,

    @field:SerializedName("readyInMinutes")
    @field:Expose
    val readyInMinutes: Int,

    @field:SerializedName("servings")
    @field:Expose
    val servings: Int,

    @field:SerializedName("sourceUrl")
    @field:Expose
    val sourceUrl: String
)