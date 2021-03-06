package test.edu.br.ifmt.entity;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import main.edu.br.ifmt.model.entity.Aluno;
import main.edu.br.ifmt.model.entity.Frequencia;
import main.edu.br.ifmt.model.entity.Nota;

public class AlunoTest {

	Aluno alunoRafael;
	
	@Before
	public void antesDeCadaTeste() {
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
		nota2Rafael.setNota(4);
		
		Set<Nota> notasRafael = new HashSet<Nota>();
		notasRafael.add(nota1Rafael);
		notasRafael.add(nota2Rafael);
		
		alunoRafael.setNotas(notasRafael);
	}
	
	
	
	@Test
	public void testarMediaNotaAluno() {
		assertEquals(7d, alunoRafael.calculaMediaNota(),0.0001);
	}
	
	@Test
	public void testarFrequenciaAluno() {
		assertEquals(50d, alunoRafael.calculaMediaFrequencia(),0.0001);
	}

}
