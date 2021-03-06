package main.edu.br.ifmt.model.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="aluno_id")
    private Set<Frequencia> frequencias;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="aluno_id")
    private Set<Nota> notas;
	
	
	
	public Aluno() {
		super();
	}

	public Aluno(int id, String nome, Set<Frequencia> frequencias, Set<Nota> notas) {
		super();
		this.id = id;
		this.nome = nome;
		this.frequencias = frequencias;
		this.notas = notas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(Set<Frequencia> frenquencias) {
		this.frequencias = frenquencias;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	public double calculaMediaNota() {
		double soma = 0D;
		for (Nota nota : notas) {
			soma += nota.getNota();
		}
		double media = soma / notas.size();
		return media;
	}
	
	
	public double calculaMediaFrequencia() {
		double soma = 0;
		for (Frequencia frequencia : frequencias) {
			if(!frequencia.getFalta())
				soma += 1;
		}
		double media = (soma / frequencias.size())*100;
		return media;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", calculaMediaNota()=" + calculaMediaNota()
				+ ", calculaMediaFrequencia()=" + calculaMediaFrequencia() + "]";
	}
	
	
	
	
	

	
}
