package org.acme.curriculo.titular.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import org.acme.curriculo.model.Curriculo;

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
    private String cpf;
    @Column(length = 60, unique = true)
    private String email;

    public TitularCurriculo(String nome, String cpf, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
