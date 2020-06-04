package com.madrat.kursovaya.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment
import com.madrat.kursovaya.util.inflate
import com.madrat.kursovaya.util.loadImageFromUrl
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_get_recipe_equipment_by_id.*

class GetRecipeEquipmentByIdAdapter
    : RecyclerView.Adapter<GetRecipeEquipmentByIdAdapter.GetRecipeEquipmentByIdHolder>() {
    private val listOfEquipments = ArrayList<Equipment>()

    fun updateListOfEquipments(newListOfEquipments: ArrayList<Equipment>) {
        listOfEquipments.clear()
        listOfEquipments.addAll(newListOfEquipments)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetRecipeEquipmentByIdHolder
            = GetRecipeEquipmentByIdHolder(parent.inflate(R.layout.list_get_recipe_equipment_by_id))

    override fun onBindViewHolder(holder: GetRecipeEquipmentByIdHolder, position: Int)
            = holder.bind(listOfEquipments[position])

    override fun getItemCount(): Int
            = listOfEquipments.size

    inner class GetRecipeEquipmentByIdHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(equipment: Equipment) {
            /*title.text = meal.title
            ready_in_minutes_value.text = meal.readyInMinutes.toString()
            servings_value.text = meal.servings.toString()
            url.text = meal.sourceUrl*/

            equipment_image.loadImageFromUrl(
                containerView.context.getString(R.string.base_url_equipment) + equipment.image
            )
            equipment_name.text = equipment.name
        }
    }
}