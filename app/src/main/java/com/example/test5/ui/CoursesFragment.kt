package com.example.test5.ui

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.test5.BaseFragment
import com.example.test5.common.Resource
import com.example.test5.databinding.FragmentCoursesBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoursesFragment : BaseFragment<FragmentCoursesBinding>(FragmentCoursesBinding::inflate) {
    private val viewModel: CoursesFragmentViewModel by viewModels()
    private lateinit var activeCoursesAdapter: ActiveCoursesRecyclerAdapter

    override fun setUp() {
    }

    override fun listeners() {
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.responseFlow.collect {
                    when (it) {
                        is Resource.Error -> Toast.makeText(
                            requireContext(),
                            "Something went wrong",
                            Toast.LENGTH_SHORT
                        ).show()

                        is Resource.Loading -> {}
                        is Resource.Success -> activeCoursesAdapter =
                            ActiveCoursesRecyclerAdapter(it.data)
                    }
                }
            }
        }
    }
}