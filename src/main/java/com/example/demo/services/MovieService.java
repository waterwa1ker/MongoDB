package com.example.demo.services;

import com.example.demo.models.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }


    public void delete(Movie movie){
        movieRepository.delete(movie);
    }

    public Movie findByTitle(String title){
        return movieRepository.findByTitle(title).orElse(null);
    }

}
