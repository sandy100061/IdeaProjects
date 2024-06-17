package org.example;

public class Movie {


    private String movieId;
    private String title;
    private String releaseYear;



    private int daysLate;

    public Movie(String movieId, String title, String releaseDate, int daysLate) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseDate;
        this.daysLate = daysLate;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }
}

