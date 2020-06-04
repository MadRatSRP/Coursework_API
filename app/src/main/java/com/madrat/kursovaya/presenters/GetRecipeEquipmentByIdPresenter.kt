package com.madrat.kursovaya.presenters

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.interfaces.GetRecipeEquipmentByIdMVP
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment

class GetRecipeEquipmentByIdPresenter(private val view: GetRecipeEquipmentByIdMVP.View,
                                      private val repository: GetRecipeEquipmentByIdMVP.Repository)
    : GetRecipeEquipmentByIdMVP.Presenter {
    override fun getRecipeEquipmentByIdData(context: Context,
                                            recipeId: Int, apiKey: String) {
        val repository = repository.getRecipeEquipmentByIdObservable(
            context, recipeId, apiKey
        )
        repository.subscribe(
            {response ->
                doOnNext(response.listOfEquipment)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(equipment: ArrayList<Equipment>) {
        view.showListOfEquipments(equipment)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}
