package com.madrat.kursovaya.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.madrat.kursovaya.R
import com.madrat.kursovaya.adapters.GetRecipeEquipmentByIdAdapter
import com.madrat.kursovaya.databinding.FragmentGetRecipeEquipmentByIdBinding
import com.madrat.kursovaya.interfaces.GetRecipeEquipmentByIdMVP
import com.madrat.kursovaya.model.get_recipe_equipment_by_id.Equipment
import com.madrat.kursovaya.presenters.GetRecipeEquipmentByIdPresenter
import com.madrat.kursovaya.repository.GetRecipeEquipmentByIdRepository
import com.madrat.kursovaya.util.linearManager

class GetRecipeEquipmentByIdView
    : Fragment(), GetRecipeEquipmentByIdMVP.View {
    // ViewBinding variables
    private var mBinding: FragmentGetRecipeEquipmentByIdBinding? = null
    private val binding get() = mBinding!!

    private var adapter: GetRecipeEquipmentByIdAdapter? = null
    private var presenter: GetRecipeEquipmentByIdPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.setTitle("lego")

        // Initialize ViewBinding
        mBinding = FragmentGetRecipeEquipmentByIdBinding.inflate(inflater,
            container, false)
        val view = binding.root

        initializeAdapterAndRecyclerView()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()

        presenter?.getRecipeEquipmentByIdData(
            view.context, 471661,
            view.context.getString(R.string.API_KEY)
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter = null

        adapter = null

        mBinding = null
    }

    // Initialization
    override fun initializeAdapterAndRecyclerView() {
        adapter = GetRecipeEquipmentByIdAdapter()

        binding.recyclerView.linearManager()
        binding.recyclerView.adapter = adapter
    }
    override fun initializePresenter() {
        presenter = GetRecipeEquipmentByIdPresenter(
            this, GetRecipeEquipmentByIdRepository()
        )
    }
    // Update UI after receiving data
    override fun showListOfEquipments(equipment: ArrayList<Equipment>) {
        adapter?.updateListOfEquipments(equipment)
        binding.recyclerView.adapter = adapter
    }
    override fun showRecyclerView() {
        binding.recyclerView.isVisible = true
    }
}