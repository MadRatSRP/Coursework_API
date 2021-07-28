package com.madrat.kursovaya.screens.searchmenuitems.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchMenuItemsResponse(
    @field:SerializedName("menuItems")
    @field:Expose
    val listOfMenuItems: ArrayList<MenuItem>,
    
    @field:SerializedName("totalMenuItems")
    @field:Expose
    val totalMenuItems: Int,
    
    @field:SerializedName("type")
    @field:Expose
    val type: String,
    
    @field:SerializedName("offset")
    @field:Expose
    val offset: Int,
    
    @field:SerializedName("number")
    @field:Expose
    val number: Int
)