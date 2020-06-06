package com.madrat.kursovaya.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.madrat.kursovaya.R
import com.madrat.kursovaya.adapters.SearchFoodVideosAdapter
import com.madrat.kursovaya.adapters.SearchMenuItemsAdapter
import com.madrat.kursovaya.databinding.FragmentSearchFoodVideosBinding
import com.madrat.kursovaya.databinding.FragmentSearchMenuItemsBinding
import com.madrat.kursovaya.interfaces.SearchMenuItemsMVP
import com.madrat.kursovaya.model.search_food_videos.Video
import com.madrat.kursovaya.model.search_menu_items.MenuItem
import com.madrat.kursovaya.presenters.SearchFoodVideosPresenter
import com.madrat.kursovaya.presenters.SearchMenuItemsPresenter
import com.madrat.kursovaya.repository.SearchFoodVideosRepository
import com.madrat.kursovaya.repository.SearchMenuItemsRepository
import com.madrat.kursovaya.util.hideKeyboardAndClearFocus
import com.madrat.kursovaya.util.linearManager

class SearchMenuItemsView
    : Fragment(), SearchMenuItemsMVP.View {
    // ViewBinding variables
    private var mBinding: FragmentSearchMenuItemsBinding? = null
    private val binding get() = mBinding!!

    private var adapter: SearchMenuItemsAdapter? = null

    private var presenter: SearchMenuItemsPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Initialize ViewBinding
        mBinding = FragmentSearchMenuItemsBinding.inflate(inflater,
            container, false)
        val view = binding.root

        adapter = SearchMenuItemsAdapter()

        binding.recyclerView.linearManager()
        binding.recyclerView.adapter = adapter

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()

        binding.searchMenuItemsButton.setOnClickListener {
            presenter?.searchMenuItemsData(
                view.context, view.context.getString(R.string.API_KEY),
                binding.setupSearchQuery.text.toString(), 3
            )
        }
    }

    override fun initializePresenter() {
        presenter = SearchMenuItemsPresenter(this, SearchMenuItemsRepository())
    }
    override fun showListOfMenuItems(listOfMenuItems: ArrayList<MenuItem>) {
        adapter?.updateListOfMenuItems(listOfMenuItems)
        binding.recyclerView.adapter = adapter
    }
    override fun showRecyclerView() {
        binding.recyclerView.isVisible = true
    }
}