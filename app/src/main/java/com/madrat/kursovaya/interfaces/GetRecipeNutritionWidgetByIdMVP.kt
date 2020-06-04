package com.madrat.kursovaya.interfaces

import android.content.Context
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.GetRecipeNutritionWidgetByIdResponse
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition
import io.reactivex.rxjava3.core.Observable

interface GetRecipeNutritionWidgetByIdMVP {
    interface View {
        fun initializeAdapterAndRecyclerView()
        fun initializePresenter()
        fun showListOfNutritions(listOfNutritions: ArrayList<Nutrition>)
        fun showRecyclerView()
    }
    interface Presenter {

        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
        fun doOnNext(listOfNutritions: ArrayList<Nutrition>)
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