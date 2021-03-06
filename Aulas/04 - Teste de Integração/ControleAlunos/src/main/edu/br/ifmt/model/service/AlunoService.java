package main.edu.br.ifmt.model.service;

import java.util.List;


import main.edu.br.ifmt.model.dao.AlunoDAO;
import main.edu.br.ifmt.model.entity.*;

public class AlunoService {
	private AlunoDAO dao;
	
	public AlunoService() {
		this.dao = AlunoDAO.getInstance();
	}
	
			
	public Aluno retornaAlunoId(int id) {
		return dao.getById(id);
	}
	
	public void salvar(Aluno aluno) {
		dao.persist(aluno);
	}
	
	public List<Aluno> retornaTodosAlunos(){
		return dao.findAll();
	}
	
	public void removerAluno(Aluno aluno){
		dao.remove(aluno);
	}
}
