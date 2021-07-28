package com.madrat.kursovaya.screens.getrecipeingredientsbyid

import android.content.Context
import com.madrat.kursovaya.screens.getrecipeingredientsbyid.model.GetRecipeIngredientsByIdResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetRecipeIngredientsByIdRepository
    : GetRecipeIngredientsByIdMVP.Repository {
    override fun getRecipeIngredientsByIdObservable(
        context: Context, recipeId: Int, apiKey: String
    ): Observable<GetRecipeIngredientsByIdResponse> {
        return NetworkClient(context).instance()
            .getRecipeIngredientsById(recipeId, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}