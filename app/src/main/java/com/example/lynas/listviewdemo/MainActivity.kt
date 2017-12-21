package com.example.lynas.listviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import org.jetbrains.anko.listView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = listOf(AppUser(1L,"a","as","d1"),AppUser(2L,"b","as","d2"))
        verticalLayout {
            val listView = listView {  }
            listView.adapter = CustomAdapter(items)

            listView.setOnItemClickListener { parent, view, position, id ->
                val appUser = parent.getItemAtPosition(position) as AppUser
                toast(appUser.name)
            }
        }
    }
}


data class AppUser(val id: Long, val name:String, val image:String, val description:String)