package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
     private lateinit var myRecyclerView :RecyclerView
     private lateinit var newsArrayList :ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recycleView)

        val newsImageArray = arrayOf(
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g ,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g)
//arrayOf is not define the type or arrayListOf is define the data list same work in list
        val newsHadeadingArray= arrayListOf(
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos",
            "this is the most important new and the plesse bud it can pospsadfjirmndfiogha dsajiotnvos")


        val newsContantArray= arrayOf(
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),
         getString(R.string.newsContante),

        )

        //to set hav bhav of items inside recycleView vertical scrolling ,horizontal scrolling

        myRecyclerView.layoutManager=LinearLayoutManager(this)

        //initial the newsArrayList inside the data

        newsArrayList = arrayListOf<News>()

        //create the for loop in item show numbring

        for (index in newsImageArray.indices){
            val news=News(newsHadeadingArray[index],newsImageArray[index],newsContantArray[index])

            newsArrayList.add(news)
        }

    val MyAdapter=myAdapter(newsArrayList,this)
        myRecyclerView.adapter=MyAdapter

        MyAdapter.setOnItemClickListener(object:myAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent =Intent(this@MainActivity,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newsContent",newsArrayList[position].newsContant)

                startActivity(intent)
            }

        })


    }
}