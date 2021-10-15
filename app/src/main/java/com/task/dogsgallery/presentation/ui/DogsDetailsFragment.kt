package com.task.dogsgallery.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.task.dogsgallery.databinding.FragmentDogsDetailsBinding
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.presentation.util.loadUrl


class DogsDetailsFragment : Fragment() {
    private var _binding: FragmentDogsDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DogsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setupActionBar(binding.dogToolbar)
        val dog: DogsDomainEntities.DogsDomainItem = args.dogsDetailsFragmentArgs
        with(binding) {
            dogCollapsingToolbar.title = dog.name
            dogContentScrolling.dogShortDescriptionTextView.text = dog.shortDescription
            dogContentScrolling.dogLongDescriptionTextView.text = dog.description
            dogToolbarImageView.loadUrl(dog.imageUrl)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}