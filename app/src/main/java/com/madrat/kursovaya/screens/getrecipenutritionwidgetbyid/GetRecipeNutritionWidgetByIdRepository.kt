package com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid

import android.content.Context
import com.madrat.kursovaya.screens.getrecipenutritionwidgetbyid.model.GetRecipeNutritionWidgetByIdResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetRecipeNutritionWidgetByIdRepository
    : GetRecipeNutritionWidgetByIdMVP.Repository {
    override fun getRecipeNutritionWidgetByIdObservable(
        context: Context, recipeId: Int, apiKey: String
    ): Observable<GetRecipeNutritionWidgetByIdResponse> {
        return NetworkClient(context).instance()
            .getRecipeNutritionWidgetById(recipeId, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}