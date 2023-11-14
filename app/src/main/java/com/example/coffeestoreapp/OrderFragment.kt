package com.example.coffeestoreapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {
    private lateinit var coffeeTypeRadioGroup: RadioGroup
    private lateinit var coffeeSizeRadioGroup: RadioGroup
    private lateinit var continueButton: Button
    private lateinit var extrasCheckboxes: List<CheckBox>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        coffeeTypeRadioGroup = view.findViewById(R.id.coffeeTypeRadioGroup)
        coffeeSizeRadioGroup = view.findViewById(R.id.coffeeSizeRadioGroup)
        continueButton = view.findViewById(R.id.continueButton)

        // List of all checkboxes for extras
        extrasCheckboxes = listOf(
            view.findViewById(R.id.checkbox_extra_shot),
            view.findViewById(R.id.checkbox_sugar),
            view.findViewById(R.id.checkbox_cream),
            view.findViewById(R.id.checkbox_whole_milk),
            view.findViewById(R.id.checkbox_two_percent_milk),
            view.findViewById(R.id.checkbox_non_fat_milk),
            view.findViewById(R.id.checkbox_almond_milk)
            // ... Add any other CheckBoxes here
        )

        // Set up the listeners for the coffee type selection
        coffeeTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            // Show the coffee size selection when a coffee type is selected
            coffeeSizeRadioGroup.visibility = if (checkedId != -1) View.VISIBLE else View.GONE
        }

        // Set up the listeners for the coffee size selection
        coffeeSizeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            // Show the extras when a coffee size is selected
            val showExtras = checkedId != -1
            extrasCheckboxes.forEach { checkbox ->
                checkbox.visibility = if (showExtras) View.VISIBLE else View.GONE
            }
            // Enable the continue button if a coffee size is selected and at least one extra is checked
            continueButton.isEnabled = showExtras && extrasCheckboxes.any { it.isChecked }
        }

        // Enable continue button if any checkbox is checked
        extrasCheckboxes.forEach { checkbox ->
            checkbox.setOnCheckedChangeListener { _, _ ->
                continueButton.isEnabled = extrasCheckboxes.any { it.isChecked }
            }
        }

        // Listener for the Continue button
        continueButton.setOnClickListener {
            // Navigate to the next fragment (e.g., PaymentFragment) or perform an action
            (activity as? MainActivity)?.replaceFragment(PaymentFragment())
        }
    }
}
