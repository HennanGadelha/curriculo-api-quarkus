package org.acme.curriculo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Cacheable
public class FormacaoAcademica {

    @Id
    private UUID id;
    private String instituicao;
    private String curso;
    private LocalDate anoInicio;
    private LocalDate anoFim;

    public FormacaoAcademica(String instituicao, String curso, LocalDate anoInicio, LocalDate anoFim) {
        this.id = UUID.randomUUID();
        this.instituicao = instituicao;
        this.curso = curso;
        this.anoInicio = anoInicio;
        this.anoFim = anoFim;
    }

    @Deprecated
    public FormacaoAcademica(){}

    public UUID getId() {
        return id;
    }

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
