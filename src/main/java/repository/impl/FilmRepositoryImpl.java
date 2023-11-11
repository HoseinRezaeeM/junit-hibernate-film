package repository.impl;

import entity.Film;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import repository.FilmRepository;

import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {
    Session session;

    public FilmRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Film film) {
        try {
            //session.getTransaction().begin();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public Film findById(Integer id) {
        String hql = "select f from Film f where id=:id";
        Query<Film> query = session.createQuery(hql, Film.class);
        query.setParameter("id", id);
        List<Film> singleResult = query.list();
        session.close();
        return singleResult.get(0);
    }

    @Override
    public List<Film> findAll() {
        String hql = "select f from Film f";
        Query<Film> query = session.createQuery(hql, Film.class);
        return query.list();
    }

    @Override
    public void update(Film film, Integer id) {
        String hql = "update Film f set f.description=:description where f.id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("description", film.getDescription());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public void remove(Integer id) {
        String hql = "delete from Film where id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Film> findRatingOverMinRate(Integer minRate) {
        String hql = "select f from Film f where rating>=:minRate";
        Query<Film> query = session.createQuery(hql, Film.class);
        query.setParameter("minRate", minRate);
        List<Film> Result = query.list();
        session.close();
        return Result;
    }

    @Override
    public List<Film> findLongestFilm() {
        String hql = "SELECT f1.title,f1.length FROM film f1 WHERE f1.length=(SELECT max(f2.length) FROM film f2)";
        List<Film> films=new ArrayList<>();
        NativeQuery sqlQuery = session.createSQLQuery(hql);
        List<Object[]> list = sqlQuery.getResultList();
        for (Object[] object : list) {
            films.add(new Film((String)object[0],(BigInteger) object[1]));
        }
        session.close();
        return films;
    }
}
