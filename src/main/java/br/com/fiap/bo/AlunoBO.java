package br.com.fiap.bo;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entities.Aluno;

import java.util.ArrayList;

public class AlunoBO {
    private final AlunoDAO dao;

    public AlunoBO () {
        this.dao = new AlunoDAO();
    }

    public ArrayList<Aluno> getAll () {
        return dao.getAllAluno();
    }

    public Aluno getById (String rm) {
        return dao.getByIdAluno(rm);
    }

    public void post (Aluno aluno) {
        // Regras de negócio
        Aluno alunoEncontrado = getById(aluno.getRm());
        if (alunoEncontrado != null) {
            throw new RuntimeException("Rm já pertence a um aluno");
        }

        dao.postAluno(aluno);
    }

    public void put (Aluno aluno) {
        // Regras de negócio
        Aluno alunoEncontrado = getById(aluno.getRm());
        if (alunoEncontrado == null) {
            throw new RuntimeException("Rm não pertence a nenhum aluno");
        }

        dao.putAluno(aluno);
    }

    public void delete (String rm) {
        // Regras de negócio
        Aluno alunoEncontrado = getById(rm);
        if (alunoEncontrado == null) {
            throw new RuntimeException("Rm não pertence a nenhum aluno");
        }

        dao.deleteAluno(rm);
    }
}
