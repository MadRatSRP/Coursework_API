package com.madrat.kursovaya.screens.getrecipeingredientsbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MeasuringSystem(
    @field:SerializedName("value")
    @field:Expose
    val value: Float,

    @field:SerializedName("unit")
    @field:Expose
    val unit: String?
)