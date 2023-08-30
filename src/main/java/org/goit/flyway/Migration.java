package org.goit.flyway;

import org.flywaydb.core.Flyway;

public class Migration {
    public static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/module10";
    public static final String dbUser = "root";
    public static final String dbPass = "Asosl@n2002";

    public void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPass)
                .load();

        flyway.migrate();
        System.out.println("Database migration successful!");
    }
}
