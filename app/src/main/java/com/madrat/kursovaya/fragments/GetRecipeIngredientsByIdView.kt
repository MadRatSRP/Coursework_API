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
import com.madrat.kursovaya.adapters.GetRecipeEquipmentByIdAdapter
import com.madrat.kursovaya.adapters.GetRecipeIngredientsByIdAdapter
import com.madrat.kursovaya.databinding.FragmentGetRecipeEquipmentByIdBinding
import com.madrat.kursovaya.databinding.FragmentGetRecipeIngredientsByIdBinding
import com.madrat.kursovaya.interfaces.GetRecipeIngredientsByIdMVP
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment
import com.madrat.kursovaya.model.get_recipe_ingredients_by_id.Ingredient
import com.madrat.kursovaya.presenters.GetRecipeEquipmentByIdPresenter
import com.madrat.kursovaya.presenters.GetRecipeIngredientsByIdPresenter
import com.madrat.kursovaya.repository.GetRecipeEquipmentByIdRepository
import com.madrat.kursovaya.repository.GetRecipeIngredientsByIdRepository
import com.madrat.kursovaya.util.linearManager

class GetRecipeIngredientsByIdView
    : Fragment(), GetRecipeIngredientsByIdMVP.View {
    private val args: GetRecipeIngredientsByIdViewArgs by navArgs()

    // ViewBinding variables
    private var mBinding: FragmentGetRecipeIngredientsByIdBinding? = null
    private val binding get() = mBinding!!

    private var adapter: GetRecipeIngredientsByIdAdapter? = null
    private var presenter: GetRecipeIngredientsByIdPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "RecipeIngredients"

        // Initialize ViewBinding
        mBinding = FragmentGetRecipeIngredientsByIdBinding.inflate(inflater,
            container, false)
        val view = binding.root

        initializeAdapterAndRecyclerView()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()

        presenter?.getRecipeIngredientsByIdData(
            view.context, args.recipeId,
            view.context.getString(R.string.API_KEY)
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

    // Initialization
    override fun initializeAdapterAndRecyclerView() {
        adapter = GetRecipeIngredientsByIdAdapter()

        binding.recyclerView.linearManager()
        binding.recyclerView.adapter = adapter
    }
    override fun initializePresenter() {
        presenter = GetRecipeIngredientsByIdPresenter(
            this, GetRecipeIngredientsByIdRepository()
        )
    }

    // Update UI after receiving data
    override fun showListOfIngredients(listOfIngredients: ArrayList<Ingredient>) {
        adapter?.updateListOfIngredients(listOfIngredients)
        binding.recyclerView.adapter = adapter
    }
    override fun showRecyclerView() {
        binding.recyclerView.isVisible = true
    }
}