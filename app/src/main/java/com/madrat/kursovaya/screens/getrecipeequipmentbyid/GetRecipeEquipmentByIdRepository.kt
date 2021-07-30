package com.madrat.kursovaya.screens.getrecipeequipmentbyid

import android.content.Context
import com.madrat.kursovaya.screens.getrecipeequipmentbyid.model.GetRecipeEquipmentByIdResponse
import com.madrat.kursovaya.util.AppDependencies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetRecipeEquipmentByIdRepository: GetRecipeEquipmentByIdMVP.Repository {
    private val networkService: GetRecipeEquipmentByIdNetwork = AppDependencies.retrofit!!.create(
        GetRecipeEquipmentByIdNetwork::class.java
    )
    
    override fun getRecipeEquipmentByIdObservable(
        context: Context,
        recipeId: Int,
        apiKey: String
    ): Observable<GetRecipeEquipmentByIdResponse> {
        return networkService
            .getRecipeEquipmentById(
                recipeId,
                apiKey
            )
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(
                AndroidSchedulers.mainThread()
            )
    }
}