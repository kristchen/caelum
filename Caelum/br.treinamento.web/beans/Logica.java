package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	String executa(HttpServletResponse response, HttpServletRequest request)   throws Exception ;

}
