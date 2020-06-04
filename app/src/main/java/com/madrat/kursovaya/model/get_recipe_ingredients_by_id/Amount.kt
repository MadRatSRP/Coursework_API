package com.madrat.kursovaya.model.get_recipe_ingredients_by_id

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Amount(
    @field:SerializedName("metric")
    @field:Expose
    val metricMeasuringSystem: MeasuringSystem,

    @field:SerializedName("us")
    @field:Expose
    val usMeasuringSystem: MeasuringSystem
)