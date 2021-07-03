package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Palavra;

public class palavraDAO {

	public static boolean insert(Palavra word, Connection conn) {
		try {
			
			String sql = "insert into palavra (palavraPortugues, palavraIngles, palavraEspanhol) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, word.getPortugues());
			ps.setString(2, word.getIngles());
			ps.setString(3, word.getEspanhol());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean altera(Palavra word, Connection conn) {
		
		try {
			
			String sql = "update palavra set palavraPortugues=?, palavraIngles=?, palavraEspanhol=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, word.getPortugues());
			ps.setString(2, word.getIngles());
			ps.setString(3, word.getEspanhol());
			ps.setInt(4, word.getId());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleta(Palavra word, Connection conn) {
		
		try {
			
			String sql = "delete from palavra where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, word.getId());
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<Palavra> listAll(Connection conn){
		
		String sql = "select * from palavra order by id";
		
		return listaPalavras(conn, sql);
	}
	
	public static ArrayList<Palavra> searchByID(Connection conn, int id){
		
		String sql = "select * from palavra where id = "+id;
		
		return listaPalavras(conn, sql);
	}
	
	public static ArrayList<Palavra> searchByPortuguese(Connection conn, String filter){
		
		String sql = "select * from palavra where palavraPortugues like '"+filter+"%' order by id";
		
		return listaPalavras(conn, sql);
		
	}
	
	public static ArrayList<Palavra> searchByEnglish(Connection conn, String filter){
		
		String sql = "select * from palavra where palavraIngles like '"+filter+"%' order by id";
		
		return listaPalavras(conn, sql);
		
	}

	public static ArrayList<Palavra> searchBySpanish(Connection conn, String filter){
	
	String sql = "select * from palavra where palavraEspanhol like '"+filter+"%' order by id";
	
	return listaPalavras(conn, sql);
	
	}
	
	public static ArrayList<Palavra> listaArquivo(Connection conn){
		String sql = "select * from palavra order by palavraPortugues";
		
		return listaPalavras(conn, sql);
	}
	
	public static ArrayList<Palavra> listaPalavras(Connection conn, String sql){
		
		ArrayList<Palavra> list = new ArrayList<>();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet results = ps.executeQuery();
			
			while(results.next()) {
				
				Palavra word = new Palavra(results.getInt("id"), results.getString("palavraPortugues"), results.getString("palavraIngles"), results.getString("palavraEspanhol")); //chama construtor
				list.add(word);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
