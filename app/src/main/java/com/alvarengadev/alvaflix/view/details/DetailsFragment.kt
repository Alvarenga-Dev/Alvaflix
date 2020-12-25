package com.alvarengadev.alvaflix.view.details

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.database.AlvaflixDatabase
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository
import com.alvarengadev.alvaflix.extensions.layoutHorizontal
import com.alvarengadev.alvaflix.utils.FormatDate
import com.alvarengadev.alvaflix.view.details.adapter.similar.MovieSimilarAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by activityViewModels(
        factoryProducer = {
            val database = AlvaflixDatabase.getInstance(requireContext())
            DetailsViewModelFactory(
                databaseDataSourceRepository = DatabaseDataSourceRepository(database.movieFavoritesDao)
            )
        }
    )
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initComponents()
    }

    private fun initComponents() {
        ib_details_back.setOnClickListener {
            findNavController().navigateUp()
        }

        val movie = args.movie

        tv_details_title_movie.text = movie.title
        tv_details_value_rating_movie.text = movie.rating
        tv_details_year_movie.text = getString(R.string.label_date_movies_details, FormatDate.getDate(movie.date))
        tv_details_description_movie.text = movie.description

        btn_details_add_list.setOnClickListener(addMovieFavorite(movie))

        val imagePoster = movie.posterDetails ?: movie.poster

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${imagePoster}")
            .into(iv_details_poster_movie)

        viewModel.getListMovieSimilar(movie.id)
        viewModel.listMovieSimilarData.observe(viewLifecycleOwner, { listMoviesSimilar ->
            if (listMoviesSimilar.isNullOrEmpty()) {
                tv_details_similar_movies.visibility = View.INVISIBLE
                rcy_details_similar_movies.visibility = View.INVISIBLE
            } else {
                tv_details_similar_movies.visibility = View.VISIBLE
                rcy_details_similar_movies.apply {
                    visibility = View.VISIBLE
                    adapter = MovieSimilarAdapter(listMoviesSimilar)
                    layoutManager = this.layoutHorizontal()
                }
            }
        })
    }

    private fun addMovieFavorite(movie: Movie) = View.OnClickListener {
        viewModel.insertMovieFavorite(movie)
    }
}