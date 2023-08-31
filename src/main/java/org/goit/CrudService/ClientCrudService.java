package org.goit.CrudService;


import org.goit.entities.Client;
import org.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.NoSuchElementException;

public class ClientCrudService {
   public void createClient(Client client){
       try{
           Session session = getSession();
           Transaction transaction = session.beginTransaction();
           session.save(client);
           transaction.commit();
           session.close();
       } catch (Exception e) {
           throw new RuntimeException("User creation failed");
       }
   }

    public Client readClientById(long id) {
        try (Session session = getSession()
        ) {
            Client client = session.get(Client.class, id);
            session.close();
            return client;
        }
    }

    public void updateClientById(long id, String name) {
        try (Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                client.setName(name);
                session.persist(client);
                transaction.commit();
            } else {
                throw new NoSuchElementException();
            }
            session.close();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Client with such ID doesn't exist");
        }
    }

   public void deleteClientById(long id){
       Client client;
       try{
           Session session = getSession();
           Transaction transaction = session.beginTransaction();
           client = session.get(Client.class, id);
           if (client != null) {
               session.remove(client);
               transaction.commit();
           } else {
               throw new NoSuchElementException();
           }
           session.close();
       } catch (NoSuchElementException e) {
           throw new NoSuchElementException("Клієнта не існує");
       }
   }

    public List<Client> getAll() {
        try {
            Session session = getSession();
            List<Client> clients = session.createQuery("from Client ", Client.class).list();
            session.close();
            return clients;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getSession() {
        return HibernateUtil.getInstance().getSessionFactory().openSession();
    }


}
