
package admin;

import java.sql.*;

public class Studentlogout 
{
    Statement s;
    Studentlogout()
    {
        try
        {
            Conn c = new Conn();
            s=c.c.createStatement();
            s.executeUpdate("DELETE FROM `username`");
            System.out.println("Record Deleted");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
