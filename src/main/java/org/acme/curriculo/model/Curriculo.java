package org.acme.curriculo.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import org.acme.curriculo.titular.model.TitularCurriculo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Cacheable
public class Curriculo extends PanacheEntity {

    @Id
    private UUID id;
    @Column(length = 60, unique = true)
    @OneToOne
    private TitularCurriculo titularCurriculo;
    private String curso;
    private String experienciaProfissional;

    public Curriculo(TitularCurriculo titularCurriculo, String curso, String experienciaProfissional) {
        this.id = UUID.randomUUID();
        this.titularCurriculo = titularCurriculo;
        this.curso = curso;
        this.experienciaProfissional = experienciaProfissional;
    }

    @Deprecated
    public Curriculo(){}

    public TitularCurriculo getTitularCurriculo() {
        return titularCurriculo;
    }

    public void setTitularCurriculo(TitularCurriculo titularCurriculo) {
        this.titularCurriculo = titularCurriculo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(String experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

}
