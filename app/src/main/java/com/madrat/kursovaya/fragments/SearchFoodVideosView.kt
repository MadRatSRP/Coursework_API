package com.madrat.kursovaya.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chuckerteam.chucker.api.ChuckerCollector
import com.madrat.kursovaya.R
import com.madrat.kursovaya.adapters.SearchFoodVideosAdapter
import com.madrat.kursovaya.databinding.FragmentSearchFoodVideosBinding
import com.madrat.kursovaya.model.search_food_videos.SearchFoodVideosResponse
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.network.NetworkClient
import com.madrat.kursovaya.util.linearManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchFoodVideosView: Fragment() {
    // ViewBinding variables
    private var mBinding: FragmentSearchFoodVideosBinding? = null
    private val binding get() = mBinding!!

    private var adapter: SearchFoodVideosAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = FragmentSearchFoodVideosBinding.inflate(inflater,
            container, false)
        val view = binding.root

        adapter = SearchFoodVideosAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.linearManager()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiKey = view.context.getString(R.string.API_KEY)

        val repository = getSearchFoodVideosObservable(
            view.context, apiKey, "chicken soup", 1
        )
        repository?.subscribe(
            {response ->
                doOnNext(response.videos)},
            {throwable->
                doOnError(throwable)},
            { })
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }


    fun doOnNext(videos: ArrayList<Video>) {

        showListOfVideos(videos)

        /*view.initializeListOfShares(listOfShares)
        view.updateAndShowListOfShares()*/
    }
    fun doOnError(throwable: Throwable) {
        throwable.printStackTrace()
        context?.let { ChuckerCollector(it).onError("TAG", throwable) }

        /*if (throwable is IOException) {
            view.showMessageByMessageId(Messages.ON_ERROR_NO_INTERNET_CONNECTION)
            view.stopSwipeRefreshLayoutRefreshing()
        } else {
            view.showMessageByMessageId(Messages.ON_ERROR)
        }*/
    }

    fun showListOfVideos(videos: ArrayList<Video>) {
        adapter?.updateListOfVideos(videos)
        binding.recyclerView.adapter = adapter
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



    private fun getSearchFoodVideosObservable(context: Context,
                                              apiKey: String,
                                              query: String,
                                              number: Int)
            : Observable<SearchFoodVideosResponse>? {
        return NetworkClient.instance(context)
            ?.getSearchFoodVideos(apiKey, query, number)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}