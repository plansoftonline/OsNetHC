package com.plansoftonline.servlet;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.export.DataExporter;

import com.plansoftonline.beans.Sla;
import com.plansoftonline.dao.SlaDao;
import com.plansoftonline.exception.ValidationException;
import com.plansoftonline.negocio.RNSla;
import com.plansoftonline.validator.DataValidador;
import com.plansoftonline.validator.Ivalidator;

/**
 * Servlet implementation class ServletCadProd
 */
@WebServlet("/ServletCadSla")
public class ServletCadSla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletCadSla() {
	   // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wcodigo    = request.getParameter("txtCodigo");
		String wDescricao = request.getParameter("txtDescricao");
		String wdata      = request.getParameter("txtData");
		int wtempo = 0;
		if (request.getParameter("txtTempo") != "") { 
			wtempo = Integer.parseInt(request.getParameter("txtTempo"));
		}

		try {
			
			RNSla rnSla = new RNSla();
			if ( !wcodigo.isEmpty() ) {
				Sla sla = new Sla();
				sla.setCodigo(Integer.parseInt(wcodigo));
				sla.setDescricao(wDescricao);
				sla.setTempo(wtempo);

				rnSla.alterarSla(sla);
				
				List<Sla> lista = new ArrayList<Sla>();
				
				SlaDao dao = new SlaDao();
				
				lista = dao.listar(Integer.parseInt(wcodigo), "");
				
				request.setAttribute("lista", lista);
				
				RequestDispatcher dp = request.getRequestDispatcher("listarSla.jsp");
				dp.forward(request, response);
				
			} 
			
			if (wcodigo.isEmpty()) {
				
                String msg = rnSla.ValidaCamposObg(wDescricao, Integer.toString(wtempo), wdata);
                   
				if (msg == null || msg == "") {
					Sla sla2 = new Sla();
					sla2.setCodigo(0);
					sla2.setDescricao(wDescricao);
					sla2.setTempo(wtempo);
					
				    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
				    java.sql.Date data = new java.sql.Date(format.parse(wdata).getTime());  				
					sla2.setCriado_em(data);
					
					rnSla.inserirSla(sla2);
		    		List<Sla> lista = new ArrayList<Sla>();
				    SlaDao dao = new SlaDao();
	    			lista = dao.listar(dao.RetornaUltimoId(), "");
	    			request.setAttribute("lista", lista);
		    		RequestDispatcher dp = request.getRequestDispatcher("listarSla.jsp");
			    	dp.forward(request, response);
				} else {
					request.setAttribute("msgErro", rnSla.getMsgErro());
		    		RequestDispatcher dp = request.getRequestDispatcher("cadastroSla.jsp");
			    	dp.forward(request, response);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}


}
