package org.acme.curriculo.controller;

import io.smallrye.mutiny.Uni;
import org.acme.curriculo.Curriculo;
import org.acme.curriculo.TitularCurriculo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/curriculos")
@ApplicationScoped
public class CurriculoController {


    // TODO tirar dúvida com marcio sobre class Uni
//    @GET
//    public List<Curriculo> findAll() {
//        return curriculos;
//
//    }

    @GET
    public Uni<List<Curriculo>> findAll() {
        return Curriculo.listAll();

    }

//    @PUT
//    public Uni<Curriculo> update(Curriculo curriculo){
//
//        TitularCurriculo titularAlterado =
//                new TitularCurriculo("Hennan", "cpf", "hennan@gmail.com");
//
//        Curriculo curriculoTitularAlterado =
//                new Curriculo(titularAlterado, "sistemas para internet", "dev back end");
//
//
//    }

    @GET()
    public Uni<Curriculo> findById(UUID id) {
        return Curriculo.findById(id);
    }

    @DELETE
    public void deleteById(UUID id){
        Curriculo.deleteById(id);
    }
}
