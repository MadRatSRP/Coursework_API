package com.madrat.kursovaya

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.network.NetworkClient
import com.madrat.kursovaya.util.linearManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SearchFoodVideosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = SearchFoodVideosAdapter()

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = adapter
        recyclerView.linearManager()

        val apiKey = applicationContext.getString(R.string.API_KEY)

        val repository = getSearchFoodVideosObservable(
            applicationContext, apiKey, "chicken soup", 1
        )
        repository?.subscribe(
            {response ->
                doOnNext(response.videos)},
            {throwable->
                doOnError(throwable)},
            { })
    }
    fun doOnNext(videos: ArrayList<Video>) {

        showListOfVideos(videos)

        /*view.initializeListOfShares(listOfShares)
        view.updateAndShowListOfShares()*/
    }
    fun doOnError(throwable: Throwable) {
        throwable.printStackTrace()
        ChuckerCollector(applicationContext).onError("TAG", throwable)

        /*if (throwable is IOException) {
            view.showMessageByMessageId(Messages.ON_ERROR_NO_INTERNET_CONNECTION)
            view.stopSwipeRefreshLayoutRefreshing()
        } else {
            view.showMessageByMessageId(Messages.ON_ERROR)
        }*/
    }

    fun showListOfVideos(videos: ArrayList<Video>) {
        adapter.updateListOfVideos(videos)
        recyclerView.adapter = adapter
    }

    /*override fun loadListOfShares() {
        val repository = repository.getSharesObservable()
        disposable = repository?.subscribe(
            {response ->
                doOnNext(response.shares)},
            {throwable->
                doOnError(throwable)},
            { doOnComplete() })
    }
    override fun doOnNext(listOfShares: ArrayList<Shares>) {
        view.initializeListOfShares(listOfShares)
        view.updateAndShowListOfShares()
    }
    override fun doOnError(throwable: Throwable) {
        throwable.printStackTrace()
        if (throwable is IOException) {
            view.showMessageByMessageId(Messages.ON_ERROR_NO_INTERNET_CONNECTION)
            view.stopSwipeRefreshLayoutRefreshing()
        } else {
            view.showMessageByMessageId(Messages.ON_ERROR)
        }
    }
    override fun doOnComplete() {
        view.hideProgressBar()
        view.stopSwipeRefreshLayoutRefreshing()
        view.showMessageByMessageId(Messages.ON_COMPLETE)
    }*/



    private fun getSearchFoodVideosObservable(context: Context, apiKey: String, query: String, number: Int)
            : Observable<SearchFoodVideosResponse>? {
        return NetworkClient.instance(context)
            ?.getSearchFoodVideos(apiKey, query, number)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}
