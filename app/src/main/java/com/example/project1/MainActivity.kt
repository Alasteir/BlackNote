package com.example.project1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val enterText: EditText = findViewById(R.id.enterText)
        val listView: ListView = findViewById(R.id.listView)
        val button: Button = findViewById(R.id.button)


        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)

        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val text = parent.getItemAtPosition(position).toString()
            adapter.remove(text)
            Toast.makeText(this, "Delete element with text: $text" , Toast.LENGTH_LONG).show()

        }

        button.setOnClickListener {
            val text = enterText.text.toString().trim()
            if (text.isNotEmpty()) {
                adapter.insert(text, 0)
                enterText.text.clear()

            }
        }
    }
}







