package main.edu.br.ifmt.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Frequencia {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar data;
	@Column(nullable = false)
	private boolean falta;
	@ManyToOne
    private Aluno aluno;

	
	public Frequencia() {
		super();
	}

	public Frequencia(int id, Calendar data, boolean falta, Aluno aluno) {
		super();
		this.id = id;
		this.data = data;
		this.falta = falta;
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public boolean getFalta() {
		return falta;
	}

	public void setFalta(boolean falta) {
		this.falta = falta;
	}

	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
	

	

}
