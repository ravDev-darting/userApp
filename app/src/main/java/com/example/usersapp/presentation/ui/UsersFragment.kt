package com.example.usersapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.R
import com.example.usersapp.data.remote.RetrofitClient
import com.example.usersapp.data.remote.repository.UserRepositoryImpl
import com.example.usersapp.databinding.FragmentUsersBinding
import com.example.usersapp.domain.model.usecase.GetUsersUseCase
import com.example.usersapp.presentation.ui.adapter.UsersAdapter
import com.example.usersapp.presentation.ui.viewmodel.UsersUiState
import com.example.usersapp.presentation.ui.viewmodel.UsersViewModel
import kotlinx.coroutines.launch

class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var viewModel: UsersViewModel
    private lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentUsersBinding.bind(view)

        adapter = UsersAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        val repository = UserRepositoryImpl(RetrofitClient.apiService)
        viewModel = UsersViewModel(GetUsersUseCase(repository))

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is UsersUiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.errorText.visibility = View.GONE
                    }
                    is UsersUiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorText.visibility = View.GONE
                        adapter.submitList(state.users)
                    }
                    is UsersUiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorText.visibility = View.VISIBLE
                        binding.errorText.text = state.message
                    }
                }
            }
        }
    }
}
