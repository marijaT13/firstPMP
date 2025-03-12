package com.example.firstpmp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextQuery: EditText
    private lateinit var editTextTag: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var listViewTags: ListView

    private val tagsList = mutableListOf("AndroidFP", "Deitel", "Google", "iPhoneFP", "JavaFP", "JavaHTP")
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextQuery = findViewById(R.id.editTextQuery)
        editTextTag = findViewById(R.id.editTextTag)
        buttonSave = findViewById(R.id.buttonSave)
        buttonClear = findViewById(R.id.buttonClear)
        listViewTags = findViewById(R.id.listViewTags)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tagsList)
        listViewTags.adapter = adapter

        buttonSave.setOnClickListener {
            val tag = editTextTag.text.toString()
            if (tag.isNotEmpty()) {
                tagsList.add(tag)
                adapter.notifyDataSetChanged()
                editTextTag.text.clear()
            } else {
                Toast.makeText(this, "Enter a tag", Toast.LENGTH_SHORT).show()
            }
        }

        buttonClear.setOnClickListener {
            tagsList.clear()
            adapter.notifyDataSetChanged()
        }

        listViewTags.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Edit ${tagsList[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
