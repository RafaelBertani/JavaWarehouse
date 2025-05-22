package listeners;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        
        final JButton BUTTONS_ADD = Screen.getMy_BUTTONSpanel().getADDbutton();
        final JButton BUTTONS_EDIT = Screen.getMy_BUTTONSpanel().getEDITbutton();
        final JButton BUTTONS_REMOVE = Screen.getMy_BUTTONSpanel().getREMOVEbutton();
        final JButton BUTTONS_TABLE = Screen.getMy_BUTTONSpanel().getTABLEbutton();
        final JButton BUTTONS_SEARCH = Screen.getMy_BUTTONSpanel().getSEARCHbutton();
        final JButton BUTTONS_SORT = Screen.getMy_BUTTONSpanel().getSORTbutton();
        
        if(e.getSource()==BUTTONS_ADD){
            BUTTONS_ADD.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_EDIT){
            BUTTONS_EDIT.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_REMOVE){
            BUTTONS_REMOVE.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_TABLE){
            BUTTONS_TABLE.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_SEARCH){
            BUTTONS_SEARCH.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_SORT){
            BUTTONS_SORT.setForeground(new Color(0,0,128));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        final JButton BUTTONS_ADD = Screen.getMy_BUTTONSpanel().getADDbutton();
        final JButton BUTTONS_EDIT = Screen.getMy_BUTTONSpanel().getEDITbutton();
        final JButton BUTTONS_REMOVE = Screen.getMy_BUTTONSpanel().getREMOVEbutton();
        final JButton BUTTONS_TABLE = Screen.getMy_BUTTONSpanel().getTABLEbutton();
        final JButton BUTTONS_SEARCH = Screen.getMy_BUTTONSpanel().getSEARCHbutton();
        final JButton BUTTONS_SORT = Screen.getMy_BUTTONSpanel().getSORTbutton();

        if(e.getSource()==BUTTONS_ADD){
            BUTTONS_ADD.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_EDIT){
            BUTTONS_EDIT.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_REMOVE){
            BUTTONS_REMOVE.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_TABLE){
            BUTTONS_TABLE.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_SEARCH){
            BUTTONS_SEARCH.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_SORT){
            BUTTONS_SORT.setForeground(Color.BLUE);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        final JButton BUTTONS_ADD = Screen.getMy_BUTTONSpanel().getADDbutton();
        final JButton BUTTONS_EDIT = Screen.getMy_BUTTONSpanel().getEDITbutton();
        final JButton BUTTONS_REMOVE = Screen.getMy_BUTTONSpanel().getREMOVEbutton();
        final JButton BUTTONS_TABLE = Screen.getMy_BUTTONSpanel().getTABLEbutton();
        final JButton BUTTONS_SEARCH = Screen.getMy_BUTTONSpanel().getSEARCHbutton();
        final JButton BUTTONS_SORT = Screen.getMy_BUTTONSpanel().getSORTbutton();
        if(e.getSource()==BUTTONS_ADD){
            BUTTONS_ADD.setForeground(Color.BLUE);
            BUTTONS_ADD.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_EDIT){
            BUTTONS_EDIT.setForeground(Color.BLUE);
            BUTTONS_EDIT.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_REMOVE){
            BUTTONS_REMOVE.setForeground(Color.BLUE);
            BUTTONS_REMOVE.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_TABLE){
            BUTTONS_TABLE.setForeground(Color.BLUE);
            BUTTONS_TABLE.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_SEARCH){
            BUTTONS_SEARCH.setForeground(Color.BLUE);
            BUTTONS_SEARCH.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_SORT){
            BUTTONS_SORT.setForeground(Color.BLUE);
            BUTTONS_SORT.setFont(new Font("Arial",Font.PLAIN,20));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        final JButton BUTTONS_ADD = Screen.getMy_BUTTONSpanel().getADDbutton();
        final JButton BUTTONS_EDITAR = Screen.getMy_BUTTONSpanel().getEDITbutton();
        final JButton BUTTONS_REMOVE = Screen.getMy_BUTTONSpanel().getREMOVEbutton();
        final JButton BUTTONS_TABLE = Screen.getMy_BUTTONSpanel().getTABLEbutton();
        final JButton BUTTONS_SEARCH = Screen.getMy_BUTTONSpanel().getSEARCHbutton();
        final JButton BUTTONS_SORT = Screen.getMy_BUTTONSpanel().getSORTbutton();

        if(e.getSource()==BUTTONS_ADD){
            BUTTONS_ADD.setForeground(Color.WHITE);
            BUTTONS_ADD.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_EDITAR){
            BUTTONS_EDITAR.setForeground(Color.WHITE);
            BUTTONS_EDITAR.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_REMOVE){
            BUTTONS_REMOVE.setForeground(Color.WHITE);
            BUTTONS_REMOVE.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_TABLE){
            BUTTONS_TABLE.setForeground(Color.WHITE);
            BUTTONS_TABLE.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_SEARCH){
            BUTTONS_SEARCH.setForeground(Color.WHITE);
            BUTTONS_SEARCH.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_SORT){
            BUTTONS_SORT.setForeground(Color.WHITE);
            BUTTONS_SORT.setFont(new Font("Arial",Font.PLAIN,16));
        }

    }
    
}
