package com.medfinder.bo;

import java.util.List;

import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.to.Operadora;

public class OperadoraBO {
	
	OperadoraDAO op = new OperadoraDAO();
	
	public Operadora consultarOperadora(int id){
		Operadora o = op.find(id);
		
		return o;
	}
	
	public void inserirOperadora(Operadora operadora){
		op.insert(operadora);
	}
	
	public Operadora[] listarOperadoras(){
		List<Operadora> operadoras = op.listAll();
		
		Operadora[] array = new Operadora[operadoras.size()];
		
		operadoras.toArray(array);
		
		return array;
	}
	
	public void deletarOperadora(int id){
		op.removeById(id);
	}

}
