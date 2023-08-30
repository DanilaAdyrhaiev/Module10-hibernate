package org.goit;

import org.goit.CrudService.ClientCrudService;
import org.goit.entities.Client;
import org.goit.flyway.Migration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Migration().migrate();

        List<Client> clients = new ClientCrudService().getAll();
        for(Client client : clients){
            System.out.println(client.toString());
        }
        System.out.println();
        new ClientCrudService().createClient(new Client("Goit`s Admin"));
        clients = new ClientCrudService().getAll();
        for(Client client : clients){
            System.out.println(client.toString());
        }
        //numb - виберіть id
        int numb = 11;
        new ClientCrudService().deleteClientById(numb);
        clients = new ClientCrudService().getAll();
        for(Client client : clients){
            System.out.println(client.toString());
        }

    }
}