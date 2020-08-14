package pif.desktop.Classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USERNAME = "id14598616_root";

    private static final String PASSWORD = "3YA^0H&{Lu}uqwf!";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/id14598616_pi";
    /*
     *  Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e senha fornecidos 
     *  @param username 
     *  @param senha 
     *  @return uma conexão com o banco de dados 
     *  @throws Exception 
     * 
     */   
     public Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
         //Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
}
