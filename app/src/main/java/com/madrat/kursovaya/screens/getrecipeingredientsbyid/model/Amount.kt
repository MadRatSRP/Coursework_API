package com.madrat.kursovaya.screens.getrecipeingredientsbyid.model

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