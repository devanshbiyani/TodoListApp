package com.example.todolistapp

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private var taskInput: EditText? = null
    private var addButton: Button? = null
    private var taskListView: ListView? = null
    private var emptyState: LinearLayout? = null
    private var taskCounter: TextView? = null
    private var adapter: TaskAdapter? = null
    private var taskList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        initializeViews()

        // Setup ListView
        setupListView()

        // Setup button click listener
        setupAddButton()

        // Update UI
        updateUI()
    }

    private fun initializeViews() {
        taskInput = findViewById(R.id.taskInput)
        addButton = findViewById(R.id.addButton)
        taskListView = findViewById(R.id.taskListView)
        emptyState = findViewById(R.id.emptyState)
        taskCounter = findViewById(R.id.taskCounter)
    }

    private fun setupListView() {
        // Initialize task list
        taskList = ArrayList()

        // Create custom adapter
        adapter = TaskAdapter()

        // Set adapter to ListView
        taskListView!!.adapter = adapter

        // Add long click listener to delete tasks
        taskListView!!.onItemLongClickListener =
            OnItemLongClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                val deletedTask = taskList!![position]
                taskList!!.removeAt(position)
                adapter!!.notifyDataSetChanged()
                updateUI()
                Toast.makeText(this@MainActivity, "\"$deletedTask\" deleted", Toast.LENGTH_SHORT)
                    .show()
                true
            }
    }

    private fun setupAddButton() {
        addButton!!.setOnClickListener { addTask() }

        // Also add task when Enter is pressed
        taskInput!!.setOnEditorActionListener { v: TextView?, actionId: Int, event: KeyEvent? ->
            addTask()
            true
        }
    }

    private fun addTask() {
        val task = taskInput!!.text.toString().trim { it <= ' ' }

        if (task.isEmpty()) {
            Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
            return
        }

        // Add task to list
        taskList!!.add(task)

        // Notify adapter of data change
        adapter!!.notifyDataSetChanged()

        // Clear input field - THIS IS THE FIX
        taskInput!!.text.clear()

        // Update UI
        updateUI()

        // Show confirmation with animation
        Toast.makeText(this, "✓ Task added successfully!", Toast.LENGTH_SHORT).show()
    }

    private fun updateUI() {
        // Update task counter
        val taskCount = taskList!!.size
        if (taskCount == 0) {
            taskCounter!!.text = "No tasks remaining"
            emptyState!!.visibility = View.VISIBLE
            taskListView!!.visibility = View.GONE
        } else {
            taskCounter!!.text =
                taskCount.toString() + (if (taskCount == 1) " task remaining" else " tasks remaining")
            emptyState!!.visibility = View.GONE
            taskListView!!.visibility = View.VISIBLE
        }
    }

    // Custom adapter for better-looking list items
    private inner class TaskAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return taskList!!.size
        }

        override fun getItem(position: Int): Any {
            return taskList!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var view = convertView
            if (view == null) {
                val inflater = LayoutInflater.from(this@MainActivity)
                view = inflater.inflate(R.layout.task_item, parent, false)
            }

            val taskText = view!!.findViewById<TextView>(R.id.taskText)
            taskText.text = taskList!![position]

            return view
        }
    }
}