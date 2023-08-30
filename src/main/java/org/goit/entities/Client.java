package org.goit.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    public Client(String name){
        this.name = name;
    }

    // Constructors, getters, setters
}
