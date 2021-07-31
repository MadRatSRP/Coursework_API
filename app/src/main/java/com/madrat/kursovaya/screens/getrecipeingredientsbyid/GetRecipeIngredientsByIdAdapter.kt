package com.madrat.kursovaya.screens.getrecipeingredientsbyid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGetRecipeIngredientsByIdBinding
import com.madrat.kursovaya.screens.getrecipeingredientsbyid.model.Ingredient

class GetRecipeIngredientsByIdAdapter: RecyclerView.Adapter<
    GetRecipeIngredientsByIdAdapter.GetRecipeIngredientByIdHolder
>() {
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
    
                ingredientImage.load(
                    root.context.getString(R.string.base_url_ingredients) + ingredient.image
                )
            }
        }
    }
}