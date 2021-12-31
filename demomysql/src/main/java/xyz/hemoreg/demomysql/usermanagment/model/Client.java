package xyz.hemoreg.demomysql.usermanagment.model;

import lombok.Getter;
import lombok.Setter;
import xyz.hemoreg.demomysql.usermanagment.dto.ProductDTO;
import xyz.hemoreg.demomysql.usermanagment.dto.ClientDTO;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    public ClientDTO toClientDTO() {
        return new ClientDTO(id, name, email, age);
    }
}