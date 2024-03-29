package com.madrat.kursovaya.screens.searchfoodvideos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.FragmentSearchFoodVideosBinding
import com.madrat.kursovaya.screens.searchfoodvideos.model.Video
import com.madrat.kursovaya.util.hideKeyboardAndClearFocus
import com.madrat.kursovaya.util.linearManager

class SearchFoodVideosView
    : Fragment(), SearchFoodVideosMVP.View {

    // ViewBinding variables
    private var mBinding: FragmentSearchFoodVideosBinding? = null
    private val binding get() = mBinding!!

    private var adapter: SearchFoodVideosAdapter? = null

    private var presenter: SearchFoodVideosPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Initialize ViewBinding
        mBinding = FragmentSearchFoodVideosBinding.inflate(inflater,
            container, false)
        val view = binding.root

        binding.setupSearchQuery.hideKeyboardAndClearFocus{}

        adapter = SearchFoodVideosAdapter()

        binding.recyclerView.linearManager()
        binding.recyclerView.adapter = adapter

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializePresenter()

        binding.searchFoodVideosButton.setOnClickListener {
            presenter?.getSearchFoodVideosData(
                view.context, view.context.getString(R.string.API_KEY),
                binding.setupSearchQuery.text.toString(), 3
            )
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter = null

        adapter = null

        mBinding = null
    }

    override fun initializePresenter() {
        presenter = SearchFoodVideosPresenter(this, SearchFoodVideosRepository())
    }
    override fun showListOfVideos(videos: ArrayList<Video>) {
        adapter?.updateListOfVideos(videos)
        binding.recyclerView.adapter = adapter
    }
    override fun showRecyclerView() {
        binding.recyclerView.isVisible = true
    }
}