package edu.sjsu.movie;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
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

    private static final String connectionString = "mongodb://admin:cmpe172@localhost:27017";
    private static final String databaseName = "movie";

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Application started!");
        log.info("Connecting to database...");
        MongoClient mongoClient = MongoClients.create(connectionString);
        log.info("MongoClient created: " + mongoClient.toString());

        log.info("Accessing database...");
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        log.info("MongoDatabase created: " + database.toString());

        log.info("Getting ratings collection...");
        MongoCollection<Document> ratingsCollection = database.getCollection("ratings");
        log.info("MongoCollection ratingsCollection created: " + ratingsCollection.toString());

        Document myDoc = ratingsCollection.find().first();
        System.out.println("First item in ratings collection:");
        System.out.println(myDoc.toJson());

        // System.out.println("1. Movies with the highest ratings");

    }
}
