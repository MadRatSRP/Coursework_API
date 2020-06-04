package com.madrat.kursovaya.presenters

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.interfaces.GetRecipeIngredientsByIdMVP
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient

class GetRecipeIngredientsByIdPresenter(private val view: GetRecipeIngredientsByIdMVP.View,
                                        private val repository: GetRecipeIngredientsByIdMVP.Repository)
    : GetRecipeIngredientsByIdMVP.Presenter {
    override fun getRecipeIngredientsByIdData(context: Context,
                                              recipeId: Int, apiKey: String) {
        val repository = repository.getRecipeIngredientsByIdObservable(
            context, recipeId, apiKey
        )
        repository.subscribe(
            {response ->
                doOnNext(response.listOfIngredients)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(listOfIngredients: ArrayList<Ingredient>) {
        view.showListOfIngredients(listOfIngredients)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}