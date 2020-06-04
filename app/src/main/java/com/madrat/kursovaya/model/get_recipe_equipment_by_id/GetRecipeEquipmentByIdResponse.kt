package com.madrat.kursovaya.model.get_recipe_equipment_by_id

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetRecipeEquipmentByIdResponse(
    @field:SerializedName("equipment")
    @field:Expose
    val listOfEquipment: ArrayList<Equipment>
)