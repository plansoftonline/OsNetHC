package com.plansoftonline.negocio;

import java.sql.SQLException;

import com.plansoftonline.beans.Sla;
import com.plansoftonline.dao.SlaDao;
import com.plansoftonline.exception.ValidationException;
import com.plansoftonline.validator.DataValidador;
import com.plansoftonline.validator.Ivalidator;


public class RNSla {

	private SlaDao controle;
	private String msgErro;
	
	public RNSla() {
		
	}

	public void inserirSla(Sla sla) {
		controle = new SlaDao();
		try {
			controle.Inserir(sla);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarSla(Sla sla) {
		controle = new SlaDao();
		try {
			controle.alterar(sla);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirSla(Integer codigo) {
		controle = new SlaDao();
		try {
			controle.excluir(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public SlaDao getControle() {
		return controle;
	}

	public void setControle(SlaDao controle) {
		this.controle = controle;
	}
	
	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	
	public String ValidaCamposObg(String nome, String tempo, String data) {
		 this.msgErro = "";
		
		if (nome == "" || nome == null) {
		 	this.msgErro += "Campo nome Obrigatório<Br/>" ;
		}
		if  (tempo.equals("0") || tempo == null) {
			this.msgErro += "Campo tempo Obrigatório<Br/>";
		}
		
		Ivalidator validador = new DataValidador();
		try {
			if (validador.validar(data) != true) {
				this.msgErro += "Campo data Inválida<Br/>";
			}
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.msgErro += e.getMessage();
		}
		return getMsgErro();
	}

}
