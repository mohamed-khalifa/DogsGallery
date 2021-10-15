package com.task.dogsgallery.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.task.dogsgallery.databinding.FragmentDogsGalleryBinding
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.presentation.viewmodel.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsGalleryFragment : Fragment() {
    private var _binding: FragmentDogsGalleryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDogs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogsGalleryBinding.inflate(inflater, container, false)
        binding.dogsGalleryRecyclerView.apply {
            setLayoutManager(GridLayoutManager(context, 2))
            addVeiledItems(16)
        }
        binding.dogsErrorView.retryButton.setOnClickListener {
            viewModel.getDogs()
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingState.observe(viewLifecycleOwner) {
            handleLoading(it)
        }

        viewModel.uiDataState.observe(viewLifecycleOwner) { result ->
            when (result) {
                is DogsDomainEntities.DogsDomain -> updateDogsList(result)
                is DogsDomainEntities.Failure -> handleError(result.errorText)
            }
        }
    }

    private fun handleLoading(loading: DogsDomainEntities.Loading) {
        if (loading.inProgress) {
            binding.dogsErrorView.errorView.visibility = View.GONE
            binding.dogsGalleryRecyclerView.veil()
        } else {
            binding.dogsGalleryRecyclerView.unVeil()
        }
    }

    private fun updateDogsList(dogsDomain: DogsDomainEntities.DogsDomain) {
        val adapter = DogsGalleryAdapter(dogsDomain.dogs)
        binding.dogsGalleryRecyclerView.setAdapter(adapter)
    }

    private fun handleError(errorText: String) {
        binding.dogsErrorView.errorView.visibility = View.VISIBLE
        binding.dogsErrorView.errorTextView.text = errorText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}