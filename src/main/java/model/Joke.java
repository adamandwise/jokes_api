package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joke
{
    private static int classIds = 0;
    private int id;
    private String jokeText;


    public Joke(String jokeText)
    {
        id = classIds;
        classIds++;

        this.jokeText = jokeText;
    }
}
