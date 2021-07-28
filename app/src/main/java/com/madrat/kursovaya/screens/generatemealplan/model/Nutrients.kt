package com.madrat.kursovaya.screens.generatemealplan.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Nutrients (
    @field:SerializedName("calories")
    @field:Expose
    val calories: Double,

    @field:SerializedName("carbohydrates")
    @field:Expose
    val carbohydrates: Double,

    @field:SerializedName("fat")
    @field:Expose
    val fat: Double,

    @field:SerializedName("protein")
    @field:Expose
    val protein: Double
)