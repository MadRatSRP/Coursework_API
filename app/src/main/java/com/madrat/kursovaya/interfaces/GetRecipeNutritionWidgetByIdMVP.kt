package com.madrat.kursovaya.interfaces

import android.content.Context
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.GetRecipeNutritionWidgetByIdResponse
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition
import io.reactivex.rxjava3.core.Observable

interface GetRecipeNutritionWidgetByIdMVP {
    interface View {
        fun initializeAdapterAndRecyclerView()
        fun initializePresenter()
        fun showRecyclerView()
        fun loadDataIntoViews(response: GetRecipeNutritionWidgetByIdResponse)
        fun showListOfBadNutritions(listOfBadNutritions: ArrayList<Nutrition>)
        fun showListOfGoodNutritions(listOfGoodNutritions: ArrayList<Nutrition>)
    }
    interface Presenter {

        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
        fun getRecipeNutritionWidgetByIdData(context: Context, recipeId: Int, apiKey: String)
    }
    interface Repository {

        fun getRecipeNutritionWidgetByIdObservable(
            context: Context,
            recipeId: Int,
            apiKey: String
        ): Observable<GetRecipeNutritionWidgetByIdResponse>
    }
}