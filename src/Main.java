import database.Database;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import screen.Screen;

public class Main{

    public static void main(String[] args) {
    
        int width = -1;
        int height = -1;
        //tenta pegar altura e largura da tela
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screenSize.getWidth();
            height = (int) screenSize.getHeight();   
        } catch (HeadlessException e) {
            System.out.println("Erro ao descobrir dimensões da tela");
        }
        //se tiver algum problema com as dimensões da tela, usa essas por padrão
        if(width < 1200 || height < 600){
            width = 1200;
            height = 600;
        }


        try {
            Database.createDATABASE(); //cria base de dados, caso ainda não exista
        } catch (Exception e) {
            System.out.println("Erro ao criar base de dados");
        }
        Database.createTABLE(); //cria tabela, caso ainda não exista

        //inicializa a tela
        new Screen(width,height);
    
    }    
}
