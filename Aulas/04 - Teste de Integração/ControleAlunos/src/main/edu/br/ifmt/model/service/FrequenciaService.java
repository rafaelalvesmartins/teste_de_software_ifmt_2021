package main.edu.br.ifmt.model.service;

import java.util.List;
import main.edu.br.ifmt.model.dao.FrequenciaDAO;
import main.edu.br.ifmt.model.entity.*;

public class FrequenciaService {
	private FrequenciaDAO dao;
	
	public FrequenciaService() {
		this.dao = FrequenciaDAO.getInstance();
	}
		
	public Frequencia retornaFrequenciaId(int id) {
		return dao.getById(id);
	}
	
	public void salvar(Frequencia frequencia) {
		dao.persist(frequencia);
	}
	
	public double retornaMediaFrequencia() {
		List<Frequencia>  todasFrequencias =  dao.findAll();
		if (todasFrequencias.size() > 0 ) {
			double soma = 0;
			for(Frequencia frequencia : todasFrequencias) {
				if(!frequencia.getFalta())
					soma +=1;
			}
			double media = (soma / todasFrequencias.size())*100;
			return media;
		}
		return 0;
	}
}
