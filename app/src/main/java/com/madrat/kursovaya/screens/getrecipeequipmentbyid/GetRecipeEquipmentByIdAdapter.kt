package com.madrat.kursovaya.screens.getrecipeequipmentbyid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGetRecipeEquipmentByIdBinding
import com.madrat.kursovaya.screens.getrecipeequipmentbyid.model.Equipment
import com.madrat.kursovaya.util.loadImageFromUrl

class GetRecipeEquipmentByIdAdapter
    : RecyclerView.Adapter<GetRecipeEquipmentByIdAdapter.GetRecipeEquipmentByIdHolder>() {
    private val listOfEquipments = ArrayList<Equipment>()

    fun updateListOfEquipments(newListOfEquipments: ArrayList<Equipment>) {
        listOfEquipments.clear()
        listOfEquipments.addAll(newListOfEquipments)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetRecipeEquipmentByIdHolder {
        val binding = ListGetRecipeEquipmentByIdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GetRecipeEquipmentByIdHolder(binding)
    }

    override fun onBindViewHolder(holder: GetRecipeEquipmentByIdHolder, position: Int)
        = holder.bind(listOfEquipments[position])

    override fun getItemCount(): Int
        = listOfEquipments.size

    inner class GetRecipeEquipmentByIdHolder (private val binding: ListGetRecipeEquipmentByIdBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(equipment: Equipment) {
            with(binding) {
                equipmentName.text = equipment.name
    
                equipmentImage.loadImageFromUrl(
                    root.context.getString(R.string.base_url_equipment) + equipment.image
                )
            }
        }
    }
}