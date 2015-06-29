package com.plansoftonline.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plansoftonline.beans.Sla;
import com.plansoftonline.dao.SlaDao;


@WebServlet("/consultaSla")
public class ServConsultaSla extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4245090031205159289L;

	public ServConsultaSla() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String codigo   = request.getParameter("txtCodigo");
		String descricao = request.getParameter("txtDescricao");
		
		Integer wCodigo = 0;
		if (!codigo.isEmpty()) {
			wCodigo = Integer.parseInt(codigo); 
		}
		
		String wdescricao = "";
		if (!descricao.isEmpty()) {
			wdescricao = descricao; 
		}


		List<Sla> lista = new ArrayList<Sla>();
		
		SlaDao dao = new SlaDao();
		
		lista = dao.listar(wCodigo, wdescricao);
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher dp = request.getRequestDispatcher("listarSla.jsp");
		dp.forward(request, response);
		
		
		
		
		
		
	}

}
