package org.goit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private String id;

    @Column(nullable = false, name = "name")
    private String name;

    public Planet(String name){
        this.name = name;
    }
}
