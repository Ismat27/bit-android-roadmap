package com.alat.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alat.roadmap.databinding.FragmentPostDetailBinding
import com.alat.roadmap.utils.RequestStatus
import com.alat.roadmap.utils.capitalizeWords
import com.alat.roadmap.viewmodel.PostDetailViewModel

class PostDetailFragment : Fragment(R.layout.fragment_post_detail) {

    private lateinit var binding: FragmentPostDetailBinding

    private val viewModel by viewModels<PostDetailViewModel> { PostDetailViewModel.Factory }

    private val args by navArgs<PostDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId = args.postId

        viewModel.fetchPost(postId)

        binding.navBack.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.uiState.observe(viewLifecycleOwner) {
            if (it is RequestStatus.Success) {
                binding.tvTitle.text = it.data?.title?.capitalizeWords()
                binding.tvBody.text = it.data?.body?.capitalizeWords("\n")
            }
            if (it is RequestStatus.Loading) {
                binding.pbLoader.visibility = View.VISIBLE
            } else {
                binding.pbLoader.visibility = View.INVISIBLE
            }
        }
    }
}