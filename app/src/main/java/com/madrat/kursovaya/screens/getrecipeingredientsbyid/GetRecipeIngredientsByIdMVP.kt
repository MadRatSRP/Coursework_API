package com.madrat.kursovaya.screens.getrecipeingredientsbyid

import android.content.Context
import com.madrat.kursovaya.screens.getrecipeingredientsbyid.model.GetRecipeIngredientsByIdResponse
import com.madrat.kursovaya.screens.getrecipeingredientsbyid.model.Ingredient
import io.reactivex.rxjava3.core.Observable

interface GetRecipeIngredientsByIdMVP {
    interface View {
        fun initializeAdapterAndRecyclerView()
        fun initializePresenter()
        fun showRecyclerView()
        fun showListOfIngredients(listOfIngredients: ArrayList<Ingredient>)
    }
    interface Presenter {

        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
        fun doOnNext(listOfIngredients: ArrayList<Ingredient>)
        fun getRecipeIngredientsByIdData(context: Context, recipeId: Int, apiKey: String)
    }
    interface Repository {
        fun getRecipeIngredientsByIdObservable(context: Context, recipeId: Int,
                                               apiKey: String)
                : Observable<GetRecipeIngredientsByIdResponse>
    }
}