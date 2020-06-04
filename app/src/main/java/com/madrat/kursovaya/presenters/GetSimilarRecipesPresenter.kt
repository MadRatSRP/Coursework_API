package com.madrat.kursovaya.presenters

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.interfaces.GetRecipeIngredientsByIdMVP
import com.madrat.kursovaya.interfaces.GetSimilarRecipesMVP
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition
import com.madrat.kursovaya.model.get_similair_recipes.SimilarRecipe

class GetSimilarRecipesPresenter(private val view: GetSimilarRecipesMVP.View,
                                 private val repository: GetSimilarRecipesMVP.Repository)
    : GetSimilarRecipesMVP.Presenter {
    override fun getSimilarRecipesData(context: Context, recipeId: Int,
                                       apiKey: String, numberOfRecipes: Int) {
        val repository = repository.getSimilarRecipesObservable(
            context, recipeId, apiKey, numberOfRecipes
        )
        repository.subscribe(
            {response ->
                doOnNext(response)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(listOfSimilarRecipes: ArrayList<SimilarRecipe>) {
        view.showListOfSimilarRecipes(listOfSimilarRecipes)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}