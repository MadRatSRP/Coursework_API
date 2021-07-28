package com.madrat.kursovaya.screens.getrecipeequipmentbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Equipment(
    @field:SerializedName("image")
    @field:Expose
    val image: String,

    @field:SerializedName("name")
    @field:Expose
    val name: String
)