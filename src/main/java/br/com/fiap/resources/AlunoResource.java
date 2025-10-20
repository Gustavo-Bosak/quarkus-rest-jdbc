package br.com.fiap.resources;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entities.Aluno;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {
    AlunoBO bo = new AlunoBO();

    @GET
    public Response getAll () {
        ArrayList<Aluno> alunos = bo.getAll();
        return Response.ok(alunos).build();
    }

    @GET
    @Path("/{rm}")
    public Response getById (String rm) {
        Aluno aluno = bo.getById(rm);
        return Response.ok(aluno).build();
    }

    @POST
    public Response post (Aluno aluno, @Context UriInfo uriInfo) {
        bo.post(aluno);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(aluno.getRm());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{rm}")
    public Response put (Aluno aluno, @Context UriInfo uriInfo) {
        bo.put(aluno);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(aluno.getRm());
        return Response.created(builder.build()).build();
    }

    @DELETE
    public Response delete (String rm) {
        bo.delete(rm);
        return Response.ok().build();
    }
}
