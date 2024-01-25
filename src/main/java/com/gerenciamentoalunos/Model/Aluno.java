package com.gerenciamentoalunos.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.gerenciamentoalunos.enums.Curso;
import com.gerenciamentoalunos.enums.Turno;
import com.mongodb.lang.NonNull;

@Document(collection = "alunos")
public class Aluno {
	
	@Id
	@Field
	@NonNull
	private String matricula;
	
	@Field
	@NonNull
	private String nome;
	
	@Field
	@NonNull
	private Curso curso;
	
	@Field
	@NonNull
	private Turno turno;
	
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	public String getNome() {
		return this.nome;
	}
	public Curso getCurso() {
		return this.curso;
	}
	public Turno getTurno() {
		return this.turno;
	}
	
}
