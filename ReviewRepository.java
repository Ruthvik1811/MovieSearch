package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByMovieId(Long movieId);
}
