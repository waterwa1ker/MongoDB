package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/api/v1")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll(){
        return movieService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResponseEntity.ok("Ошибка!");
        }
        movieService.save(movie);
        return ResponseEntity.ok("Успешно!");
    }

    @DeleteMapping("/delete/{title}")
    public ResponseEntity<String> deleteMovie(@PathVariable String title){
        Movie movie = movieService.findByTitle(title);
        if (movie == null){
            return ResponseEntity.ok("Не найдено!");
        }
        movieService.delete(movie);
        return ResponseEntity.ok("Успешно!");
    }

}
