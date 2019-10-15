package com.stackroute.movieservices.repository;

import com.stackroute.movieservices.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {

    List<Movie> findMovieByTitle(String title);

}
