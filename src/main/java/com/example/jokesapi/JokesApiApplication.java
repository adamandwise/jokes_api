package com.example.jokesapi;

import com.example.jokesapi.db.IJokesRepository;
import com.example.jokesapi.model.Joke;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JokesApiApplication {

    public static void main(String[] args) {

         SpringApplication.run(JokesApiApplication.class, args);

    }

}
