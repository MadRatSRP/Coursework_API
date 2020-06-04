package com.madrat.kursovaya.interfaces

import android.content.Context
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.GetRecipeIngredientsByIdResponse
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
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