package com.example.jokesapi.controllers;

import com.example.jokesapi.model.Joke;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jokesapi.services.JokeService;

import java.util.List;

@RestController
public class JokesAPI {

    private JokeService service;

    public JokesAPI(JokeService service)
    {
        this.service = service;
    }

   @GetMapping("jokes")//http://localhost:8080/jokes
    public ResponseEntity<List<Joke>> allJokes()
    {
        return new ResponseEntity<>(service.getAllJokes(), HttpStatus.OK);
    }

    @GetMapping("jokes/random")
    public Joke random()
    {
        return service.random();
    }

    @GetMapping("jokes/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable int id)
    {
        return new ResponseEntity<>(service.getJokeById(id),HttpStatus.OK);
    }


    //pass in a new joke object through the request body
    @PostMapping("jokes")
    public ResponseEntity<Joke> addJoke(@RequestBody Joke joke)
    {
      return new ResponseEntity<>(service.addJoke(joke),HttpStatus.CREATED);
    }

    @PostMapping("jokes/query")
    public ResponseEntity<Joke> addJoke(@RequestParam String author,@RequestParam String text)
    {   Joke newJoke = new Joke(author+":"+text);
        return new ResponseEntity<>(service.addJoke(newJoke),HttpStatus.CREATED);
    }

    @PutMapping("jokes")
    public ResponseEntity<Joke> editJoke(@RequestBody Joke joke)
    {
        if(!service.jokeExistsById(joke.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

            return new ResponseEntity<>(service.updateJoke(joke) , HttpStatus.CREATED);
    }

    @DeleteMapping("jokes")
    public ResponseEntity deleteJoke(@RequestBody Joke joke)
    {
        if(!service.jokeExistsById(joke.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteJoke(joke.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
