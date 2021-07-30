package com.madrat.kursovaya.screens.searchmenuitems

import android.content.Context
import com.madrat.kursovaya.screens.searchmenuitems.model.SearchMenuItemsResponse
import com.madrat.kursovaya.util.AppDependencies
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchMenuItemsRepository: SearchMenuItemsMVP.Repository {
    private val networkService: SearchMenuItemsNetwork = AppDependencies.retrofit!!.create(
        SearchMenuItemsNetwork::class.java
    )
    
    override fun searchMenuItemsObservable(
        context: Context,
        apiKey: String,
        searchQuery: String,
        number: Int
    ): Observable<SearchMenuItemsResponse> {
        return networkService
            .searchMenuItems(
                apiKey,
                searchQuery,
                number
            )
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(
                AndroidSchedulers.mainThread()
            )
    }
}