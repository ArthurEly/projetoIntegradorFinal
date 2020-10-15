package pif.desktop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String USERNAME = "u618559852_arttidev";

    private static final String PASSWORD = "1234abc";

    private static final String DATABASE_URL = "jdbc:mysql://sql132.main-hosting.eu/u618559852_pif";
    
    private Connection conexao;
    /*
     *  Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e senha fornecidos 
     *  @param username 
     *  @param senha 
     *  @return uma conexão com o banco de dados 
     *  @throws Exception 
     * 
     */   
    public Connection conectarAoBanco(){
        try{
            System.out.println("Iniciando conexão com o banco de dados.");
            //Faz com que a classe seja carregada pela JVM
            Class.forName("com.mysql.jdbc.Driver"); 
            //Cria a conexão com o banco de dados
            conexao = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Sucesso!");          
        }catch(SQLException e){
            System.out.println("Não conseguiu conectar com o banco de dados." + e);
        }catch(ClassNotFoundException e){
            System.out.println("Não achou a classe de conexão.");
        }
        return conexao;
    }
    
    public void desconectarDoBanco(){
        try{
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            }                    
        }catch(SQLException e){
            System.out.println("Erro ao desconectar: " + e);
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    public static void main(String[] agrs){
        //só pra testar sem abrir a tela
        Conexao c = new Conexao();
        c.conectarAoBanco();
    }
}
