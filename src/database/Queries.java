package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Queries {
    
    public static void adicionar_item(Item i){

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        try{ 
            pstm = c.prepareStatement("insert into produtos (nome, preco, marca, validade, quantidade, setor) values (?,?,?,?,?,?)");
            pstm.setString(1, i.getNome());
            pstm.setDouble(2, i.getPreco());
            pstm.setString(3, i.getMarca());
            pstm.setDate(4, i.getValidade());
            pstm.setInt(5, i.getQuantidade());
            pstm.setInt(6, i.getSetor());
            pstm.execute();

            pstm = c.prepareStatement("SELECT MAX( id ) FROM produtos;");
            resultQUERY = pstm.executeQuery();
            resultQUERY.next();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}    
    }

    public static void editar_item(int id, String coluna, String novaINFO){

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = c.prepareStatement("update produtos set "+coluna+"='"+novaINFO+"' where id="+id);
            pstm.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}
        
    }

    public static void remove_item(int id){

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        try{ 
            pstm = c.prepareStatement("delete from produtos where id="+id);
            pstm.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}
        
    }

    public static ArrayList<Item> retorna_busca(String coluna, String operador, String valor){
        
        ArrayList<Item> resultados = new ArrayList<>();
        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        try{
            
            if(coluna.equals("validade")){valor="\'"+valor+"\'";}

            pstm = c.prepareStatement("select * from produtos where "+coluna+operador+valor);
            resultQUERY=pstm.executeQuery();
            while(resultQUERY.next()){
                //indexes começam no 1, ou seja, 1=id
                Item novo = new Item(
                    resultQUERY.getString(2), //nome
                    resultQUERY.getDouble(3), //preço
                    resultQUERY.getString(4), //marca
                    resultQUERY.getDate(5), //validade
                    resultQUERY.getInt(6), //quant
                    resultQUERY.getInt(7) //setor
                );
                novo.setIndex(resultQUERY.getInt(1));
                resultados.add(novo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}

        return resultados;
        
    }

    public static ArrayList<Item> retorna_tabela(){
        
        ArrayList<Item> resultados = new ArrayList<>();
        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        try{
            
            pstm = c.prepareStatement("select * from produtos");
            resultQUERY=pstm.executeQuery();
            while(resultQUERY.next()){
                //indexes começam no 1, ou seja, 1=id
                Item novo = new Item(
                    resultQUERY.getString(2), //nome
                    resultQUERY.getDouble(3), //preço
                    resultQUERY.getString(4), //marca
                    resultQUERY.getDate(5), //validade
                    resultQUERY.getInt(6), //setor
                    resultQUERY.getInt(7) //quant

                );
                novo.setIndex(resultQUERY.getInt(1));
                resultados.add(novo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}
        
        return resultados;
    }

}
