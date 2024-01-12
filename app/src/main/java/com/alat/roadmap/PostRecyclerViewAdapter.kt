package com.alat.roadmap

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alat.roadmap.databinding.FragmentPostBinding
import com.alat.roadmap.network.Post


class PostRecyclerViewAdapter(
    private var values: List<Post>
) : RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tvTitle.text = item.title
        holder.tvBody.text = item.body
    }

    override fun getItemCount(): Int = values.size

    @SuppressLint("NotifyDataSetChanged")
    fun setPosts(newPosts: List<Post>) {
        this.values = newPosts
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FragmentPostBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle : TextView = binding.tvTitle
        val tvBody : TextView = binding.tvBody
    }

}