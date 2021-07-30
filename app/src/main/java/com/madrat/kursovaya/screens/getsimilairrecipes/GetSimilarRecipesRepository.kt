package com.madrat.kursovaya.screens.getsimilairrecipes

import android.content.Context
import com.madrat.kursovaya.screens.getsimilairrecipes.model.SimilarRecipe
import com.madrat.kursovaya.util.AppDependencies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetSimilarRecipesRepository: GetSimilarRecipesMVP.Repository {
    private val networkService: GetSimilarRecipesNetwork = AppDependencies.retrofit!!.create(
        GetSimilarRecipesNetwork::class.java
    )
    
    override fun getSimilarRecipesObservable(
        context: Context,
        recipeId: Int,
        apiKey: String,
        numberOfRecipes: Int
    ): Observable<ArrayList<SimilarRecipe>> {
        return networkService
            .getSimilarRecipes(
                recipeId,
                apiKey,
                numberOfRecipes
            )
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(
                AndroidSchedulers.mainThread()
            )
    }
}