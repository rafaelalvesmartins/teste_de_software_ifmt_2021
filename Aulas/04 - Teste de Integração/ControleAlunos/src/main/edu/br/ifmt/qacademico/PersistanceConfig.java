package main.edu.br.ifmt.qacademico;



import java.util.Set;
import java.util.Calendar;
import java.util.HashSet;

import main.edu.br.ifmt.model.entity.Aluno;
import main.edu.br.ifmt.model.entity.Frequencia;
import main.edu.br.ifmt.model.entity.Nota;
import main.edu.br.ifmt.model.service.AlunoService;

public class PersistanceConfig {

//	private static final EntityManagerFactory entity = Persistence.createEntityManagerFactory("qAcademico");
	public static void main(String[] args) {
		inserirDados();
	}
	
	private static void inserirDados() {
//		EntityManager entityManager = entity.createEntityManager();
		
		// Aluno Rafael
		Aluno alunoRafael = new Aluno();
		alunoRafael.setNome("Rafael");
		
		// Frequência
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2021, 9, 29);
		Frequencia frequenciaRafaelDia1 = new Frequencia();
		frequenciaRafaelDia1.setData(calendar);
		frequenciaRafaelDia1.setFalta(true);
		
		calendar.set(2021, 10, 04);
		Frequencia frequenciaRafaelDia2 = new Frequencia();
		frequenciaRafaelDia2.setData(calendar);
		frequenciaRafaelDia2.setFalta(false);
		
		Set<Frequencia> frenquenciasRafael = new HashSet<Frequencia>();
		frenquenciasRafael.add(frequenciaRafaelDia1);
		frenquenciasRafael.add(frequenciaRafaelDia2);
		
		alunoRafael.setFrequencias(frenquenciasRafael);
		
		// Nota
		Nota nota1Rafael = new Nota();
		nota1Rafael.setNota(10);
		Nota nota2Rafael = new Nota();
		nota2Rafael.setNota(4);
		
		Set<Nota> notasRafael = new HashSet<Nota>();
		notasRafael.add(nota1Rafael);
		notasRafael.add(nota2Rafael);
		
		alunoRafael.setNotas(notasRafael);
		
		// Aluno Rodrigo	
		Aluno alunoRodrigo = new Aluno();
		alunoRodrigo.setNome("Rodrigo");
		
		calendar.set(2021, 9, 29);
		Frequencia frequenciaRodrigoDia1 = new Frequencia();
		frequenciaRodrigoDia1.setData(calendar);
		frequenciaRodrigoDia1.setFalta(false);
		
		calendar.set(2021, 10, 04);
		Frequencia frequenciaRodrigoDia2 = new Frequencia();
		frequenciaRodrigoDia2.setData(calendar);
		frequenciaRodrigoDia2.setFalta(true);
		
		Set<Frequencia> frenquenciasRodrigo = new HashSet<Frequencia>();
		frenquenciasRodrigo.add(frequenciaRodrigoDia1);
		frenquenciasRodrigo.add(frequenciaRodrigoDia2);
		
		alunoRodrigo.setFrequencias(frenquenciasRodrigo);
		
		// Nota
		Nota nota1Rodrigo = new Nota();
		nota1Rodrigo.setNota(10);
		Nota nota2Rodrigo = new Nota();
		nota2Rodrigo.setNota(5);
		
		Set<Nota> notasRodrigo = new HashSet<Nota>();
		notasRodrigo.add(nota1Rodrigo);
		notasRodrigo.add(nota2Rodrigo);
		
		alunoRodrigo.setNotas(notasRodrigo);
		
		
		// Envio para o BD
		
		
		AlunoService alunoService = new AlunoService();
		
		
		alunoService.salvar(alunoRafael);
		alunoService.salvar(alunoRodrigo);
		System.out.println(alunoRafael.toString());
		System.out.println(alunoRodrigo.toString());
		
		
		
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//		entityManager.persist(alunoRafael);
//		entityManager.persist(alunoRodrigo);
//		transaction.commit();
		
//		entityManager.close();
	}

}
