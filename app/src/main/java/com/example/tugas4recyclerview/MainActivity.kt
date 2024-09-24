package com.example.tugas4recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.example.tugas4recyclerview.adapter.ItemAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter
    private val itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList.add(Item("Item 1", "Deskripsi 1"))
        itemList.add(Item("Item 2", "Deskripsi 2"))
        itemList.add(Item("Item 3", "Deskripsi 3"))

        // Find views
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        // Set up RecyclerView
        itemAdapter = ItemAdapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter

        // Set button click listener
        button.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                itemList.add(Item(newItem, "Description"))
                itemAdapter.notifyItemInserted(itemList.size - 1)
                editText.text.clear()
            }
        }
    }
}
