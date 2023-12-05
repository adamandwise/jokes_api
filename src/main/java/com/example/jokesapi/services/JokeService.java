package com.example.jokesapi.services;

import com.example.jokesapi.db.IJokesRepository;
import com.example.jokesapi.model.Joke;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JokeService
{
   private IJokesRepository repo;

   public JokeService(IJokesRepository repo){
       this.repo = repo;
   }

    public List<Joke> getAllJokes()
    {
        return repo.findAll();
    }

    //research optional class and .stream() methods
    public Joke getJokeById(int id)
    {
        // the filter() method receives a lambda method
       Optional <Joke> found = repo.findById(id);

       return found.orElse(null);


    }

    public boolean jokeExistsById(int id){
       return repo.findById(id).isPresent();
    }

    public Joke random()
    {
        Random random = new Random();
        List<Joke> jokes = getAllJokes();
        return jokes.get(random.nextInt(jokes.size()));
    }

    public Joke addJoke(Joke joke)
    {
        joke = repo.save(joke);

        //TODO make sure our joke is returned with a new id

        return joke;
    }

    public  Joke updateJoke(Joke updatedJoke)
    {
        Joke savedJoke = getJokeById(updatedJoke.getId());
        savedJoke.setJokeText(updatedJoke.getJokeText());
        //save our changes to our joke to the db
        savedJoke = repo.save(savedJoke);
        return savedJoke;
    }

    public void deleteJoke(int id)
    {
       repo.deleteById(id);
    }


}