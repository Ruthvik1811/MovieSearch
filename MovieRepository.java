package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitleContaining(String title);
}
