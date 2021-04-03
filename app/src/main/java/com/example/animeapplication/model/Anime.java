package com.example.animeapplication.model;

public class Anime {


    private String name;
    private String description;
    private String rating;
    private int nb_episode;
    private String categories;
    private String studio;
    private String img;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int nb_episode, String categories, String studio, String img) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.categories = categories;
        this.studio = studio;
        this.img = this.img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}


