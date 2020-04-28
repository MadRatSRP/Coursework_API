package com.madrat.kursovaya.repository

import android.content.Context
import com.madrat.kursovaya.interfaces.GenerateMealPlanMVP
import com.madrat.kursovaya.model.generate_meal_plan.GenerateMealPlanResponse
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GenerateMealPlanRepository
    : GenerateMealPlanMVP.Repository {
    override fun generateMealPlanObservable(context: Context, apiKey: String,
                                            timeFrame: String)
            : Observable<GenerateMealPlanResponse>? {
        return NetworkClient.instance(context)
            ?.generateMealPlan(apiKey, timeFrame)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}