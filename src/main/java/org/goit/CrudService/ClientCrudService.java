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
       } catch (Exception e) {
           throw new RuntimeException("User creation failed");
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
       } catch (NoSuchElementException e) {
           throw new NoSuchElementException("Клієнта не існує");
       }
   }

    public List<Client> getAll() {
        try {
            Session session = getSession();
            return session.createQuery("from Client ", Client.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getSession() {
        return HibernateUtil.getInstance().getSessionFactory().openSession();
    }


}
