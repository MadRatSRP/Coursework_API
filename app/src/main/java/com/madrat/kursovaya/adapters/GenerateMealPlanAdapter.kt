package com.madrat.kursovaya.adapters

import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.madrat.kursovaya.R
import com.madrat.kursovaya.fragments.GenerateMealPlanViewDirections
import com.madrat.kursovaya.model.generate_meal_plan.Meal
import com.madrat.kursovaya.util.inflate
import com.madrat.kursovaya.util.loadImageFromUrl
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_generate_meal_plan.*

class GenerateMealPlanAdapter
    : RecyclerView.Adapter<GenerateMealPlanAdapter.GenerateMealPlanHolder>() {
    private val listOfMeals = ArrayList<Meal>()

    fun updateListOfMeals(newListOfMeals: ArrayList<Meal>) {
        listOfMeals.clear()
        listOfMeals.addAll(newListOfMeals)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerateMealPlanHolder
            = GenerateMealPlanHolder(parent.inflate(R.layout.list_generate_meal_plan))

    override fun onBindViewHolder(holder: GenerateMealPlanHolder, position: Int)
            = holder.bind(listOfMeals[position])

    override fun getItemCount(): Int
            = listOfMeals.size

    inner class GenerateMealPlanHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(meal: Meal) {
            title.text = meal.title

            menu_image.loadImageFromUrl(
                containerView.context.getString(
                    R.string.base_url_recipes, meal.id, meal.imageType
                )
            )

            ready_in_minutes_value.text = meal.readyInMinutes.toString()
            servings_value.text = meal.servings.toString()
            url.text = meal.sourceUrl

            showRecipeEquipmentButton.setOnClickListener {
                val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeEquipmentById(
                    meal.id
                )
                Navigation.findNavController(containerView).navigate(action)
            }

            showRecipeIngredientsButton.setOnClickListener {
                val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeIngredientsByIdView(
                    meal.id
                )
                Navigation.findNavController(containerView).navigate(action)
            }

            showRecipeNutritionValueButton.setOnClickListener {
                val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetRecipeNutritionWidgetByIdView(
                    meal.id
                )
                Navigation.findNavController(containerView).navigate(action)
            }

            show_similair_recipes_button.setOnClickListener {
                val action = GenerateMealPlanViewDirections.actionGenerateMealPlanToGetSimilarRecipesView(
                    meal.id
                )
                Navigation.findNavController(containerView).navigate(action)
            }
        }
    }
}