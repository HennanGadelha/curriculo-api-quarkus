package org.acme.curriculo.controller;

import io.smallrye.mutiny.Uni;
import org.acme.curriculo.Curriculo;
import org.acme.curriculo.ExperienciaProfissional;
import org.acme.curriculo.FormacaoAcademica;
import org.acme.curriculo.TitularCurriculo;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curriculos")
@ApplicationScoped
public class CurriculoController {

    @GET
    public Uni<List<Curriculo>> findAll() {
        return Curriculo.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Curriculo> getSingle(Long id) {
        return Curriculo.findById(id);
    }

    @POST
    @Transactional
    public Response criarUsuario(TitularCurriculo titularCurriculo) {
       titularCurriculo.persist();
       return Response.ok(titularCurriculo).build();
    }

    @POST
    @Transactional
    @Path("/{id}/formacao-academica")
    public Response adicionarFormacaoAcademica(@PathParam("id") int id, FormacaoAcademica formacaoAcademica) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        formacaoAcademica.persist();
        titular.addFormacoesAcademicas(formacaoAcademica);

        return Response.ok(titular.getFormacoesAcademicas()).build();
    }

    @POST
    @Transactional
    @Path("/{id}/experiencia-profissional")
    public Response adicionarExperienciaProfissional(@PathParam("id") int id, ExperienciaProfissional experienciaProfissional) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        experienciaProfissional.persist();
        titular.addExperienciasProfissionais(experienciaProfissional);
        return Response.ok(titular.getExperienciasProfissionais()).build();
    }

    @POST
    @Transactional
    @Path("/{id}/finalizar-curriculo")
    public Response finalizarCurriculo(@PathParam("id") int id) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        Curriculo curriculo = new Curriculo(titular);
        curriculo.persist();
        return Response.ok(curriculo).build();
    }

    @DELETE
    public void deleteById(@PathParam("id") int id){
        Curriculo.deleteById(id);
    }
}
