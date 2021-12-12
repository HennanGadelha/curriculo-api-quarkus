package org.acme.curriculo.controller;

import io.smallrye.mutiny.Uni;
import org.acme.curriculo.Curriculo;
import org.acme.curriculo.ExperienciaProfissional;
import org.acme.curriculo.FormacaoAcademica;
import org.acme.curriculo.TitularCurriculo;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Response create(TitularCurriculo titularCurriculo) {
       titularCurriculo.persist();
       return Response.ok(titularCurriculo).build();
    }

    @POST
    @Transactional
    public Response adicionarFormacaoAcademica(int id, FormacaoAcademica formacaoAcademica) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        formacaoAcademica.persist();
        titular.addFormacoesAcademicas(formacaoAcademica);

        return Response.ok(titular).build();
    }

    @POST
    @Transactional
    public Response adicionarExperienciaProfissional(int id, ExperienciaProfissional experienciaProfissional) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        experienciaProfissional.persist();
        titular.addExperienciasProfissionais(experienciaProfissional);
        return Response.ok(titular).build();
    }

    @POST
    @Transactional
    public Response finalizarCurriculo(int id) {
        TitularCurriculo titular = (TitularCurriculo) TitularCurriculo.findById(id);
        Curriculo curriculo = new Curriculo(titular);
        curriculo.persist();
        return Response.ok(titular).build();
    }

    @DELETE
    public void deleteById(int id){
        TitularCurriculo.deleteById(id);
    }
}
