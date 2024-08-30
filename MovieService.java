package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Movie;
import com.example.demo.entities.Review;

public interface MovieService {
	Movie getMovieById(Long id);
    List<Movie> searchMovies(String query);
    Review addReview(Long movieId, Review review);
    List<Review> getReviewsByMovieId(Long movieId);
}
