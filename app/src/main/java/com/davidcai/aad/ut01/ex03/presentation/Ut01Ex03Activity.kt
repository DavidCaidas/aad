package com.davidcai.aad.ut01.ex03.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.davidcai.aad.R
import com.davidcai.aad.ut01.ex03.data.NewsLocalSource
import com.davidcai.aad.ut01.ex03.domain.News

class Ut01Ex03Activity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_ut01ex03) // R de "Resources"
        init ()
        initWithList()
    }

    private fun init() {
        val newsLocalSource = NewsLocalSource (
            getPreferences(Context.MODE_PRIVATE)
        )
        val news1 = News(1, "title1", "subtitle1", "summary1")
        val news2 = News(2, "title2", "subtitle2", "summary2")
        val news3 = News(3, "title3", "subtitle3", "summary3")
        val news4 = News(4, "title4", "subtitle4", "summary4")

        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)
        newsLocalSource.setNews(news4)

        val newNews1 = newsLocalSource.findById(3)

        Log.d("@dev", "$newNews1")
    }

    private fun initWithList (){
        val newsList: MutableList<News> = mutableListOf(
            News(1, "title1", "subtitle1", "summary1"),
            News(2, "title2", "subtitle2", "summary2"),
            News(3, "title3", "subtitle3", "summary3")
        )

    }
}