package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model.GetRecipeNutritionWidgetByIdResponse

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
                doOnNext(response)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    fun doOnNext(response: GetRecipeNutritionWidgetByIdResponse) {
        view.loadDataIntoViews(response)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}