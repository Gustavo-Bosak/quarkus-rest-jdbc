package br.com.fiap.entities;

public class Aluno {
    private String rm;
    private String nome;
    private String turma;
    private double nota;

    public Aluno() {
    }

    public Aluno(String rm, String nome, String turma, double nota) {
        this.rm = rm;
        this.nome = nome;
        this.turma = turma;
        this.nota = nota;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return (
            "\nRM: " + rm +
            "\nNome: " + nome +
            "\nTurma: " + turma +
            "\nNota: " + nota
        );
    }
}
