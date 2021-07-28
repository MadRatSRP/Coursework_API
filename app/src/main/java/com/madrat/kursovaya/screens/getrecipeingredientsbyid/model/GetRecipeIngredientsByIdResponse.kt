package com.madrat.kursovaya.screens.getrecipeingredientsbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetRecipeIngredientsByIdResponse(
    @field:SerializedName("ingredients")
    @field:Expose
    val listOfIngredients: ArrayList<Ingredient>
)