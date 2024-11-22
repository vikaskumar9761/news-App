package com.example.newsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class myAdapter(var newsArrayList: ArrayList<News>, var context:Activity) :
    RecyclerView.Adapter<myAdapter.MyViewHolder>() {

        lateinit var myListener:onItemClickListener

        interface onItemClickListener{
            fun onItemClick(position: Int)
        }

    fun setOnItemClickListener(listener: onItemClickListener){

        myListener=listener

    }
    //to create new view instance
    //When layout manager fails to find a suitable view for each itme
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewItme = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(viewItme ,myListener)
    }

    //populate the item in your list view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItme = newsArrayList[position]
        holder.hTitle.text = currentItme.newsHeading
        holder.iHeading.setImageResource(currentItme.newsImage)
    }

    //how many list item are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    //it hold the view so views are not created everytime , so memory can bi saved
    class MyViewHolder(itemView: View, myListener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val hTitle = itemView.findViewById<TextView>(R.id.tvHadeadingTitle)
        val iHeading = itemView.findViewById<ShapeableImageView>(R.id.tv_headingImage)


        init {
            itemView.setOnClickListener{

                myListener.onItemClick(adapterPosition)
            }
        }
    }

}