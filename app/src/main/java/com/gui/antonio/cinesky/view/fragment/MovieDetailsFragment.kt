package com.gui.antonio.cinesky.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBinderMapperImpl
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.gui.antonio.cinesky.R
import com.gui.antonio.cinesky.databinding.FragmentMovieDetailsBinding
import com.gui.antonio.cinesky.utils.Constants
import com.gui.antonio.cinesky.view.activity.MainActivity

class MovieDetailsFragment : Fragment() {

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate (
            inflater,
            R.layout.fragment_movie_details,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(Constants.KEY_TITLE_MOVIE)?.let {
            (activity as MainActivity).viewModel.getMovie(it).observe(this, Observer {
                Glide.with(binding.ivMovie).load(it.coverUrl).placeholder(R.drawable.error_404).into(binding.ivMovie)
                binding.movie = it
            })
        }
    }
}