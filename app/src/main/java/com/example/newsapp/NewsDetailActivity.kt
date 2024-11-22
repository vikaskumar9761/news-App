package com.example.newsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading= intent.getStringExtra("heading")
        val newscontent=intent.getStringExtra("newsContent")
        val imageId=intent.getIntExtra("imageId",R.drawable.b)

        val headingTv=findViewById<TextView>(R.id.newsHading)
        val headingIv=findViewById<ImageView>(R.id.newsImage)
        val newscontentTv=findViewById<TextView>(R.id.newsContent)
        
        headingTv.text=heading
        newscontentTv.text=newscontent
        headingIv.setImageResource(imageId)
    }
}