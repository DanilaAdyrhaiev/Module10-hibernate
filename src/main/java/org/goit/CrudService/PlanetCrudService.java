package org.goit.CrudService;

import org.goit.entities.Client;
import org.goit.entities.Planet;
import org.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.NoSuchElementException;

public class PlanetCrudService {
    public void createPlanet(Planet planet){
        try{
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("User creation failed");
        }
    }

    public Planet readPlanetById(long id) {
        try (Session session = getSession()
        ) {
            Planet planet = session.get(Planet.class, id);
            session.close();
            return planet;
        }
    }

    public void updatePlanetById(long id, String name) {
        try (Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                planet.setName(name);
                session.persist(planet);
                transaction.commit();
            } else {
                throw new NoSuchElementException();
            }
            session.close();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Client with such ID doesn't exist");
        }
    }

    public void deletePlanetById(long id){
        Planet planet;
        try{
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
                transaction.commit();
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Планети не існує");
        }
    }

    public List<Planet> getAll() {
        try {
            Session session = getSession();
            return session.createQuery("from Planet ", Planet.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getSession() {
        return HibernateUtil.getInstance().getSessionFactory().openSession();
    }
}
