package xyz.hemoreg.demopostgresql.usermanagment.model;

import lombok.Getter;
import lombok.Setter;
import xyz.hemoreg.demopostgresql.usermanagment.dto.ClientDTO;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private int age;

    private String adresse;

    public ClientDTO toClientDTO() {
        return new ClientDTO(id, name, email, age, adresse);
    }
}
