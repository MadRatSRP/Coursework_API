package com.madrat.kursovaya.screens.getrecipeingredientsbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ingredient(
    @field:SerializedName("amount")
    @field:Expose
    val amount: Amount,
    
    @field:SerializedName("image")
    @field:Expose
    val image: String,
    
    @field:SerializedName("name")
    @field:Expose
    val name: String
)