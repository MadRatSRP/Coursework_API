package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetRecipeNutritionWidgetByIdResponse(
    @field:SerializedName("calories")
    @field:Expose
    val calories: String,
    
    @field:SerializedName("carbs")
    @field:Expose
    val carbs: String,
    
    @field:SerializedName("fat")
    @field:Expose
    val fat: String,
    
    @field:SerializedName("protein")
    @field:Expose
    val protein: String,
    
    @field:SerializedName("bad")
    @field:Expose
    val listOfBadNutritions: ArrayList<Nutrition>,
    
    @field:SerializedName("good")
    @field:Expose
    val listOfGoodNutritions: ArrayList<Nutrition>
)