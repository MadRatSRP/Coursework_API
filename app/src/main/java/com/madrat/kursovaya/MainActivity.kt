package com.madrat.kursovaya

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.network.NetworkClient
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val apiKey = applicationContext.getString(R.string.API_KEY)

        val repository = getSearchFoodVideosObservable(
            applicationContext, apiKey, "chicken soup", 10
        )
        repository?.subscribe(
            {response ->
                doOnNext(response.videos)},
            {throwable->
                doOnError(throwable)},
            { })
    }
    fun doOnNext(videos: ArrayList<Video>) {
        videos.forEach {
            textView.text = it.toString()
        }
        /*view.initializeListOfShares(listOfShares)
        view.updateAndShowListOfShares()*/
    }
    fun doOnError(throwable: Throwable) {
        throwable.printStackTrace()
        /*if (throwable is IOException) {
            view.showMessageByMessageId(Messages.ON_ERROR_NO_INTERNET_CONNECTION)
            view.stopSwipeRefreshLayoutRefreshing()
        } else {
            view.showMessageByMessageId(Messages.ON_ERROR)
        }*/
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
        return NetworkClient.instance(context)?.getSearchFoodVideos(apiKey, query, number)
    }
}
