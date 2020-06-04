package com.madrat.kursovaya.presenters

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.interfaces.GetRecipeNutritionWidgetByIdMVP
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition

class GetRecipeNutritionWidgetByIdPresenter(private val view: GetRecipeNutritionWidgetByIdMVP.View,
                                            private val repository: GetRecipeNutritionWidgetByIdMVP.Repository)
    : GetRecipeNutritionWidgetByIdMVP.Presenter {
    override fun getRecipeNutritionWidgetByIdData(context: Context,
                                                  recipeId: Int, apiKey: String) {
        val repository = repository.getRecipeNutritionWidgetByIdObservable(
            context, recipeId, apiKey
        )
        repository.subscribe(
            {response ->
                doOnNext(response.listOfBadNutritions)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(listOfNutritions: ArrayList<Nutrition>) {
        view.showListOfNutritions(listOfNutritions)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}