package com.madrat.kursovaya.screens.generatemealplan.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenerateMealPlanResponse(
    @field:SerializedName("meals")
    @field:Expose
    val meals: ArrayList<Meal>,
    
    @field:SerializedName("nutrients")
    @field:Expose
    val nutrients: Nutrients
)