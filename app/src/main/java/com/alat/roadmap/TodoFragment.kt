package com.alat.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alat.roadmap.databinding.FragmentTodoListBinding
import com.alat.roadmap.utils.RequestStatus
import com.alat.roadmap.viewmodel.TodoViewModel

class TodoFragment : Fragment() {

    private val adapter = TodoRecyclerViewAdapter()
    private val viewModel by viewModels<TodoViewModel> { TodoViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentTodoListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTodoListBinding.bind(view)
        binding.todoList.adapter = adapter

        viewModel.uiState.observe(viewLifecycleOwner) {
            if(it is RequestStatus.Success) {
                adapter.updateItems(it.data?: emptyList())
            }
        }
    }
}