package com.madrat.kursovaya.screens.getsimilairrecipes

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.screens.getsimilairrecipes.model.SimilarRecipe

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