package br.com.fiap.model.bo;

import br.com.fiap.model.dao.AlunoDAO;
import br.com.fiap.model.entities.Aluno;

import java.util.ArrayList;

public class AlunoBO {
    private final AlunoDAO dao;

    public AlunoBO () {
        this.dao = new AlunoDAO();
    }

    public ArrayList<Aluno> getBO () {
        // BO

        return dao.getAluno();
    }

    public void postBO (Aluno aluno) {
        // BO

        dao.postAluno(aluno);
    }

    public void putBO (Aluno aluno) {
        // BO

        dao.putAluno(aluno);
    }

    public void deleteBO (String rm) {
        // BO

        dao.deleteAluno(rm);
    }
}
