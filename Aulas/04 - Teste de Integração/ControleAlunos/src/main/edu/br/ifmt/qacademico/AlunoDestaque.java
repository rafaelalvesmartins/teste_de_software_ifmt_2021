package main.edu.br.ifmt.qacademico;

import java.util.ArrayList;
import java.util.List;

import main.edu.br.ifmt.model.entity.Aluno;
import main.edu.br.ifmt.model.service.AlunoService;
import main.edu.br.ifmt.model.service.FrequenciaService;
import main.edu.br.ifmt.model.service.NotaService;

public class AlunoDestaque {
	
	
	private double fator;
	private NotaService notaService;
	private FrequenciaService frequenciaService;
	private AlunoService alunoService;
	
	
	public boolean alunoEhDestaque(Aluno aluno) {
		double mediaNotaTurma = notaService.retornaMediaNotas();
		double mediaFrequenciaTurma = frequenciaService.retornaMediaFrequencia();
				
		double notaRef = fator*mediaNotaTurma;
		double freqRef = fator *mediaFrequenciaTurma;
		
		if (aluno.calculaMediaNota() >= notaRef && aluno.calculaMediaFrequencia() >= freqRef)
			return true;
		
		return false;
	}
		
	public List<Aluno> retornaAlunosDestaques(){
		
		
		List<Aluno> todosAlunos = alunoService.retornaTodosAlunos();
		List<Aluno> todosAlunosDestaques = new ArrayList<Aluno>();
		boolean ehDestaque;
		for(Aluno aluno:todosAlunos) {
			ehDestaque = alunoEhDestaque(aluno);
			if(ehDestaque)
				todosAlunosDestaques.add(aluno);
		}
		return todosAlunosDestaques;
		
	}
	

	public AlunoDestaque() {
		super();
	}






	public double getFator() {
		return fator;
	}




	public void setFator(double fator) {
		this.fator = fator;
	}




	public NotaService getNotaService() {
		return notaService;
	}




	public void setNotaService(NotaService notaService) {
		this.notaService = notaService;
	}




	public FrequenciaService getFrequenciaService() {
		return frequenciaService;
	}




	public void setFrequenciaService(FrequenciaService frequenciaService) {
		this.frequenciaService = frequenciaService;
	}

	public AlunoService getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	


	




	
	
	 
	

}
