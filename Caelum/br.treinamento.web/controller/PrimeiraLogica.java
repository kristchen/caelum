package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Logica;

public class PrimeiraLogica  implements Logica{

	@Override
	public String executa(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		return "primeira-logica.jsp";
	}

	
	
}
