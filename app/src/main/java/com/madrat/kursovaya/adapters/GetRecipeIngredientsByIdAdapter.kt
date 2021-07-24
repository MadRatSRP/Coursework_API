package com.madrat.kursovaya.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGetRecipeIngredientsByIdBinding
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
import com.madrat.kursovaya.util.loadImageFromUrl

class GetRecipeIngredientsByIdAdapter
    : RecyclerView.Adapter<GetRecipeIngredientsByIdAdapter.GetRecipeIngredientByIdHolder>() {
    private val listOfIngredients = ArrayList<Ingredient>()

    fun updateListOfIngredients(
        newListOfIngredients: ArrayList<Ingredient>
    ) {
        listOfIngredients.clear()
        listOfIngredients.addAll(newListOfIngredients)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetRecipeIngredientByIdHolder {
        val binding = ListGetRecipeIngredientsByIdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GetRecipeIngredientByIdHolder(binding)
    }

    override fun onBindViewHolder(holder: GetRecipeIngredientByIdHolder, position: Int)
        = holder.bind(listOfIngredients[position])

    override fun getItemCount(): Int
        = listOfIngredients.size

    inner class GetRecipeIngredientByIdHolder(
        private val binding: ListGetRecipeIngredientsByIdBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient) {
            with(binding) {
                ingredientName.text = ingredient.name
    
                ingredientImage.loadImageFromUrl(
                    root.context.getString(R.string.base_url_ingredients) + ingredient.image
                )
            }
        }
    }
}