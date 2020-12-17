package com.example.freebooks


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val rcView=  RecyclerView(findViewById(R.id.rcView))

        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.book, "Английский язык", "Отдаю в хорошие руки, бесплатно"))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this)

    }
}