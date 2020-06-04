package com.madrat.kursovaya.model.get_recipe_ingredients_by_id

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetRecipeIngredientsByIdResponse(
    @field:SerializedName("ingredients")
    @field:Expose
    val listOfIngredients: ArrayList<Ingredient>
)