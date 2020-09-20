package pif.desktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String USERNAME = "u618559852_arttidev";
    private static final String PASSWORD = "ArThUr040203716228";
    private static final String DATABASE_URL = "jdbc:mysql://sql132.main-hosting.eu/u618559852_pif";
    private Connection conexao;

    public  Conexao() {

    }

    public Connection conectarAoBanco() {
        System.out.println("Iniciando conexão com o banco de dados.");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexao = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Sucesso!");          
        }catch(SQLException e){
            System.err.println("Não conseguiu conectar com o banco de dados.\n\n" + e);
        }catch(ClassNotFoundException e){
            System.err.println("Não achou a classe de conexão.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
    public void desconectarDoBanco(){
        try{
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } else {
                System.out.println("A conexão já está fechada");
            }
        }catch(SQLException e){
            System.out.println("Erro ao desconectar: " + e);
        }
    }
    
    public Connection getConexao() {
        return conexao;
    }
}
