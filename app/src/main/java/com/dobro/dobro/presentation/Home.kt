package com.dobro.dobro.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dobro.dobro.R
import com.dobro.dobro.data.api.ApiClient
import com.dobro.dobro.data.api.models.EventsApiModel
import com.dobro.dobro.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment(), View.OnClickListener {
    private var mActivity: Activity? = null
    private var binding: FragmentHomeBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        loadEvents()
        // Inflate the layout for this fragment
        //return view
        return binding?.root
//        val button: Button = view.findViewById<View>(R.id.calendarButton)
//        button.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//                // do something
//            }
//        })

    }

    private fun loadEvents() {

        val getEvents = ApiClient.instance?.api?.getEvents()
        getEvents?.enqueue(object : Callback<ArrayList<EventsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<EventsApiModel>>,
                response: Response<ArrayList<EventsApiModel>>
            ) {

                val loadProducts = response.body()

//                binding?.recyclerClothes?.layoutManager = LinearLayoutManager(context)
//                productsAdapter = loadProducts?.let {
//                    ProductsAdapter(
//                        it, { idProduct: Int -> deleteProduct(idProduct) },
//                        { productsApiModel: ProductsApiModel -> editProduct(productsApiModel) })
//                }
//                binding?.recyclerClothes?.adapter = productsAdapter

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<EventsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

    override fun onClick(v: View?) {
        Toast.makeText(context, "Testing onClick!", Toast.LENGTH_LONG).show()
    }
}