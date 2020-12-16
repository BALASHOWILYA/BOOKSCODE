package com.example.freebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.freebooks.R.id.rcView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        rcView = view.findViewById(rcView)


        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.book, "Английский язык", "Отдаю в хорошие руки, бесплатно"))

        rcView.adapter = MyAdapter(list, this)
    }
}