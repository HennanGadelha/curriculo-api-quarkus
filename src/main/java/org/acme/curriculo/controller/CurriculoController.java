package org.acme.curriculo.controller;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import org.acme.curriculo.TitularCurriculo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/curriculos")
@ApplicationScoped
public class CurriculoController {


    @GET
    public Uni<List<TitularCurriculo>> findAll() {
        return TitularCurriculo.listAll();

    }

    @GET
    @Path("/{id}")
    public Uni<TitularCurriculo> getSingle(Long id) {
        return TitularCurriculo.findById(id);
    }

    @POST
    public Uni<Response> create(TitularCurriculo titularCurriculo) {
        return Panache.<TitularCurriculo>withTransaction(titularCurriculo::persist)
                .onItem().transform(inserted -> Response.created(URI.create("/curriculos/" + inserted.id)).build());
    }

    @DELETE
    public void deleteById(int id){
        TitularCurriculo.deleteById(id);
    }
}
