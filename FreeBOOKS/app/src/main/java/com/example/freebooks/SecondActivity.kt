package com.example.freebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val view
        var rcView = view.findViewById(R.id.rcView)

        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.book, "Английский язык", "Отдаю в хорошие руки, бесплатно"))


        rcView.adapter = MyAdapter(list, this)

    }
}