package com.plansoftonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.plansoftonline.beans.Sla;
import com.plansoftonline.util.ConexaoUtil;

public class SlaDao {
	
private Connection conection;
    
    public SlaDao() {
    	
    }
    
    public List<Sla> listar(Integer codigo, String Descricao) {
		List<Sla> slas = null;
	
		try {
			slas = new ArrayList<Sla>();
			conection = ConexaoUtil.getInstance().getConection();
			String sql = "Select * from Sla where (codigo > 0) ";
			if (codigo > 0) 
				sql = sql + " and (codigo = " + codigo +")";
			
			if (!Descricao.isEmpty() ) { 
				Descricao = Descricao + "%";
				sql = sql + " and (descricao like '" + Descricao + "')";
						
			}

			PreparedStatement statement = conection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			//	System.out.println(resultSet.getInt("codigo") + " - " + resultSet.getString("Descricao") + " Tempo:" +  resultSet.getInt("tempo"));
				slas.add(populaProduto(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slas;
	}
    
    
    private Sla populaProduto(ResultSet rs) throws SQLException {
    	Sla sla = new Sla(rs.getInt("codigo"),rs.getString("descricao"), rs.getInt("tempo"), rs.getDate("criado_em"));
    	return sla;
    }        
    
    
    public void Inserir(Sla sla) throws SQLException {
    	try {
    		conection = ConexaoUtil.getInstance().getConection();
    		String sql = "insert into sla (descricao, tempo, criado_em) " +
    		             "values (?,?,?)";
    		PreparedStatement st = conection.prepareStatement(sql);
    		st.setString(1, sla.getDescricao());
    		st.setInt(2, sla.getTempo());
    		st.setDate(3, (java.sql.Date) sla.getCriado_em());
    		st.execute();
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conection.close();
		}
    }
    
    public void alterar(Sla sla) throws SQLException {
    	try {
    		conection = ConexaoUtil.getInstance().getConection();
    		String sql = "update sla set descricao = ?, tempo = ? " +
    		             "where (codigo = " + sla.getCodigo() + ")";
    		PreparedStatement st = conection.prepareStatement(sql);
    		st.setString(1, sla.getDescricao());
    		st.setInt(2, sla.getTempo());
    		st.execute();
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conection.close();
		}
    }
    
    public void excluir(Integer codigo) throws SQLException {
    	try {
    		conection = ConexaoUtil.getInstance().getConection();
    		String sql = "delete from sla where codigo = " + codigo; 
    		PreparedStatement st = conection.prepareStatement(sql);
    		st.execute();
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conection.close();
		}
    }
    
    public Integer RetornaUltimoId() {
		Integer id = 0;
		try {
			conection = ConexaoUtil.getInstance().getConection();
			String sql = "Select max(codigo) id from sla";

			PreparedStatement statement = conection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				id = resultSet.getInt("id") ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
    
		

}
