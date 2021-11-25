package org.acme.curriculo;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Cacheable
public class TitularCurriculo extends PanacheEntity {

    @Id
    private UUID id;
    @Column(length = 60, unique = true)
    private String nome;
    @Column(length = 60, unique = true)
    private String email;

    public TitularCurriculo(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
    }

    @Deprecated
    public TitularCurriculo(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
