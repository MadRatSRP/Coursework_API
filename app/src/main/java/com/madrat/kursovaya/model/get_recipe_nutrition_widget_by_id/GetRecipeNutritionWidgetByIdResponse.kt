package com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient

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