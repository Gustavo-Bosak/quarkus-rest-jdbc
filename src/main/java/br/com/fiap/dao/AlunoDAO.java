package br.com.fiap.dao;

import br.com.fiap.connections.ConnectionFactory;
import br.com.fiap.entities.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {
    private final Connection conn;

    public AlunoDAO () {
        this.conn = new ConnectionFactory().getConnection();
    }

    public ArrayList<Aluno> getAllAluno () {
        try {
            ArrayList<Aluno> alunos = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM j_alunos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4)
                );

                alunos.add(aluno);
            }

            stmt.close();
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar na tabela", e);
        }
    }

    public Aluno getByIdAluno (String rm) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM j_alunos WHERE rm=?");
            stmt.setString(1, rm);
            ResultSet rs = stmt.executeQuery();

            Aluno aluno = null;

            if (rs.next()) {
                aluno = new Aluno(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4)
                );
            }

            stmt.close();
            return aluno;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar esse aluno na tabela", e);
        }
    }

    public void postAluno (Aluno aluno) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO j_alunos VALUES (?,?,?,?)");
            stmt.setString(1, aluno.getRm());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getTurma());
            stmt.setDouble(4, aluno.getNota());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir na tabela", e);
        }
    }

    public void putAluno (Aluno aluno) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE j_alunos SET nome=?, turma=?, nota=? WHERE rm=?");
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTurma());
            stmt.setDouble(3, aluno.getNota());
            stmt.setString(4, aluno.getRm());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar na tabela", e);
        }
    }

    public void deleteAluno (String rm) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM j_alunos WHERE rm=?");
            stmt.setString(1, rm);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover na tabela", e);
        }
    }

}
