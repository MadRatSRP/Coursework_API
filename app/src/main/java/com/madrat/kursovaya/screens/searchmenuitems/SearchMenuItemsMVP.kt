package com.madrat.kursovaya.screens.searchmenuitems

import android.content.Context
import com.madrat.kursovaya.screens.searchmenuitems.model.MenuItem
import com.madrat.kursovaya.screens.searchmenuitems.model.SearchMenuItemsResponse
import io.reactivex.rxjava3.core.Observable

interface SearchMenuItemsMVP {
    interface View {

        fun showListOfMenuItems(listOfMenuItems: ArrayList<MenuItem>)
        fun initializePresenter()
        fun showRecyclerView()
    }
    interface Presenter {

        fun doOnComplete()
        fun doOnError(context: Context, throwable: Throwable)
        fun doOnNext(listOfMenuItems: ArrayList<MenuItem>)
    }
    interface Repository {
        fun searchMenuItemsObservable(
            context: Context,
            apiKey: String,
            searchQuery: String,
            number: Int
        ): Observable<SearchMenuItemsResponse>
    }
}