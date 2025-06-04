// MainActivity.kt
package com.example.todolistapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var taskInput: EditText
    private lateinit var addButton: Button
    private lateinit var taskListView: ListView

    private val taskList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linking UI with Kotlin code
        taskInput = findViewById(R.id.taskInput)
        addButton = findViewById(R.id.addButton)
        taskListView = findViewById(R.id.taskListView)

        // Adapter to display list in ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        taskListView.adapter = adapter

        // When Add Button is clicked
        addButton.setOnClickListener {
            val task = taskInput.text.toString()
            if (task.isNotEmpty()) {
                taskList.add(task)     // Add task to list
                adapter.notifyDataSetChanged() // Update ListView
                taskInput.text.clear() // Clear input box
            } else {
                Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // When item in list is clicked: remove it
        taskListView.setOnItemClickListener { _, _, position, _ ->
            taskList.removeAt(position)  // Remove clicked task
            adapter.notifyDataSetChanged() // Refresh the list


        }
    }
}
