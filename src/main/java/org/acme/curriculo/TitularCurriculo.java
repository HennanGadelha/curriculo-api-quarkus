package org.acme.curriculo;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Cacheable
public class TitularCurriculo extends PanacheEntity {

    @Column(length = 60)
    private String nome;
    @Column(length = 60)
    private String email;
    @Column(length = 11)
    private String telefone;


    @OneToMany
    private List<FormacaoAcademica> formacoesAcademicas = new ArrayList<>();

    @OneToMany
    private List<ExperienciaProfissional> experienciasProfissionais = new ArrayList<>();

    @Deprecated
    public TitularCurriculo(){}

    public TitularCurriculo(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<FormacaoAcademica> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void addFormacoesAcademicas(FormacaoAcademica formacaoAcademica) {
        this.formacoesAcademicas.add(formacaoAcademica);
    }

    public void addExperienciasProfissionais(ExperienciaProfissional experienciaProfissional) {
        this.experienciasProfissionais.add(experienciaProfissional);
    }
}
