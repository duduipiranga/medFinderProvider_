package com.medfinder.teste;

import com.medfinder.bo.OperadoraBO;
import com.medfinder.to.Operadora;

public class Teste2 {

	
	public static void main(String[] args) {
		int id = 12;
		
		OperadoraBO ob = new OperadoraBO();
		
		Operadora o = ob.consultarOperadora(id);
		
		System.out.println(o.getDs_operadora());
		
		

	}

}
