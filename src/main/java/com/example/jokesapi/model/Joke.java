package com.example.jokesapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jokeText;


    public Joke(String jokeText) {


        this.jokeText = jokeText;
    }

    public Joke(int id, String jokeText) {
        this.id = id;
        this.jokeText = jokeText;
    }

    public Joke() {
    }

    public int getId() {
        return this.id;
    }

    public String getJokeText() {
        return this.jokeText;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Joke)) return false;
        final Joke other = (Joke) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$jokeText = this.getJokeText();
        final Object other$jokeText = other.getJokeText();
        if (this$jokeText == null ? other$jokeText != null : !this$jokeText.equals(other$jokeText)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Joke;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $jokeText = this.getJokeText();
        result = result * PRIME + ($jokeText == null ? 43 : $jokeText.hashCode());
        return result;
    }

    public String toString() {
        return "Joke(id=" + this.getId() + ", jokeText=" + this.getJokeText() + ")";
    }


}
