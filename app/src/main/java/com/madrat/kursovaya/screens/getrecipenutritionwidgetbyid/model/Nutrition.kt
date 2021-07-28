package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Nutrition(
    @field:SerializedName("amount")
    @field:Expose
    val amount: String,

    @field:SerializedName("indented")
    @field:Expose
    val indented: Boolean,

    @field:SerializedName("percentOfDailyNeeds")
    @field:Expose
    val percentOfDailyNeeds: Float,

    @field:SerializedName("title")
    @field:Expose
    val title: String
)