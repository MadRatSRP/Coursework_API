package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.GetSimilarRecipesMVP
import com.madrat.kursovaya.model.get_similair_recipes.SimilarRecipe
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetSimilarRecipesRepository
    : GetSimilarRecipesMVP.Repository {
    override fun getSimilarRecipesObservable(
        context: Context, recipeId: Int,
        apiKey: String, numberOfRecipes: Int
    ): Observable<ArrayList<SimilarRecipe>> {
        return NetworkClient(context).instance()
            .getSimilarRecipes(recipeId, apiKey, numberOfRecipes)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}