package test.edu.br.ifmt.qacademico;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import main.edu.br.ifmt.model.entity.*;
import main.edu.br.ifmt.model.service.AlunoService;
import main.edu.br.ifmt.model.service.FrequenciaService;
import main.edu.br.ifmt.model.service.NotaService;
import main.edu.br.ifmt.qacademico.AlunoDestaque;

public class AlunoDestaqueTest {

	private Aluno alunoRafael, alunoRodrigo;
	double fator;
	
	@Before
	public void antesCadaChamdas() {
		
		fator = 1.2;
		
		// Aluno Rafael
		alunoRafael = new Aluno();
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
		nota2Rafael.setNota(5);
		
		Set<Nota> notasRafael = new HashSet<Nota>();
		notasRafael.add(nota1Rafael);
		notasRafael.add(nota2Rafael);
		
		alunoRafael.setNotas(notasRafael); // Nota 7.5, frequencia 50, Limite media turma nota turma igual inferior 6.25 e frequencia turma menor igual 41.667
				
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
		
	}
	
	/*
	@Test
	public void testeUnitario() {
		
				
		AlunoDestaque alunoDestaque =  new AlunoDestaque();
		
		
		
		// Caso 1
		
		double mediaFrequenciaTurma = 42;
		double mediaNotaTurma = 6.30;
		
		alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setMediaFrequenciaTurma(mediaFrequenciaTurma);
		alunoDestaque.setMediaNotaTurma(mediaNotaTurma);
				
		
		assertFalse(alunoDestaque.alunoEhDestaque());
		
		
	    // Caso 2
		
		mediaFrequenciaTurma = 41;
		mediaNotaTurma = 6.30;
		alunoDestaque.setMediaFrequenciaTurma(mediaFrequenciaTurma);
		alunoDestaque.setMediaNotaTurma(mediaNotaTurma);
				
		
		assertFalse(alunoDestaque.alunoEhDestaque());
		
		
		// Caso 3
		
		mediaFrequenciaTurma = 42;
		mediaNotaTurma = 6.2;
		alunoDestaque.setMediaFrequenciaTurma(mediaFrequenciaTurma);
		alunoDestaque.setMediaNotaTurma(mediaNotaTurma);
				
		
		assertFalse(alunoDestaque.alunoEhDestaque());
		
		// Caso 4
		
		mediaFrequenciaTurma = 41;
		mediaNotaTurma = 6.2;
		alunoDestaque.setMediaFrequenciaTurma(mediaFrequenciaTurma);
		alunoDestaque.setMediaNotaTurma(mediaNotaTurma);
				
		
		assertTrue(alunoDestaque.alunoEhDestaque());
		
	}*/
	
	
	@Test
	public void testeUnidadeMockado() {
		
		
		AlunoDestaque alunoDestaque =  new AlunoDestaque();
		
		
		
		// Caso 1
		
		FrequenciaService frequenciaService = mock(FrequenciaService.class);
		when(frequenciaService.retornaMediaFrequencia()).thenReturn(42D);
		
		NotaService notaService = mock(NotaService.class);
		when(notaService.retornaMediaNotas()).thenReturn(6.30D);
		//doNothing().when(notaService).retornaMediaNotas(); // Caso não tenha retorno a condição when é diferente
		
		
		//alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
				
		
		assertFalse(alunoDestaque.alunoEhDestaque(alunoRafael));
		
		
	    // Caso 2
		when(frequenciaService.retornaMediaFrequencia()).thenReturn(41D);
		when(notaService.retornaMediaNotas()).thenReturn(6.30D);
		
		
		//alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
				
				
		
		assertFalse(alunoDestaque.alunoEhDestaque(alunoRafael));
		
		
		// Caso 3
		
		when(frequenciaService.retornaMediaFrequencia()).thenReturn(42D);
		when(notaService.retornaMediaNotas()).thenReturn(6.2D);
		
		
		//alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
				
				
		
		assertFalse(alunoDestaque.alunoEhDestaque(alunoRafael));
		
		
		
		// Caso 4
		when(frequenciaService.retornaMediaFrequencia()).thenReturn(41D);
		when(notaService.retornaMediaNotas()).thenReturn(6.2D);
		
		
		//alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
				
		
		
		assertTrue(alunoDestaque.alunoEhDestaque(alunoRafael));
		
		verify(frequenciaService,times(4)).retornaMediaFrequencia();
		verify(notaService,times(4)).retornaMediaNotas();
		
	}
	
	
	@Test
	public void testeIntegracao() {
		
		AlunoService alunoService = new AlunoService();
		FrequenciaService frequenciaService = new FrequenciaService();
		NotaService notaService = new NotaService();
		
			
		Aluno alunoRafael = alunoService.retornaAlunoId(1); // Nota 7, Frequencia 50
		
		
		
//		double mediaNotaTurma = notaService.retornaMediaNotas(); // Nota 7,25
//		double mediaFrequenciaTurma = frequenciaService.retornaMediaFrequencia(); // Frequencia 50
		
		AlunoDestaque alunoDestaque =  new AlunoDestaque();
		//alunoDestaque.setAluno(alunoRafael);
		alunoDestaque.setFator(fator);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
		
		
		 // Nota menor que a média
				
		
		assertFalse(alunoDestaque.alunoEhDestaque(alunoRafael));
	}

	
	@Test
	public void testeUnitarioListarTodosAlunosDestaques() {
		
		
		FrequenciaService frequenciaService = mock(FrequenciaService.class);
		when(frequenciaService.retornaMediaFrequencia()).thenReturn(42D);
		
		NotaService notaService = mock(NotaService.class);
		when(notaService.retornaMediaNotas()).thenReturn(6.30D);
		
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		listaAlunos.add(alunoRafael); // Não eh Destaque
		listaAlunos.add(alunoRodrigo); // Não eh Destaque
		//listaAlunos.add(alunoRafael);
		
		AlunoService alunoService = mock(AlunoService.class);
		when(alunoService.retornaTodosAlunos()).thenReturn(listaAlunos);
		
		AlunoDestaque alunoDestaque = new AlunoDestaque();
		alunoDestaque.setAlunoService(alunoService);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
		
		List<Aluno> alunosDestaques = alunoDestaque.retornaAlunosDestaques();
		
		assertEquals(0, alunosDestaques.size());
		
	}
	
	
	@Test
	public void testeIntegracaoListarTodosAlunosDestaques() {
		
		
		FrequenciaService frequenciaService = new FrequenciaService();
		NotaService notaService = new NotaService();
		AlunoService alunoService = new AlunoService();
		
		
		AlunoDestaque alunoDestaque = new AlunoDestaque();
		alunoDestaque.setAlunoService(alunoService);
		alunoDestaque.setFrequenciaService(frequenciaService);
		alunoDestaque.setNotaService(notaService);
		
		List<Aluno> alunosDestaques = alunoDestaque.retornaAlunosDestaques();
		
		assertEquals(0, alunosDestaques.size());
		
	}
}
