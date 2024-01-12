package com.alat.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alat.roadmap.databinding.FragmentPostListBinding
import com.alat.roadmap.network.Post
import com.alat.roadmap.utils.RequestStatus
import com.alat.roadmap.viewmodel.PostViewModel

/**
 * A fragment representing a list of [Post] items.
 */
class PostFragment : Fragment() {

    private val viewModel by viewModels<PostViewModel> { PostViewModel.Factory }

    private val adapter = PostRecyclerViewAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentPostListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPostListBinding.bind(view)
        binding.postList.layoutManager = LinearLayoutManager(requireContext())
        binding.postList.adapter = adapter
        viewModel.postUiState.observe(viewLifecycleOwner) {
            if (it is RequestStatus.Success) {
                adapter.setPosts(it.data ?: emptyList())
            }
        }
    }

}