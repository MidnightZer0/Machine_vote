
package mashinno_glasuwane;

import java.io.File;
import java.sql.*;

public class Query_methodes 
{
    public void select(String table, int col)
    {
        try {//Прихващане на изключения

            File dbFile = new File("src/DB/Mashinno_glasuvane3.accdb");
            String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
            
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM ["+table+"] ");
            while (rs.next()) {
                System.out.println(rs.getString(col));
            }

            conn.close();//ВАЖНО!!! Не забравяйте да затворите връзката ... 

        } catch (Exception ex) {//обработка при грешка
           System.out.println(ex.getMessage());
            //извеждане на грешката като текст в скрия label
        }
    }
    
    public void delete(String table, String crit,String val)
    {
        try {//Прихващане на изключения

            File dbFile = new File("src/DB/Mashinno_glasuvane3.accdb");
            String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
            
            Statement s = conn.createStatement();
            //sql = "DELETE FROM ["+table+"] WHERE " + crit + "=\"" + val + "\"";
            //System.out.println(sql);
            s.executeUpdate("DELETE FROM ["+table+"] WHERE "+crit+" like '"+val+"'");
            conn.close();//ВАЖНО!!! Не забравяйте да затворите връзката ... 

        } catch (Exception ex) {//обработка при грешка
           System.out.println(ex.getMessage());
            //извеждане на грешката като текст в скрия label
        }
    }
    
    public void append(String table, String crit, String val)
    {
        try {//Прихващане на изключения

            File dbFile = new File("src/DB/Mashinno_glasuvane3.accdb");
            String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
            
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("DELETE FROM ["+table+"] WHERE " + crit + "=\"" + val + "\"");
            
            conn.close();//ВАЖНО!!! Не забравяйте да затворите връзката ... 

        } catch (Exception ex) {//обработка при грешка
           System.out.println(ex.getMessage());
            //извеждане на грешката като текст в скрия label
        }
    }
    /*
    public void delete(String table, String crit, String val)
    {
        String sql;
        try {//Прихващане на изключения

            File dbFile = new File("src/DB/Mashinno_glasuvane3.accdb");
            String path = dbFile.getAbsolutePath();//Взимане на абсолютния път
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
            
            Statement s = conn.createStatement();
            sql = "DELETE FROM ["+table+"] WHERE " + crit + "=\"" + val + "\"";
            System.out.println(sql);
            ResultSet rs = s.executeQuery("DELETE FROM ["+table+"] WHERE " + crit + "=\"" + val + "\"");
            
            conn.close();//ВАЖНО!!! Не забравяйте да затворите връзката ... 

        } catch (Exception ex) {//обработка при грешка
           System.out.println(ex.getMessage());
            //извеждане на грешката като текст в скрия label
        }*/
    
}
