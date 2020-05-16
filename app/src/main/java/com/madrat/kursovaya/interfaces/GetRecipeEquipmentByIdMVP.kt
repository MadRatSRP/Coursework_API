package com.madrat.kursovaya.interfaces

import android.content.Context
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.GetRecipeEquipmentByIdResponse
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