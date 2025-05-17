import database.Database;
import java.awt.Dimension;
import java.awt.Toolkit;
import screen.Screen;

public class Main{

    public static void main(String[] args) {
    
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

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
