package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import beans.OF;

public class OFDao {
public int addOF(OF of)
{
	
	Connection cn = connexion.Singleton.getInstance(); 
	int result = 0 ; 
	try {
		cn.createStatement();
		Statement st = cn.createStatement() ;
		String req = "INSERT INTO `of`(`idClient`, `refArt`, `codeIlot`, `dateOF`, `QteM`, `QteL`, `QteXL`, `PUProp`, `PURéel`)"
				+ " VALUES ("
						+ "'"+of.getIdClient()+"',"
						+"'"+of.getRefArt()+"',"
						+"'"+of.getCodeIlot()+"',"
						+"'"+of.getDateOF()+"',"
						+"'"+of.getQteM()+"',"
						+"'"+of.getQteL()+"',"
						+"'"+of.getQteXL()+"',"
						+"'"+of.getPUProp()+"',"
						+"'"+of.getPURéel()+"'"+
						")"; 
		System.out.println(req);
	result = st.executeUpdate(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result ;
}

}
