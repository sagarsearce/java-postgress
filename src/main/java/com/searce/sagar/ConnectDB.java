package com.searce.sagar;
import java.sql.*;

public class ConnectDB {
	
	static void createDatabase(Connection dbClient,String dbName) {
		
	}
	
	static void deleteRow(Connection conn) {
		String name = "sagar";
		PreparedStatement st;
		try {
			st = conn.prepareStatement("DELETE FROM hb_test.test WHERE name = ?");
			st.setString(1,name);
			int rowsDeleted = st.executeUpdate();
			System.out.println(rowsDeleted + " rows deleted");
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertRow(Connection conn) {
		String name = "sagar";
		int age = 35;
		String addr = "some address";
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO hb_test.test(name, address, age) VALUES(?, ?, ?)");
			st.setString(1,name);
			st.setString(2,addr);
			st.setInt(3, age);			
			int rowsAdded = st.executeUpdate();
			System.out.println(rowsAdded + " rows inserted");
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void getRow(Connection conn) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM hb_test.test");
			while (rs.next())
			{
			    System.out.print("Name: " + rs.getString(1) + " Address: "+ 
			    		rs.getString(2) + " Age: " + rs.getInt(3)+ "\n" );
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void run(Connection conn,String command,String dbName) {
		
		    switch (command) {
		      case "createdatabase":
		        createDatabase(conn,dbName);
		        break;
		      case "deleteRow":
		    	deleteRow(conn);
		    	 break;
		      case "insertRow":
		    	insertRow(conn);
		    	 break;
		      case "getRow":
		    	getRow(conn);
		    	 break;
		    }
	}

	public static void main(String[] args) {
		// [START init client]
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hb_test","postgres","9081606040");
			run(conn,"insertRow","test");
		}
		catch (Exception e){
			System.out.print(e);
		}
		// [END init client]
		
	}

}
