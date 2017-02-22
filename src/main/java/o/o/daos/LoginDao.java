package o.o.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class LoginDao {  
public static boolean validate(String email,String motdepasse){  
boolean status=false;  

try{  

Connection connection =  DataSourceProvider.getDataSource().getConnection();  
      
PreparedStatement ps=connection.prepareStatement(  
"select * from connexion where email=? and motdepasse=?");  
ps.setString(1,email);  
ps.setString(2,motdepasse);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  