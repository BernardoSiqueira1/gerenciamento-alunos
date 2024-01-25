package com.gerenciamentoalunos.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gerenciamentoalunos.Model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno,String>{
	public void deleteBymatricula(String matricula);
	public Aluno findBymatricula(String matricula);
	public List<Aluno> findBynomeLike(String nome);
}
