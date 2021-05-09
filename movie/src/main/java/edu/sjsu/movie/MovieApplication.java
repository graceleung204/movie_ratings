package edu.sjsu.movie;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

    // private static final String connectionString = "mongodb+srv://dbUser:dbUserPassword@cluster0.zsakm.mongodb.net/movie_ratings?retryWrites=true&w=majority";
    private static final String connectionString = "mongodb://admin:cmpe172@localhost:27017";
    private static final String databaseName = "movie";

    MongoClient mongoClient;
    MongoDatabase database;

    MongoCollection<Document> title;
    MongoCollection<Document> ratings;
    MongoCollection<Document> principals;
    MongoCollection<Document> crew;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Application started!");
        log.info("Connecting to database...");
        mongoClient = MongoClients.create(connectionString);
        log.info("MongoClient created: " + mongoClient.toString());

        log.info("Accessing database...");
        database = mongoClient.getDatabase(databaseName);
        log.info("MongoDatabase created: " + database.toString());

        testQuery();

        log.info("Loading collections...");
        title = database.getCollection("title");
        ratings = database.getCollection("ratings");
        principals = database.getCollection("principals");  // Actors, etc
        crew = database.getCollection("crew"); // Directors, writers
        log.info("Collections loaded.");

        // aggregation test
        genreAverageYear("Short");

    }
    
    public void testQuery() {
        log.info("Getting ratings collection...");
        MongoCollection<Document> ratingsCollection = database.getCollection("ratings");
        log.info("MongoCollection ratingsCollection created: " + ratingsCollection.toString());

        Document myDoc = ratingsCollection.find().first();
        System.out.println("Test query: First item in ratings collection:");
        System.out.println(myDoc.toJson());
    }

    public void genreAverageYear(String genre) {
        title.aggregate(
            Arrays.asList(
                Aggregates.match(Filters.eq("genres", "Short")),
                Aggregates.group("$genres", Accumulators.average("startYear")  // .sum("count", 1))
                )
            ).forEach(doc -> System.out.println(doc.toJson())
        );
    }
}
