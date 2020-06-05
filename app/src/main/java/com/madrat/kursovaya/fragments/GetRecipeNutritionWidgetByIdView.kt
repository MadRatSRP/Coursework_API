package com.madrat.kursovaya.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.madrat.kursovaya.R
import com.madrat.kursovaya.adapters.get_recipe_nutrition_widget_by_id.NutritionalValueAdapter
import com.madrat.kursovaya.databinding.FragmentGetRecipeNutritionWidgetByIdBinding
import com.madrat.kursovaya.interfaces.GetRecipeNutritionWidgetByIdMVP
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.GetRecipeNutritionWidgetByIdResponse
import com.madrat.kursovaya.model.get_recipe_nutrition_widget_by_id.Nutrition
import com.madrat.kursovaya.presenters.GetRecipeNutritionWidgetByIdPresenter
import com.madrat.kursovaya.repository.GetRecipeNutritionWidgetByIdRepository
import com.madrat.kursovaya.util.linearManager

class GetRecipeNutritionWidgetByIdView
    : Fragment(), GetRecipeNutritionWidgetByIdMVP.View {
    private val args: GetRecipeNutritionWidgetByIdViewArgs by navArgs()

    // ViewBinding variables
    private var mBinding: FragmentGetRecipeNutritionWidgetByIdBinding? = null
    private val binding get() = mBinding!!

    private var badNutritionsAdapter: NutritionalValueAdapter? = null
    private var goodNutritionsAdapter: NutritionalValueAdapter? = null
    private var presenter: GetRecipeNutritionWidgetByIdPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "NutritionValue"

        // Initialize ViewBinding
        mBinding = FragmentGetRecipeNutritionWidgetByIdBinding.inflate(inflater,
            container, false)
        val view = binding.root

        initializeAdapterAndRecyclerView()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()

        presenter?.getRecipeNutritionWidgetByIdData(
            view.context, args.recipeId,
            view.context.getString(R.string.API_KEY)
        )
    }

    // Initialization
    override fun initializeAdapterAndRecyclerView() {
        badNutritionsAdapter = NutritionalValueAdapter()
        goodNutritionsAdapter = NutritionalValueAdapter()

        binding.badNutritionsRecyclerView.linearManager()
        binding.badNutritionsRecyclerView.adapter = badNutritionsAdapter

        binding.goodNutritionsRecyclerView.linearManager()
        binding.goodNutritionsRecyclerView.adapter = badNutritionsAdapter
    }
    override fun initializePresenter() {
        presenter = GetRecipeNutritionWidgetByIdPresenter(
            this, GetRecipeNutritionWidgetByIdRepository()
        )
    }

    // Update UI after receiving data
    override fun loadDataIntoViews(response: GetRecipeNutritionWidgetByIdResponse) {
        showListOfBadNutritions(response.listOfBadNutritions)

        showListOfGoodNutritions(response.listOfGoodNutritions)
    }
    override fun showListOfBadNutritions(listOfBadNutritions: ArrayList<Nutrition>) {
        badNutritionsAdapter?.updateListOfNutritions(listOfBadNutritions)
        binding.badNutritionsRecyclerView.adapter = badNutritionsAdapter
    }
    override fun showListOfGoodNutritions(listOfGoodNutritions: ArrayList<Nutrition>) {
        goodNutritionsAdapter?.updateListOfNutritions(listOfGoodNutritions)
        binding.goodNutritionsRecyclerView.adapter = goodNutritionsAdapter
    }

    // Show Views with loaded data
    override fun showRecyclerView() {
        binding.badNutritionsRecyclerView.isVisible = true
    }
}