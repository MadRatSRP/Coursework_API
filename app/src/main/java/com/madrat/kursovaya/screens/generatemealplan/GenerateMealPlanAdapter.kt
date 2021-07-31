package com.madrat.kursovaya.screens.generatemealplan

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.madrat.kursovaya.R
import com.madrat.kursovaya.databinding.ListGenerateMealPlanBinding
import com.madrat.kursovaya.screens.generatemealplan.model.Meal

class GenerateMealPlanAdapter: RecyclerView.Adapter<
    GenerateMealPlanAdapter.GenerateMealPlanHolder
>() {
    private val listOfMeals = ArrayList<Meal>()

    fun updateListOfMeals(newListOfMeals: ArrayList<Meal>) {
        listOfMeals.clear()
        listOfMeals.addAll(newListOfMeals)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerateMealPlanHolder {
        val binding = ListGenerateMealPlanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GenerateMealPlanHolder(binding)
    }
    
    override fun onBindViewHolder(holder: GenerateMealPlanHolder, position: Int)
        = holder.bind(listOfMeals[position])

    override fun getItemCount(): Int
        = listOfMeals.size

    inner class GenerateMealPlanHolder (private val binding: ListGenerateMealPlanBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            with(binding) {
                title.text = meal.title
                
                val holderContext = binding.root.context
                
                menuImage.load(
                    holderContext.getString(
                        R.string.base_url_recipes, meal.id, meal.imageType
                    )
                )
    
                readyInMinutesValue.text = meal.readyInMinutes.toString()
                servingsValue.text = meal.servings.toString()
    
                showRecipeWebsiteButton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(meal.sourceUrl)
                    holderContext.startActivity(intent)
                }
    
                showRecipeEquipmentButton.setOnClickListener {
                    val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeEquipmentById(
                        meal.id
                    )
                    Navigation.findNavController(root).navigate(action)
                }
    
                showRecipeIngredientsButton.setOnClickListener {
                    val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeIngredientsByIdView(
                        meal.id
                    )
                    Navigation.findNavController(root).navigate(action)
                }
    
                showRecipeNutritionValueButton.setOnClickListener {
                    val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeNutritionWidgetByIdView(
                        meal.id
                    )
                    Navigation.findNavController(root).navigate(action)
                }
    
                showSimilairRecipesButton.setOnClickListener {
                    val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetSimilarRecipesView(
                        meal.id
                    )
                    Navigation.findNavController(root).navigate(action)
                }
            }
        }
    }
}