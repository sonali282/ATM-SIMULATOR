 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator.system;

/**
 *
 * @author sonai priya
 */
import java.sql.*;

public class conn {
    public Connection c;
    public Statement s;
    public conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3308/atm_simulator","root","");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        } 
    }
    
}
