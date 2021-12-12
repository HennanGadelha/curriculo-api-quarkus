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

    @OneToOne(cascade = CascadeType.PERSIST)
    private TitularCurriculo titularCurriculo;


    @Deprecated
    public Curriculo(){}

    public Curriculo(TitularCurriculo titularCurriculo) {
        this.titularCurriculo = titularCurriculo;
    }

    public TitularCurriculo getTitularCurriculo() {
        return titularCurriculo;
    }

    public void setTitularCurriculo(TitularCurriculo titularCurriculo) {
        this.titularCurriculo = titularCurriculo;
    }


}
