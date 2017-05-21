package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	
	public Esame find(String codice){
		
		String sql = "select codice, titolo, docente, superato, voto, data_superamento "
				+ "from esame where codice = ?";
		
		String jdbcURL = "jdbc:mysql://localhost/Libretto?user=root&password=";
		Esame result = null;
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codice);
			
			ResultSet res = st.executeQuery();
			
			if(res.next()){
				
				Esame ex = new Esame(
						res.getString("codice"),
						res.getString("titolo"),
						res.getString("docente")
						);
				// TODO: estrarre anche voto e data_superamento
				
				result = ex; //
				
			}else{
				return result; // TODO
			}
			
			conn.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean create(Esame e){
		
		String sql = "INSERT INTO 'Libretto'.'esame' ('codice', 'titolo', 'docente') values (?,?,?)";
		
		String jdbcURL = "jdbc:mysql://localhost/Libretto?user=root&password=";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, e.getCodice());
			st.setString(2, e.getTitolo());
			st.setString(3, e.getDocente());
			
			int result = st.executeUpdate();
			
			conn.close();
			if(result == 1){
				return true;
			}else{
				return false;
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
}
