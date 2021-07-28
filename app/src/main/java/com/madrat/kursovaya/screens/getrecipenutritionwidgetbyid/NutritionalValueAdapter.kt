package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGetRecipeNutritionWidgetByIdBinding
import com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model.Nutrition

class NutritionalValueAdapter
    : RecyclerView.Adapter<NutritionalValueAdapter.NutritionalValueHolder>() {
    private val listOfNutritions = ArrayList<Nutrition>()

    fun updateListOfNutritions(newListOfNutritions: ArrayList<Nutrition>) {
        listOfNutritions.clear()
        listOfNutritions.addAll(newListOfNutritions)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionalValueHolder {
        val binding = ListGetRecipeNutritionWidgetByIdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NutritionalValueHolder(binding)
    }

    override fun onBindViewHolder(holder: NutritionalValueHolder, position: Int)
        = holder.bind(listOfNutritions[position])

    override fun getItemCount(): Int
        = listOfNutritions.size

    inner class NutritionalValueHolder (
        private val binding: ListGetRecipeNutritionWidgetByIdBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(nutrition: Nutrition) {
            with(binding) {
                nutritionTitleAndAmount.text = root.context.getString(
                    R.string.nutritions_nutrition_title_and_amount,
                    nutrition.title,
                    nutrition.amount
                )
    
                nutritionDailyNeeds.text = root.context.getString(
                    R.string.nutritions_daily_needs,
                    nutrition.percentOfDailyNeeds
                )
            }
        }
    }
}