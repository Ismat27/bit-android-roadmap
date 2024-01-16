package com.alat.roadmap

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alat.roadmap.databinding.FragmentTodoBinding
import com.alat.roadmap.network.Todo

class TodoRecyclerViewAdapter(private var items: List<Todo> = emptyList()) :
    RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(binding: FragmentTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        private val tvTitle = binding.tvTitle

        fun bind(todo: Todo) {
            tvTitle.text = todo.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems:List<Todo> ) {
        this.items = newItems
        notifyDataSetChanged()
    }
}