package database;

import java.sql.*;

public class Database {

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url+databaseName, userName, password);
        } catch ( ClassNotFoundException | SQLException ErroSQL) {
            throw new RuntimeException("Erro, não foi possível conectar com o banco de dados."+ErroSQL);
        }
    }

    public static void closeConnection(Connection c){
        try {
            if(c!=null){
                c.close();
            }
        } catch (SQLException ErroSQL) {
            throw new RuntimeException("Erro, não foi possível fechar o banco de dados."+ErroSQL);
        }
    }

    //LOCAL
    public static String url = "jdbc:mysql://localhost:3306/";
    public static String databaseName = "my_db";
    public static String userName = "root";
    public static String password = ""; //"mysqlimt -> senha padrão nos computadores da mauá";

        public static void criaDATABASE() throws Exception{
        
        try {

            Connection connection = DriverManager.getConnection(url,userName,password);

            Statement statement = connection.createStatement();

            String sql = "CREATE DATABASE " + databaseName;
            try{
                statement.executeUpdate(sql);
                //statement.close();
                System.out.println("Database created");
            }catch(SQLException e){
                System.out.println("Database already exists");
            }

            String use = "USE " + databaseName;
            statement.executeUpdate(use);
            statement.close();
            System.out.println("Database selected");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void criaTabela() {
        try {
            Connection connection = getConnection();

            boolean tabelaPresente = false;
            ResultSet tablesResult;
            DatabaseMetaData meta = connection.getMetaData();
            tablesResult = meta.getTables(null, null, "%", new String[] {"TABLE"});

            while(tablesResult.next()) {
                //System.out.println(tablesResult.getString("TABLE_NAME"));
                if(tablesResult.getString("TABLE_NAME").equals("produtos")) {
                    tabelaPresente = true;
                }
            }

            if(!tabelaPresente) {
                String sql = "CREATE TABLE produtos (id INT AUTO_INCREMENT NOT NULL, nome VARCHAR(50) NOT NULL, preco DECIMAL(9,2) NOT NULL, marca VARCHAR(50) NOT NULL, validade DATE, quantidade INT NOT NULL, setor INT NOT NULL, PRIMARY KEY (id) )";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                statement.close();
                System.out.println("Table created");
            }
            else{
                System.out.println("Table already created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
