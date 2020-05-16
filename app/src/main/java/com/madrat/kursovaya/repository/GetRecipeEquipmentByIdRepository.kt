package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.GetRecipeEquipmentByIdMVP
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.GetRecipeEquipmentByIdResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetRecipeEquipmentByIdRepository
    : GetRecipeEquipmentByIdMVP.Repository {
    override fun getRecipeEquipmentByIdObservable(
        context: Context, recipeId: Int, apiKey: String
    ): Observable<GetRecipeEquipmentByIdResponse> {
        return NetworkClient(context).instance()
            .getRecipeEquipmentById(recipeId, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}