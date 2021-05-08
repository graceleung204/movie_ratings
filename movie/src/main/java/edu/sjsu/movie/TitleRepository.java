package edu.sjsu.movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.springapi.model.*;

public interface TitleRepository extends JpaRepository<Title, Long> {
    Optional<Title> findByPrimaryTitle(String PrimaryTitle);
}
