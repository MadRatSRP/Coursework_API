package com.madrat.kursovaya.model.get_recipe_ingredients_by_id

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