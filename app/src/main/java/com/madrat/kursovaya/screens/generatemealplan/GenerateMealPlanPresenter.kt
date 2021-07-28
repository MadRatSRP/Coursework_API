package com.madrat.kursovaya.screens.generatemealplan

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.screens.generatemealplan.model.Meal
import com.madrat.kursovaya.screens.generatemealplan.model.Nutrients

class GenerateMealPlanPresenter(private val view: GenerateMealPlanMVP.View,
                                private val repository: GenerateMealPlanMVP.Repository)
    : GenerateMealPlanMVP.Presenter {
    override fun generateMealPlanData(context: Context, apiKey: String,
                             timeFrame: String) {
        val repository = repository.generateMealPlanObservable(
            context, apiKey, timeFrame
        )
        repository.subscribe(
            {response ->
                doOnNext(response.meals,
                    response.nutrients)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(meals: ArrayList<Meal>,
                          nutrients: Nutrients
    ) {
        view.showListOfMeals(meals)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        //view.showRecyclerView()
    }
}