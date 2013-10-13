package com.medfinder.bo;

import java.util.List;

import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.to.Especialidade;

public class EspecialidadeBO {
	
	
	EspecialidadeDAO es = new EspecialidadeDAO();

	public Especialidade consultarEspecialidade(int id) {
		Especialidade e = es.find(id);

		return e;
	}

	public void inserirEspecialidade(Especialidade especialidade) {
		es.insert(especialidade);
	}

	public Especialidade[] listarEspecialidades() {
		List<Especialidade> Especialidades = es.listAll();

		Especialidade[] array = new Especialidade[Especialidades.size()];

		Especialidades.toArray(array);

		return array;
	}

	public void deletarEspecialidade(int id) {
		es.removeById(id);
	}
}
