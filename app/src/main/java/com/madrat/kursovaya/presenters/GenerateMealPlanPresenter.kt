package com.madrat.kursovaya.presenters

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.interfaces.GenerateMealPlanMVP
import com.madrat.kursovaya.model.generate_meal_plan.Meal
import com.madrat.kursovaya.model.generate_meal_plan.Nutrients

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
                 nutrients: Nutrients) {
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