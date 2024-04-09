package Corps ;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connexion  {
	
	
	static Connection con;
	PreparedStatement psd;
	ResultSet rs;
	Statement smt;
	 public static void Connect() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            try {
					con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Original", "postgres", "nomenjanahary");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            if (con != null) {
	                System.out.println("Connecté ");
	            } else {
	                System.out.println("Non connecté");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	    }
	
	
	public static void main(String[] args) {
        
		Connect();
    }

	
	
}