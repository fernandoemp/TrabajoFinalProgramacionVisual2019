import java.sql.*;

public class TestConnection
{
   static String login = "root";
   static String password = "admin";
   static String url = "jdbc:mysql://localhost:3306/jugueteria?serverTimezone=UTC";

   public static void main(String[] args) throws Exception
   {
      Connection conn = null;

      try
      {
         Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

         conn = DriverManager.getConnection(url,login,password);

         if (conn != null)
         {
            System.out.println("Conexión a base de datos "+url+" ... Ok");
            conn.close();
         }
      }
      catch(SQLException | ClassNotFoundException ex)
      {
         System.out.println(ex);
      }

   }
}
