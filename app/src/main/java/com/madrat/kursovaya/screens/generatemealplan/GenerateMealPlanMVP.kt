package com.madrat.kursovaya.screens.generatemealplan

import android.content.Context
import com.madrat.kursovaya.screens.generatemealplan.model.GenerateMealPlanResponse
import com.madrat.kursovaya.screens.generatemealplan.model.Meal
import com.madrat.kursovaya.screens.generatemealplan.model.Nutrients
import io.reactivex.rxjava3.core.Observable

interface GenerateMealPlanMVP {
    interface View {

        fun initializePresenter()
        fun initializeAdapterAndRecyclerView()
        fun showListOfMeals(meals: ArrayList<Meal>)
    }
    interface Presenter {

        fun doOnNext(meals: ArrayList<Meal>, nutrients: Nutrients)
        fun doOnError(context: Context, throwable: Throwable)
        fun doOnComplete()
        fun generateMealPlanData(context: Context, apiKey: String, timeFrame: String)
    }
    interface Repository {
        fun generateMealPlanObservable(
            context: Context,
            apiKey: String,
            timeFrame: String
        ): Observable<GenerateMealPlanResponse>
    }
}