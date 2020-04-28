package com.madrat.kursovaya.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madrat.kursovaya.R
import com.madrat.kursovaya.adapters.GenerateMealPlanAdapter
import com.madrat.kursovaya.databinding.FragmentGenerateMealPlanBinding
import com.madrat.kursovaya.interfaces.GenerateMealPlanMVP
import com.madrat.kursovaya.model.generate_meal_plan.Meal
import com.madrat.kursovaya.presenters.GenerateMealPlanPresenter
import com.madrat.kursovaya.repository.GenerateMealPlanRepository
import com.madrat.kursovaya.util.linearManager

class GenerateMealPlanView
    : Fragment(), GenerateMealPlanMVP.View {
    // ViewBinding variables
    private var mBinding: FragmentGenerateMealPlanBinding? = null
    private val binding get() = mBinding!!

    private var adapter: GenerateMealPlanAdapter? = null
    private var presenter: GenerateMealPlanPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Initialize ViewBinding
        mBinding = FragmentGenerateMealPlanBinding.inflate(inflater,
            container, false)
        val view = binding.root

        initializeAdapterAndRecyclerView()
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()

        presenter?.generateMealPlanData(
            view.context,
            view.context.getString(R.string.API_KEY),
            "day")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter = null

        adapter = null

        mBinding = null
    }

    // Initialization
    override fun initializeAdapterAndRecyclerView() {
        adapter = GenerateMealPlanAdapter()

        binding.recyclerView.linearManager()
        binding.recyclerView.adapter = adapter
    }
    override fun initializePresenter() {
        presenter = GenerateMealPlanPresenter(
            this, GenerateMealPlanRepository()
        )
    }
    // Update UI after receiving data
    override fun showListOfMeals(meals: ArrayList<Meal>) {
        adapter?.updateListOfMeals(meals)
        binding.recyclerView.adapter = adapter
    }
}