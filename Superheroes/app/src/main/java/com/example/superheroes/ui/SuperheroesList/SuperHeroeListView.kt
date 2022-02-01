package com.example.superheroes.ui.SuperheroesList

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.MyApplication
import com.example.superheroes.R
import com.example.superheroes.retrofit.model.IdResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroeListView : Fragment() {

    var recyclerView:RecyclerView? = null
    var loadMore: Button? = null
    var list = arrayListOf<IdResponse>()
    var minLimit = 1;
    var maxLimit = 10;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_super_heroe_list_view, container, false)
        loadMore = view.findViewById(R.id.loadMore)
        loadMore?.setOnClickListener {
            for (i in minLimit..maxLimit) {
                val context = activity?.applicationContext as MyApplication
                val getImage = context.api?.getId(i)
                getImage?.enqueue(object: Callback<IdResponse> {
                    override fun onResponse(call: Call<IdResponse>, response: Response<IdResponse>) {

                        if(response.isSuccessful) {
                            val idResponse = response.body()
                            idResponse?.let { list.add(it) }
                            if(i == maxLimit) {
                                recyclerView?.adapter = RecyclerAdapter(list, dpToPx(48), this@SuperHeroeListView)
                                minLimit = maxLimit+1;
                                maxLimit = maxLimit + 10
                            }
                        } else {
                            Toast.makeText(context, "Aqui se acaba", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<IdResponse>, t: Throwable) {
                        Toast.makeText(context, "Fallo epico el metodo", Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = GridLayoutManager(context, 2)




        return view
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().getDisplayMetrics().density).toInt()
    }

    fun showDetails() {
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val action = SuperHeroeListViewDirections.actionSuperHeroeListViewToSuperHeroeDescripctionView()
        navController.navigate(action)

    }
}