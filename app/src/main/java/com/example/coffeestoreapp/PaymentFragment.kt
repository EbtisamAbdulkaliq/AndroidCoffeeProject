package com.example.coffeestoreapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * Use the [PaymentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymentFragment : Fragment() {
    private lateinit var editTextFullName: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var timePicker: TimePicker
    private lateinit var buttonPlaceOrder: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        editTextFullName = view.findViewById(R.id.editTextFullName)
        editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber)
        timePicker = view.findViewById(R.id.timePicker)
        buttonPlaceOrder = view.findViewById(R.id.buttonPlaceOrder)

        // Add text watchers for validation
        editTextFullName.addTextChangedListener(createTextWatcher())
        editTextPhoneNumber.addTextChangedListener(createTextWatcher())
        // Initialize other EditTexts and add text watchers as needed

        // Set up the TimePicker if needed
        setupTimePicker()

        // Set up Place Order button click listener
        buttonPlaceOrder.setOnClickListener {

                (activity as? MainActivity)?.replaceFragment(SummaryFragment ())
        }
    }

    private fun setupTimePicker() {
        // Set 24-hour view
        timePicker.setIs24HourView(true)

        // Set the time to 10:30 AM
        timePicker.hour = 10
        timePicker.minute = 30

        // Set up a time changed listener
        timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
              Toast.makeText(
                    context,
                    "Selected time: $hourOfDay:$minute",
                    Toast.LENGTH_SHORT
                ).show()

        }
    }

    private fun createTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                // Simple validation check to enable the Place Order button
                buttonPlaceOrder.isEnabled = editTextFullName.text.isNotBlank() &&
                        editTextPhoneNumber.text.isNotBlank()
                // Add further validation for all fields as needed

            }
        }
    }
}