package com.example.superheroes.ui.SuperheroesList

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.R
import com.example.superheroes.retrofit.model.IdResponse
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var dataSet: ArrayList<IdResponse>, val imageSize: Int, var container: Fragment) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleTextView: TextView? = null
        var imageView: ImageView? = null
        var descTextView: TextView? = null

        init {
            // Define click listener for the ViewHolder's View.
            titleTextView = view.findViewById(R.id.titleTextView)
            descTextView = view.findViewById(R.id.descTextView)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.superheroes_card_view, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView?.text = dataSet[position].name
        holder.descTextView?.text = "Aqui va uno"
        holder.itemView.setOnClickListener {
            (container as SuperHeroeListView).showDetails();
        }
        val px = DisplayMetrics.DENSITY_DEFAULT
        Picasso.get()
            .load(dataSet[position].image.url)
            .error(R.drawable.ic_launcher_background)
            .resize(imageSize, imageSize)
            .into(holder.imageView)
    }
}