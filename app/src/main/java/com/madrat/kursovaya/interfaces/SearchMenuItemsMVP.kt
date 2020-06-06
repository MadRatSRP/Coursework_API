package com.madrat.kursovaya.interfaces

import android.content.Context
import com.madrat.kursovaya.model.search_menu_items.MenuItem
import com.madrat.kursovaya.model.search_menu_items.SearchMenuItemsResponse
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