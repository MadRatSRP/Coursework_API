package com.madrat.kursovaya.screens.getrecipeequipmentbyid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetRecipeEquipmentByIdResponse(
    @field:SerializedName("equipment")
    @field:Expose
    val listOfEquipment: ArrayList<Equipment>
)