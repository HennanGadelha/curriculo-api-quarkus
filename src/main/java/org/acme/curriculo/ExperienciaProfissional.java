package org.acme.curriculo;

import net.bytebuddy.asm.Advice;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Cacheable
public class ExperienciaProfissional {

    @Id
    private UUID id;
    private String empresa;
    private String cargo;
    private LocalDate anoInicio;
    private LocalDate anoFim;

    public ExperienciaProfissional(String empresa, String cargo, LocalDate anoInicio, LocalDate anoFim) {
        this.id = UUID.randomUUID();
        this.empresa = empresa;
        this.cargo = cargo;
        this.anoInicio = anoInicio;
        this.anoFim = anoFim;
    }

    @Deprecated
    public ExperienciaProfissional(){}

    public UUID getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
