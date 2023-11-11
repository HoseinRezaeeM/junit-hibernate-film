import org.hibernate.Session;
import repository.FilmRepository;
import repository.impl.FilmRepositoryImpl;
import service.FilmService;
import service.impl.FilmServiceImpl;

public class ApplicationContext {
    private static  Session SESSION;
    private static final FilmRepository FILM_REPOSITORY;
    private static final FilmService FILM_SERVICE;
    static{
        SESSION =SessionFactoryProvider.getSessionFactory().openSession();
        FILM_REPOSITORY =new FilmRepositoryImpl(SESSION);
        FILM_SERVICE =new FilmServiceImpl(FILM_REPOSITORY);
    }

    public static FilmService getFilmService(){
        return FILM_SERVICE;
    }
}
