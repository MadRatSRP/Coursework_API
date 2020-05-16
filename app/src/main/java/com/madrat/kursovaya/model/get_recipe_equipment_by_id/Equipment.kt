package com.madrat.kursovaya.model.get_recipe_equipment_by_id

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Equipment(
    @field:SerializedName("image")
    @field:Expose
    val image: String,

    @field:SerializedName("name")
    @field:Expose
    val name: String
)