import database.Database;
import java.awt.Dimension;
import java.awt.Toolkit;
import screen.Screen;

public class Main{

    public static void main(String[] args) {
    
        int width = -1;
        int height = -1;

        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screenSize.getWidth();
            height = (int) screenSize.getHeight();   
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(width<1200 || height<600){
            width=1200;
            height=600;
        }


        try {
            Database.criaDATABASE(); //CRIA DATABASE, CASO AINDA NÃO EXISTA
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.criaTabela(); //CRIA TABELA, CASO AINDA NÃO EXISTA

        
        new Screen(width,height);
    
    }    
}
