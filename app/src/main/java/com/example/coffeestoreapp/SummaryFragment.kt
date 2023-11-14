package com.example.coffeestoreapp
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assume that the pickup time and order details are passed as arguments
        // For demonstration, we're using placeholders
        val pickupTime = "10:30 AM" // This should be passed as an argument
        val orderDetails = "1x Latte, Extra Shot" // This should also be passed as an argument

        // Retrieve and display the pickup time
        val textViewPickupTime: TextView = view.findViewById(R.id.textViewPickupTime)
        textViewPickupTime.text = getString(R.string.pickup_time_format, pickupTime)

        // Retrieve and display the order details
        val textViewOrderDetails: TextView = view.findViewById(R.id.textViewOrderDetails)
        textViewOrderDetails.text = getString(R.string.order_details_format, orderDetails)
    }
}