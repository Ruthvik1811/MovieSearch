package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.entities.Review;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.ReviewRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServiceImplementation implements MovieService {
	@Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    @Override
    public List<Movie> searchMovies(String query) {
        return movieRepository.findByTitleContaining(query);
    }

    @Override
    public Review addReview(Long movieId, Review review) {
        Movie movie = getMovieById(movieId);
        review.setMovie(movie);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
