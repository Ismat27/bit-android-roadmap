package com.alat.roadmap

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alat.roadmap.databinding.FragmentPostBinding
import com.alat.roadmap.network.Post


class PostRecyclerViewAdapter(
    private var values: List<Post>,
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
        holder.bind(item)
    }

    override fun getItemCount(): Int = values.size

    @SuppressLint("NotifyDataSetChanged")
    fun setPosts(newPosts: List<Post>) {
        this.values = newPosts
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: FragmentPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val tvTitle: TextView = binding.tvTitle
        private val tvBody: TextView = binding.tvBody

        fun bind(item: Post) {
            tvTitle.text = item.title
            tvBody.text = item.body
            binding.root.setOnClickListener {
                val direction =
                    PostFragmentDirections.actionPostFragmentToPostDetailFragment(item.id)
                it.findNavController().navigate(direction)
            }
        }
    }

}