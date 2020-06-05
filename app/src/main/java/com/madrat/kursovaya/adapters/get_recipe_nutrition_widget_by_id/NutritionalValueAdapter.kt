package com.madrat.kursovaya.adapters.get_recipe_nutrition_widget_by_id

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition
import com.madrat.kursovaya.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_get_recipe_nutrition_widget_by_id.*

class NutritionalValueAdapter
    : RecyclerView.Adapter<NutritionalValueAdapter.NutritionalValueHolder>() {
    private val listOfNutritions = ArrayList<Nutrition>()

    fun updateListOfNutritions(newListOfNutritions: ArrayList<Nutrition>) {
        listOfNutritions.clear()
        listOfNutritions.addAll(newListOfNutritions)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionalValueHolder
            = NutritionalValueHolder(parent.inflate(R.layout.list_get_recipe_nutrition_widget_by_id))

    override fun onBindViewHolder(holder: NutritionalValueHolder, position: Int)
            = holder.bind(listOfNutritions[position])

    override fun getItemCount(): Int
            = listOfNutritions.size

    inner class NutritionalValueHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(nutrition: Nutrition) {
            nutrition_title_and_amount.text = containerView.context.getString(
                R.string.nutritions_nutrition_title_and_amount, nutrition.title, nutrition.amount
            )

            nutrition_daily_needs.text = containerView.context.getString(
                R.string.nutritions_daily_needs, nutrition.percentOfDailyNeeds
            )
        }
    }
}