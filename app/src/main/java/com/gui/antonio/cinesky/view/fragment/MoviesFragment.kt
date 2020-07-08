package com.gui.antonio.cinesky.view.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gui.antonio.cinesky.R
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.utils.Constants
import com.gui.antonio.cinesky.view.activity.MainActivity
import com.gui.antonio.cinesky.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (isConnected) {
            (activity as MainActivity).viewModel.getMovies().observe(this, Observer {
                setAdapter(it)
                progressBar.visibility = View.GONE
            })

            (activity as MainActivity).viewModel.getMoviesError.observe(this, Observer {
                progressBar.visibility = View.GONE
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            })
        } else {
            (activity as MainActivity).viewModel.getMoviesOffline().observe(this, Observer {
                setAdapter(it)
                progressBar.visibility = View.GONE
            })
        }
    }

    private fun setAdapter(it: List<Movies>) {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = MovieAdapter(it) { movie ->
            val args = Bundle()
            args.putString(Constants.KEY_TITLE_MOVIE, movie.title)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_moviesFragment_to_movieDetailsFragment, args)
        }
    }

}