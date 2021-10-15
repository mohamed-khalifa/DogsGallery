package com.task.dogsgallery.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.task.dogsgallery.databinding.DogItemBinding
import com.task.dogsgallery.domain.entity.DogsDomainEntities
import com.task.dogsgallery.presentation.util.loadUrl

class DogsGalleryAdapter(private val dogs: List<DogsDomainEntities.DogsDomainItem>) :
    RecyclerView.Adapter<DogsGalleryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DogItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogs[position])
    }

    override fun getItemCount(): Int = dogs.size

    inner class ViewHolder(private val binding: DogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dogsDomainItem: DogsDomainEntities.DogsDomainItem) {
            with(dogsDomainItem) {
                binding.dogTitleTextView.text = this.name
                binding.dogShortDescriptionTextView.text = this.shortDescription
                binding.dogImageView.loadUrl(this.imageUrl)
            }

            this.itemView.setOnClickListener {
                val directions =
                    DogsGalleryFragmentDirections.actionDogsGalleryFragmentToDogsDetailsFragment(
                        dogsDomainItem
                    )
                it.findNavController()
                    .navigate(directions, navOptions {
                        anim {
                            enter = android.R.animator.fade_in
                            exit = android.R.animator.fade_out
                        }
                    })
            }
        }
    }

}