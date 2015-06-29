package com.plansoftonline.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.plansoftonline.dao.SlaDao;
import com.plansoftonline.negocio.RNSla;

@WebServlet("/excluiSla")
public class ServExluiSla extends HttpServlet {
	
	private static final long serialVersionUID = 4304681615020934134L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String wcodigo = request.getParameter("id");
		
		try {
			RNSla rnProd = new RNSla();
			rnProd.excluirSla(Integer.parseInt(wcodigo));
			
			RequestDispatcher dp = request.getRequestDispatcher("listarSla.jsp");
			dp.forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
