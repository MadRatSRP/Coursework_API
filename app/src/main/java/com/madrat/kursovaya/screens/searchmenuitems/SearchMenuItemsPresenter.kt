package com.madrat.kursovaya.screens.searchmenuitems

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.screens.searchmenuitems.model.MenuItem

class SearchMenuItemsPresenter(private val view: SearchMenuItemsMVP.View,
                               private val repository: SearchMenuItemsMVP.Repository)
    : SearchMenuItemsMVP.Presenter {
    fun searchMenuItemsData(context: Context, apiKey: String,
                            searchQuery: String, number: Int) {
        val repository = repository.searchMenuItemsObservable(
            context, apiKey, searchQuery, number
        )
        repository.subscribe(
            {response ->
                doOnNext(response.listOfMenuItems)},
            {throwable->
                doOnError(context, throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(listOfMenuItems: ArrayList<MenuItem>) {
        view.showListOfMenuItems(listOfMenuItems)
    }
    override fun doOnError(context: Context, throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(context).onError("TAG", throwable)
    }
    override fun doOnComplete() {
        view.showRecyclerView()
    }
}