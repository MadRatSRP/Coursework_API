package com.madrat.kursovaya.model.generate_meal_plan

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