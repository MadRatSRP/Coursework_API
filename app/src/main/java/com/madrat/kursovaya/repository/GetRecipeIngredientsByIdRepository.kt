package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.GetRecipeIngredientsByIdMVP
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.GetRecipeEquipmentByIdResponse
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.GetRecipeIngredientsByIdResponse
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