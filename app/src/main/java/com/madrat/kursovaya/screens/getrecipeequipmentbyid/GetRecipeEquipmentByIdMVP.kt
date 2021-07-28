package com.madrat.kursovaya.screens.getrecipeequipmentbyid

import android.content.Context
import com.madrat.kursovaya.screens.getrecipeequipmentbyid.model.Equipment
import com.madrat.kursovaya.screens.getrecipeequipmentbyid.model.GetRecipeEquipmentByIdResponse
import io.reactivex.rxjava3.core.Observable

interface GetRecipeEquipmentByIdMVP {
    interface View {

        fun initializeAdapterAndRecyclerView()
        fun initializePresenter()
        fun showListOfEquipments(equipment: ArrayList<Equipment>)
        fun showRecyclerView()
    }
    interface Presenter {
        fun getRecipeEquipmentByIdData(context: Context,
                                       recipeId: Int, apiKey: String)
        fun doOnNext(equipment: ArrayList<Equipment>)
        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
    }
    interface Repository {
        fun getRecipeEquipmentByIdObservable(
            context: Context,
            recipeId: Int, apiKey: String
        ): Observable<GetRecipeEquipmentByIdResponse>
    }
}