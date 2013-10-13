package com.medfinder.teste;

import com.medfinder.bo.EspecialidadeBO;
import com.medfinder.to.Especialidade;


public class Teste1 {
	public static void main(String[] args) {
		
		int id = 9;
		
		EspecialidadeBO ebo = new EspecialidadeBO();
		
		Especialidade e = ebo.consultarEspecialidade(id);
		
		System.out.println(e.getNm_especialidade());
		
		Especialidade[] esps = new Especialidade[]{};
		
		esps = ebo.listarEspecialidades();
		
		for (Especialidade espec : esps) {
			System.out.println(espec.getNm_especialidade());
		}
		
		
		
	}

}
