package com.madrat.kursovaya.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGetSimilarRecipesBinding
import com.madrat.kursovaya.model.get_similair_recipes.SimilarRecipe
import com.madrat.kursovaya.util.loadImageFromUrl

class GetSimilarRecipesAdapter
    : RecyclerView.Adapter<GetSimilarRecipesAdapter.GetSimilarRecipesHolder>() {
    private val listOfSimilarRecipes = ArrayList<SimilarRecipe>()

    fun updateListOfSimilarRecipes(newListOfSimilarRecipes: ArrayList<SimilarRecipe>) {
        listOfSimilarRecipes.clear()
        listOfSimilarRecipes.addAll(newListOfSimilarRecipes)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetSimilarRecipesHolder {
        val binding = ListGetSimilarRecipesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GetSimilarRecipesHolder(binding)
    }

    override fun onBindViewHolder(holder: GetSimilarRecipesHolder, position: Int)
        = holder.bind(listOfSimilarRecipes[position])

    override fun getItemCount(): Int
        = listOfSimilarRecipes.size

    inner class GetSimilarRecipesHolder(
        private val binding: ListGetSimilarRecipesBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(similarRecipe: SimilarRecipe) {
            with(binding) {
                title.text = similarRecipe.title
    
                image.loadImageFromUrl(
                    root.context.getString(
                        R.string.base_url_recipes,
                        similarRecipe.id,
                        similarRecipe.imageType
                    )
                )
            }
        }
    }
}