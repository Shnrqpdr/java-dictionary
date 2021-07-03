package utilitaries;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conecta {
	
	public static Connection connectWithSQLite() {
		
		Connection conn = null;
		
		try {
			
			File db = new File("database/database_avaliacao.sqlite");
			if(db.exists()) {
				
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:database/database_avaliacao.sqlite");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
