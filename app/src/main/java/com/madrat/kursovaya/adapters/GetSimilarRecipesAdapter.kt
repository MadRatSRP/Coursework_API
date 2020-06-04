package com.madrat.kursovaya.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
import com.madrat.kursovaya.model.get_similair_recipes.SimilarRecipe
import com.madrat.kursovaya.util.inflate
import com.madrat.kursovaya.util.loadImageFromUrl
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_get_recipe_ingredients_by_id.*
import kotlinx.android.synthetic.main.list_get_similar_recipes.*

class GetSimilarRecipesAdapter
    : RecyclerView.Adapter<GetSimilarRecipesAdapter.GetSimilarRecipesHolder>() {
    private val listOfSimilarRecipes = ArrayList<SimilarRecipe>()

    fun updateListOfSimilarRecipes(newListOfSimilarRecipes: ArrayList<SimilarRecipe>) {
        listOfSimilarRecipes.clear()
        listOfSimilarRecipes.addAll(newListOfSimilarRecipes)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetSimilarRecipesHolder
            = GetSimilarRecipesHolder(parent.inflate(R.layout.list_get_similar_recipes))

    override fun onBindViewHolder(holder: GetSimilarRecipesHolder, position: Int)
            = holder.bind(listOfSimilarRecipes[position])

    override fun getItemCount(): Int
            = listOfSimilarRecipes.size

    inner class GetSimilarRecipesHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(similarRecipe: SimilarRecipe) {
            title.text = similarRecipe.title

            image.loadImageFromUrl(
                containerView.context.getString(
                    R.string.base_url_recipes, similarRecipe.id, similarRecipe.imageType
                )
            )
        }
    }
}