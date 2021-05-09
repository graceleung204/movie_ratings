package edu.sjsu.movie;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

// import com.example.springapi.model.*;

public interface TitleRepository extends MongoRepository<Title, String> {
    Optional<Title> findByPrimaryTitle(String PrimaryTitle);
}
