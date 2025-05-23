package listeners;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import screen.Screen;

public class MyMouseListener implements MouseListener{

    /*
     * Essa classe unicamente modifica a aparência dos botões do BUTTONSpanel
     * quando clicados pelo mouse e quando o mouse passa por cima deles
    */

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        //ArrayList contendo todos os botões de BUTTONSpanel
        ArrayList<JButton> buttonList = new ArrayList<>(){{
            add(Screen.getMy_BUTTONSpanel().getADDbutton());
            add(Screen.getMy_BUTTONSpanel().getEDITbutton());
            add(Screen.getMy_BUTTONSpanel().getREMOVEbutton());
            add(Screen.getMy_BUTTONSpanel().getTABLEbutton());
            add(Screen.getMy_BUTTONSpanel().getSEARCHbutton());
            add(Screen.getMy_BUTTONSpanel().getSORTbutton());
        }};

        final Color color = new Color(0,0,128);

        if(buttonList.contains((JButton)e.getSource())){
            ((JButton)e.getSource()).setForeground(color);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //ArrayList contendo todos os botões de BUTTONSpanel
        ArrayList<JButton> buttonList = new ArrayList<>(){{
            add(Screen.getMy_BUTTONSpanel().getADDbutton());
            add(Screen.getMy_BUTTONSpanel().getEDITbutton());
            add(Screen.getMy_BUTTONSpanel().getREMOVEbutton());
            add(Screen.getMy_BUTTONSpanel().getTABLEbutton());
            add(Screen.getMy_BUTTONSpanel().getSEARCHbutton());
            add(Screen.getMy_BUTTONSpanel().getSORTbutton());
        }};

        final Color color = Color.BLUE;

        if(buttonList.contains((JButton)e.getSource())){
            ((JButton)e.getSource()).setForeground(color);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        //ArrayList contendo todos os botões de BUTTONSpanel
        ArrayList<JButton> buttonList = new ArrayList<>(){{
            add(Screen.getMy_BUTTONSpanel().getADDbutton());
            add(Screen.getMy_BUTTONSpanel().getEDITbutton());
            add(Screen.getMy_BUTTONSpanel().getREMOVEbutton());
            add(Screen.getMy_BUTTONSpanel().getTABLEbutton());
            add(Screen.getMy_BUTTONSpanel().getSEARCHbutton());
            add(Screen.getMy_BUTTONSpanel().getSORTbutton());
        }};

        final Font font_entred = new Font("Arial",Font.PLAIN,20);

        if(buttonList.contains((JButton)e.getSource())){
            ((JButton) e.getSource()).setForeground(Color.BLUE);
            ((JButton) e.getSource()).setFont(font_entred);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        //ArrayList contendo todos os botões de BUTTONSpanel
        ArrayList<JButton> buttonList = new ArrayList<>(){{
            add(Screen.getMy_BUTTONSpanel().getADDbutton());
            add(Screen.getMy_BUTTONSpanel().getEDITbutton());
            add(Screen.getMy_BUTTONSpanel().getREMOVEbutton());
            add(Screen.getMy_BUTTONSpanel().getTABLEbutton());
            add(Screen.getMy_BUTTONSpanel().getSEARCHbutton());
            add(Screen.getMy_BUTTONSpanel().getSORTbutton());
        }};
        
        final Font font_exited = new Font("Arial",Font.PLAIN,16);
        final Color color = Color.WHITE;

        if(buttonList.contains((JButton)e.getSource())){
            ((JButton)e.getSource()).setForeground(color);
            ((JButton)e.getSource()).setFont(font_exited);
        }

    }
    
}
