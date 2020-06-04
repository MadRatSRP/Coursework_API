package com.madrat.kursovaya.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
import com.madrat.kursovaya.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_get_recipe_equipment_by_id.*
import kotlinx.android.synthetic.main.list_get_recipe_ingredients_by_id.*

class GetRecipeIngredientsByIdAdapter
    : RecyclerView.Adapter<GetRecipeIngredientsByIdAdapter.GetRecipeIngredientByIdHolder>() {
    private val listOfIngredients = ArrayList<Ingredient>()

    fun updateListOfIngredients(newListOfIngredients: ArrayList<Ingredient>) {
        listOfIngredients.clear()
        listOfIngredients.addAll(newListOfIngredients)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetRecipeIngredientByIdHolder
            = GetRecipeIngredientByIdHolder(parent.inflate(R.layout.list_get_recipe_ingredients_by_id))

    override fun onBindViewHolder(holder: GetRecipeIngredientByIdHolder, position: Int)
            = holder.bind(listOfIngredients[position])

    override fun getItemCount(): Int
            = listOfIngredients.size

    inner class GetRecipeIngredientByIdHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(ingredient: Ingredient) {
            ingredient_name.text = ingredient.name
        }
    }
}