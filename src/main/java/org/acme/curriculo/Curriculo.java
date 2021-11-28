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

    @OneToOne
    private TitularCurriculo titularCurriculo;

    @OneToMany
    private List<FormacaoAcademica> formacoesAcademicas = new ArrayList<>();

    @OneToMany
    private List<ExperienciaProfissional> experienciasProfissionais = new ArrayList<>();

    @Deprecated
    public Curriculo(){}

    public TitularCurriculo getTitularCurriculo() {
        return titularCurriculo;
    }

    public void setTitularCurriculo(TitularCurriculo titularCurriculo) {
        this.titularCurriculo = titularCurriculo;
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
