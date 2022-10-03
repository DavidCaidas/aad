package com.davidcai.aad.ut01.ex03.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.davidcai.aad.ut01.ex03.domain.News

class NewsLocalSource(val sharedPref: SharedPreferences) {
    fun setNews(news: News) {
        val gson = Gson();
        // Enviamos una clase JAVA y nos devuelve un String con la info de la clase como JSON
        val jsonNews = gson.toJson(
            news,
            News::class.java
        ) // Primero el objeto, luego el tipo de objeto que enviamos

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(), jsonNews)
        edit.apply()
    }

    fun findById(newsId: Int): News {
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(), "")

        return gson.fromJson(jsonNews, News::class.java) // devuelve un News.
    }

    fun setNewsList(newList: MutableList<News>) {
        val gson = Gson()
        // Enviamos una clase JAVA y nos devuelve un String con la info de la clase como JSON
        val jsonNews = gson.toJson(
            newList,
            listOf<News>()::class.java
        ) // Primero el objeto, luego el tipo de objeto que enviamos

        val edit = sharedPref.edit()
        //edit.putStringSet(newList.toString(),)
        /*for (n: News in newList){
            // VIRGIN for loop
        }
         */
        // CHAD for each LOOP
        newList.forEach(
            edit.putString(this.id.toString(), jsonNews)
        )
        edit.apply()
    }

    fun findAll(): MutableList<News> = mutableListOf()
}

