package service.impl;

import entity.Film;
import repository.FilmRepository;
import repository.impl.FilmRepositoryImpl;
import service.FilmService;

import java.util.List;
import java.util.stream.Collectors;

public class FilmServiceImpl implements FilmService {
    FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void save(Film film) {
        filmRepository.save(film);
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findById(id);
    }

    @Override
    public void update(Film film, Integer id) {
        filmRepository.update(film, id);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        filmRepository.remove(id);
    }

    @Override
    public List<Film> findByDirector(String directorName) {
        return filmRepository.findAll().stream()
                .filter(film -> film.getDirector().equals(directorName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> findRatingOverMinRate(Integer minRate) {
        return filmRepository.findRatingOverMinRate(minRate);
    }

    @Override
    public List<Film> findLongestFilm() {
        return filmRepository.findLongestFilm();
    }
}
