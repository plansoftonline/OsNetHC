package com.plansoftonline.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/altSla")
public class ServlevAltSla extends HttpServlet {

	private static final long serialVersionUID = 4121580313710680031L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispacher = request.getRequestDispatcher("cadastroSla.jsp");
		String codigo = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		String tempo = request.getParameter("tempo");
		String data = request.getParameter("data");
		
		request.setAttribute("txtCodigo", codigo);
		request.setAttribute("txtDescricao", descricao);
		request.setAttribute("txtTempo", tempo);
		request.setAttribute("txtData", data);
		
		dispacher.forward(request, response);
		
	}
	
	
	
	
	

}
