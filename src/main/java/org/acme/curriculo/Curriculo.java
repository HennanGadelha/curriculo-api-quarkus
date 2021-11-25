package org.acme.curriculo;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import org.acme.curriculo.TitularCurriculo;

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
    @OneToMany
    private List<FormacaoAcademica> formacaoAcademica = new ArrayList<>();
    @OneToMany
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();


    @Deprecated
    public Curriculo(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TitularCurriculo getTitularCurriculo() {
        return titularCurriculo;
    }

    public void setTitularCurriculo(TitularCurriculo titularCurriculo) {
        this.titularCurriculo = titularCurriculo;
    }

    public List<FormacaoAcademica> getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
        this.formacaoAcademica.add(formacaoAcademica);
    }

    public List<ExperienciaProfissional> getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional.add(experienciaProfissional);
    }
}
