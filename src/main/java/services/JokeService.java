package services;

import model.Joke;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class JokeService
{
    private List<Joke> jokes = new ArrayList<>(List.of(
            new Joke("What did Han Solo say to the waiter who recommended the haddock? Never sell me the cods!"),
            new Joke("Why didn’t any of Luke Skywalker’s marriages last? He always followed Obi-Wan’s advice: " +
                    "'Use divorce, Luke.'"),
            new Joke("What was Lando’s nickname before he became a skilled pilot? Crashdo."),
            new Joke("Why does Princess Leia keep her hair tied up in buns? So it doesn’t Hang Solow."),
            new Joke("What is Admiral Ackbar's favorite type of music? Trap."),
            new Joke("What do you call a rebel princess who only shops at Whole Foods? Leia Organic."),
            new Joke("What do you call an eel that loves the new Star Wars trilogy? A More-Rey Eel."),
            new Joke("Where did Luke get his cybernetic hand? The second hand store.")
    ));

    public List<Joke> getAllJokes()
    {
        return jokes;
    }

    //research optional class and .stream() methods
    public Joke getJokeById(int id)
    {
        // the filter() method receives a lambda method
       Optional <Joke> found = jokes.stream()
               .filter(joke -> joke.getId() == id)
               .findFirst();

       return found.get();
    }

    public Joke random()
    {
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }

    public void addJoke(Joke joke)
    {
        jokes.add(joke);
    }

    public  void updateJoke(Joke updatedJoke)
    {
        Joke savedJoke = getJokeById(updatedJoke.getId());
        savedJoke.setJokeText(updatedJoke.getJokeText());
    }

    public void deleteJoke(int id)
    {
        for (int i = 0; i < jokes.size(); i++) {
            if(jokes.get(i).getId() == id)
            {
                jokes.remove(i);
                break;
            }
        }
    }
}