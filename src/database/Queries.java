package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import log.Log;
import screen.Screen;

public class Queries {
    
    public static boolean addItem(Item i){

        boolean successful = true;

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

            Screen.getMy_LOGSpanel().getItem_list().add(new Log("INSERT", "insert into produtos (nome, preco, marca, validade quantidade, setor) values ("+i.getNome()+", "+i.getPreco()+", "+i.getMarca()+", "+i.getValidade()+", "+i.getQuantidade()+", "+i.getSetor()+")", Log.current_timestamp()));
            Screen.getMy_LOGSpanel().getPanel().setVisible(false);
            Screen.getMy_LOGSpanel().update_table();
            Screen.getMy_LOGSpanel().getPanel().setVisible(true);

        }catch(SQLException e){
            e.printStackTrace();
            successful = false;
        }finally{Database.closeConnection(c);}    
    
        return successful;

    }

    public static boolean editItem(int id, String column, String newINFO){

        boolean successful = true;

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = c.prepareStatement("update produtos set "+column+"='"+newINFO+"' where id="+id);
            pstm.execute();

            Screen.getMy_LOGSpanel().getItem_list().add(new Log("UPDATE", "update produtos set "+column+"='"+newINFO+"' where id="+id, Log.current_timestamp()));
            Screen.getMy_LOGSpanel().getPanel().setVisible(false);
            Screen.getMy_LOGSpanel().update_table();
            Screen.getMy_LOGSpanel().getPanel().setVisible(true);
            
        }catch(SQLException e){
            e.printStackTrace();
            successful = false;
        }finally{Database.closeConnection(c);}
        
        return successful;

    }

    public static boolean removeItem(int id){

        boolean successful = true;

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        try{ 
            pstm = c.prepareStatement("delete from produtos where id="+id);
            pstm.execute();

            Screen.getMy_LOGSpanel().getItem_list().add(new Log("DELETE", "delete from produtos where id="+id, Log.current_timestamp()));
            Screen.getMy_LOGSpanel().getPanel().setVisible(false);
            Screen.getMy_LOGSpanel().update_table();
            Screen.getMy_LOGSpanel().getPanel().setVisible(true);

        }catch(SQLException e){
            e.printStackTrace();
            successful = false;
        }finally{Database.closeConnection(c);}

        return successful;
        
    }

    public static ArrayList<Item> retorna_busca(String column, String operator, String value){
        
        ArrayList<Item> resultados = new ArrayList<>();
        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        try{
            
            if(column.equals("validade")){value="\'"+value+"\'";}

            pstm = c.prepareStatement("select * from produtos where "+column+operator+value);
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
                novo.setId(resultQUERY.getInt(1));
                resultados.add(novo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}

        return resultados;
        
    }

    public static ArrayList<Item> returnTable(){
        
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
                novo.setId(resultQUERY.getInt(1));
                resultados.add(novo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}
        
        return resultados;
    }

    public static String returnSpecificValue(int id, String column){
        
        String result = "";

        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        
        try{ 
            pstm = c.prepareStatement("SELECT "+column+" FROM produtos WHERE id="+id);
            resultQUERY=pstm.executeQuery();
            while(resultQUERY.next()){
                result=resultQUERY.getString(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{Database.closeConnection(c);}

        return result;

    }

    public static ArrayList<Item> sortByColumn(String column, boolean ASC){
        
        ArrayList<Item> resultados = new ArrayList<>();
        Connection c = Database.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultQUERY = null;
        Item novo;
        try{ 
            if(ASC){pstm = c.prepareStatement("SELECT * FROM produtos ORDER BY "+ column +" ASC");}
            else{pstm = c.prepareStatement("SELECT * FROM produtos ORDER BY "+ column +" DESC");}
            resultQUERY=pstm.executeQuery();
            while(resultQUERY.next()){
                //indexes começam no 1, ou seja, 1=id
                novo = new Item(
                    resultQUERY.getString(2), //nome
                    resultQUERY.getDouble(3), //preço
                    resultQUERY.getString(4), //marca
                    resultQUERY.getDate(5), //validade
                    resultQUERY.getInt(6), //quant
                    resultQUERY.getInt(7) //setor
                );
                novo.setId(resultQUERY.getInt(1)); //id
                resultados.add(novo);
            }

        } catch(SQLException e){JOptionPane.showMessageDialog(null, "ERRO! Falha na conexão com o Banco de Dados", "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }finally{Database.closeConnection(c);}
        
        return resultados;
    }

}
