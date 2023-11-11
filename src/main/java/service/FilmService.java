package service;

import entity.Film;

import java.util.List;

public interface FilmService {
    void save(Film film);
    Film findById(Integer id);
    void update(Film film, Integer id);
    List<Film> findAll();
    void remove(Integer id);
    List<Film> findByDirector(String directorName);
    List<Film> findRatingOverMinRate(Integer minRate);
    List<Film> findLongestFilm();
}
