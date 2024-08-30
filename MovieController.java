package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Movie;
import com.example.demo.entities.Review;
import com.example.demo.services.MovieService;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
	 @Autowired
	    private MovieService movieService;

	    @GetMapping("/{id}")
	    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
	        return ResponseEntity.ok(movieService.getMovieById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String query) {
	        return ResponseEntity.ok(movieService.searchMovies(query));
	    }

	    @PostMapping("/{id}/reviews")
	    public ResponseEntity<Review> addReview(@PathVariable Long id, @RequestBody Review review) {
	        return ResponseEntity.ok(movieService.addReview(id, review));
	    }

	    @GetMapping("/{id}/reviews")
	    public ResponseEntity<List<Review>> getReviewsByMovieId(@PathVariable Long id) {
	        return ResponseEntity.ok(movieService.getReviewsByMovieId(id));
	    }
}
