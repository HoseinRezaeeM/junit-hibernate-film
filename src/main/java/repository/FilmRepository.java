package repository;

import entity.Film;

import java.util.List;

public interface FilmRepository {
    void save(Film film);
    Film findById(Integer id);
    List<Film> findAll();
    void update(Film film,Integer id);
    void remove(Integer id);
    List<Film> findRatingOverMinRate(Integer minRate);
    List<Film> findLongestFilm();


}
