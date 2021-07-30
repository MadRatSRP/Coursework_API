package com.madrat.kursovaya.screens.generatemealplan

import android.content.Context
import com.madrat.kursovaya.screens.generatemealplan.model.GenerateMealPlanResponse
import com.madrat.kursovaya.util.AppDependencies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GenerateMealPlanRepository: GenerateMealPlanMVP.Repository {
    private val networkService: GenerateMealPlanNetwork = AppDependencies.retrofit!!.create(
        GenerateMealPlanNetwork::class.java
    )
    
    override fun generateMealPlanObservable(
        context: Context,
        apiKey: String,
        timeFrame: String
    ): Observable<GenerateMealPlanResponse> {
        return networkService
            .generateMealPlan(
                apiKey,
                timeFrame
            )
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(
                AndroidSchedulers.mainThread()
            )
    }
}