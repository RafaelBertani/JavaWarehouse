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
    private static JFrame MAINframe = new JFrame();
    private static JPanel MAINpanel = new JPanel();

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
    // private MyKeyListener myKeyListener = new MyKeyListener();
    // private MyItemListener myItemListener = new MyItemListener();
    public static MyMouseListener myMouseListener = new MyMouseListener();
    
    public Screen(int WIDTH, int HEIGHT){

        //CREATE JFRAME
        my_CENTERpanel = new CENTERpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_CENTERpanel.getPanel());

        my_LOGSpanel = new LOGSpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_LOGSpanel.getPanel());

        my_BUTTONSpanel = new BUTTONSpanel(WIDTH,HEIGHT);
        MAINpanel.add(my_BUTTONSpanel.getPanel());

        ScreenFunctions.panel_setup(MAINpanel, MAINframe, 0, 0, WIDTH/5, HEIGHT);
        ScreenFunctions.panel_edit(MAINpanel, true, new Color(32,32,32));

        ScreenFunctions.frame_setup(MAINframe, true, JFrame.EXIT_ON_CLOSE, WIDTH, HEIGHT);
        ScreenFunctions.frame_edit(MAINframe, "Gerenciamento de armazém", new Color(32,32,32));
        
    }

}