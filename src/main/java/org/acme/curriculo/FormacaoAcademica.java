package org.acme.curriculo;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Cacheable
public class FormacaoAcademica extends PanacheEntity {

    private String instituicao;
    private String curso;
    private LocalDate anoInicio;
    private LocalDate anoFim;

    public FormacaoAcademica(String instituicao, String curso, LocalDate anoInicio, LocalDate anoFim) {
        this.instituicao = instituicao;
        this.curso = curso;
        this.anoInicio = anoInicio;
        this.anoFim = anoFim;
    }

    @Deprecated
    public FormacaoAcademica(){}

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(LocalDate anoInicio) {
        this.anoInicio = anoInicio;
    }

    public LocalDate getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(LocalDate anoFim) {
        this.anoFim = anoFim;
    }
}
