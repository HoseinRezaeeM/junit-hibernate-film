import entity.Film;
import org.hibernate.Session;

import java.util.List;


public class Q5Runner {
    public static void main(String[] args) {
        //Session session = SessionFactoryProvider.getSessionFactory().openSession();
       // Film film1 = new Film(null, "Gladiator", "Sina", "History", "film about history", 50000L, "English", 9);

        // ApplicationContext.getFilmService().save(film1);
       // System.out.println(ApplicationContext.getFilmService().findAll());
       // Film film2 = new Film(null, "Gladiator", "Sina", "History", "film about drama", 50000L, "English", 9);
       // ApplicationContext.getFilmService().update(film2, 5);
       // ApplicationContext.getFilmService().remove(5);
        //System.out.println(ApplicationContext.getFilmService().findById(6));
        //System.out.println(ApplicationContext.getFilmService().findRatingOverMinRate(5));
        List<Film> longestFilm = ApplicationContext.getFilmService().findLongestFilm();
        System.out.println(longestFilm);


    }
}
