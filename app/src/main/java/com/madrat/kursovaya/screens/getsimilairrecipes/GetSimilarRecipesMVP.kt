package com.madrat.kursovaya.screens.getsimilairrecipes

import android.content.Context
import com.madrat.kursovaya.screens.getsimilairrecipes.model.SimilarRecipe
import io.reactivex.rxjava3.core.Observable

interface GetSimilarRecipesMVP {
    interface View {

        fun initializeAdapterAndRecyclerView()
        fun initializePresenter()
        fun showRecyclerView()
        fun showListOfSimilarRecipes(listOfSimilarRecipes: ArrayList<SimilarRecipe>)
    }
    interface Presenter {

        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
        fun doOnNext(listOfSimilarRecipes: ArrayList<SimilarRecipe>)
        fun getSimilarRecipesData(
            context: Context,
            recipeId: Int,
            apiKey: String,
            numberOfRecipes: Int
        )
    }
    interface Repository {
        fun getSimilarRecipesObservable(
            context: Context,
            recipeId: Int,
            apiKey: String,
            numberOfRecipes: Int
        ): Observable<ArrayList<SimilarRecipe>>
    }
}