package screen;
import java.awt.Color;
import javax.swing.*;
import listeners.MyActionListener;
import listeners.MyMouseListener;
import main_panels.BUTTONSpanel;
import main_panels.CENTERpanel;
import main_panels.LOGSpanel;

public class Screen extends JFrame{

    //JCOMPONENTS
    private static final JFrame MAINframe = new JFrame();
    private static final JPanel MAINpanel = new JPanel();
    private static BUTTONSpanel my_BUTTONSpanel;
    private static LOGSpanel my_LOGSpanel;
    private static CENTERpanel my_CENTERpanel;

    public static BUTTONSpanel getMy_BUTTONSpanel() {
        return my_BUTTONSpanel;
    }

    public static LOGSpanel getMy_LOGSpanel() {
        return my_LOGSpanel;
    }

    public static CENTERpanel getMy_CENTERpanel() {
        return my_CENTERpanel;
    }
    
    public static MyActionListener myActionListener = new MyActionListener();
    public static MyMouseListener myMouseListener = new MyMouseListener();
    
    public Screen(int WIDTH, int HEIGHT){

        /*
         * Poderia ser colocado todos os elementos visuais nesta classe, mas isso faria o
         * cógigo ficar muito extenso e difícil de compreender, então, a tela inicial foi
         * divida em 3 partes: botões (na esquerda), registros (inferior) e central.
         * 
         * Estes 3 paineis secundários são adicionados no painel principal (MAINpanel)
         * conforme feito nas linhas a seguir
        */

        //painel de botões é instanciado e adicionado
        my_BUTTONSpanel = new BUTTONSpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_BUTTONSpanel.getPanel());

        //painel de registros é instanciado e adicionado
        my_LOGSpanel = new LOGSpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_LOGSpanel.getPanel());

        //painel central é instanciado e adicionado
        my_CENTERpanel = new CENTERpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_CENTERpanel.getPanel());


        //durante o programa, será usado a classe ScreenFunctions para facilitar a criação de elementos visuais

        //após estar com todos os elementos adicionados, o painel principal (MAINpanel) é criado e adicionado ao frame principal
        ScreenFunctions.panel_setup(MAINpanel, MAINframe, 0, 0, WIDTH/5, HEIGHT);
        ScreenFunctions.panel_edit(MAINpanel, true, new Color(32,32,32));

        //frame principal (MAINframe) é criado
        ScreenFunctions.frame_setup(MAINframe, true, JFrame.EXIT_ON_CLOSE, WIDTH, HEIGHT);
        ScreenFunctions.frame_edit(MAINframe, "Gerenciamento de armazém", new Color(32,32,32));
        
    }

}