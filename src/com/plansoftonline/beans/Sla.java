package com.plansoftonline.beans;

import java.util.Date;

public class Sla {

	private int codigo;
	private String descricao;
	private int tempo;
	private Date criado_em;
	
    public Sla (int codigo, String descricao, int tempo, Date criado_em ) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    	this.tempo = tempo;
    	this.criado_em = criado_em;
    }

    public Sla ( ) {
    	
    }

    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Date getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}
	
	

}