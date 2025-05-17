package listeners;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import screen.Screen;

public class MyMouseListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource()==Screen.getMy_LOGSpanel().getTable()){
            System.out.println(Screen.getMy_LOGSpanel().getTable().getSelectedRow());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        final JButton BUTTONS_ADICIONAR = Screen.getMy_BUTTONSpanel().getADICIONARbutton();
        final JButton BUTTONS_EDITAR = Screen.getMy_BUTTONSpanel().getEDITARbutton();
        final JButton BUTTONS_REMOVER = Screen.getMy_BUTTONSpanel().getREMOVERbutton();
        final JButton BUTTONS_TABELA = Screen.getMy_BUTTONSpanel().getTABELAbutton();
        final JButton BUTTONS_BUSCAR = Screen.getMy_BUTTONSpanel().getBUSCARbutton();
        final JButton BUTTONS_ORDENAR = Screen.getMy_BUTTONSpanel().getORDENARbutton();
        final JButton BUTTONS_EXPORTAR = Screen.getMy_BUTTONSpanel().getEXPORTARbutton();

        if(e.getSource()==BUTTONS_ADICIONAR){
            BUTTONS_ADICIONAR.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_EDITAR){
            BUTTONS_EDITAR.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_REMOVER){
            BUTTONS_REMOVER.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_TABELA){
            BUTTONS_TABELA.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_BUSCAR){
            BUTTONS_BUSCAR.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_ORDENAR){
            BUTTONS_ORDENAR.setForeground(new Color(0,0,128));
        }
        else if(e.getSource()==BUTTONS_EXPORTAR){
            BUTTONS_EXPORTAR.setForeground(new Color(0,0,128));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        final JButton BUTTONS_ADICIONAR = Screen.getMy_BUTTONSpanel().getADICIONARbutton();
        final JButton BUTTONS_EDITAR = Screen.getMy_BUTTONSpanel().getEDITARbutton();
        final JButton BUTTONS_REMOVER = Screen.getMy_BUTTONSpanel().getREMOVERbutton();
        final JButton BUTTONS_TABELA = Screen.getMy_BUTTONSpanel().getTABELAbutton();
        final JButton BUTTONS_BUSCAR = Screen.getMy_BUTTONSpanel().getBUSCARbutton();
        final JButton BUTTONS_ORDENAR = Screen.getMy_BUTTONSpanel().getORDENARbutton();
        final JButton BUTTONS_EXPORTAR = Screen.getMy_BUTTONSpanel().getEXPORTARbutton();

        if(e.getSource()==BUTTONS_ADICIONAR){
            BUTTONS_ADICIONAR.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_EDITAR){
            BUTTONS_EDITAR.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_REMOVER){
            BUTTONS_REMOVER.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_TABELA){
            BUTTONS_TABELA.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_BUSCAR){
            BUTTONS_BUSCAR.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_ORDENAR){
            BUTTONS_ORDENAR.setForeground(Color.BLUE);
        }
        else if(e.getSource()==BUTTONS_EXPORTAR){
            BUTTONS_EXPORTAR.setForeground(Color.BLUE);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        final JButton BUTTONS_ADICIONAR = Screen.getMy_BUTTONSpanel().getADICIONARbutton();
        final JButton BUTTONS_EDITAR = Screen.getMy_BUTTONSpanel().getEDITARbutton();
        final JButton BUTTONS_REMOVER = Screen.getMy_BUTTONSpanel().getREMOVERbutton();
        final JButton BUTTONS_TABELA = Screen.getMy_BUTTONSpanel().getTABELAbutton();
        final JButton BUTTONS_BUSCAR = Screen.getMy_BUTTONSpanel().getBUSCARbutton();
        final JButton BUTTONS_ORDENAR = Screen.getMy_BUTTONSpanel().getORDENARbutton();
        final JButton BUTTONS_EXPORTAR = Screen.getMy_BUTTONSpanel().getEXPORTARbutton();

        if(e.getSource()==BUTTONS_ADICIONAR){
            //BUTTONS_ADICIONAR.setBorder(new LineBorder(Color.BLUE, 2));
            BUTTONS_ADICIONAR.setForeground(Color.BLUE);
            BUTTONS_ADICIONAR.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_EDITAR){
            BUTTONS_EDITAR.setForeground(Color.BLUE);
            BUTTONS_EDITAR.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_REMOVER){
            BUTTONS_REMOVER.setForeground(Color.BLUE);
            BUTTONS_REMOVER.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_TABELA){
            BUTTONS_TABELA.setForeground(Color.BLUE);
            BUTTONS_TABELA.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_BUSCAR){
            BUTTONS_BUSCAR.setForeground(Color.BLUE);
            BUTTONS_BUSCAR.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_ORDENAR){
            BUTTONS_ORDENAR.setForeground(Color.BLUE);
            BUTTONS_ORDENAR.setFont(new Font("Arial",Font.PLAIN,20));
        }
        else if(e.getSource()==BUTTONS_EXPORTAR){
            BUTTONS_EXPORTAR.setForeground(Color.BLUE);
            BUTTONS_EXPORTAR.setFont(new Font("Arial",Font.PLAIN,20));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        final JButton BUTTONS_ADICIONAR = Screen.getMy_BUTTONSpanel().getADICIONARbutton();
        final JButton BUTTONS_EDITAR = Screen.getMy_BUTTONSpanel().getEDITARbutton();
        final JButton BUTTONS_REMOVER = Screen.getMy_BUTTONSpanel().getREMOVERbutton();
        final JButton BUTTONS_TABELA = Screen.getMy_BUTTONSpanel().getTABELAbutton();
        final JButton BUTTONS_BUSCAR = Screen.getMy_BUTTONSpanel().getBUSCARbutton();
        final JButton BUTTONS_ORDENAR = Screen.getMy_BUTTONSpanel().getORDENARbutton();
        final JButton BUTTONS_EXPORTAR = Screen.getMy_BUTTONSpanel().getEXPORTARbutton();

        if(e.getSource()==BUTTONS_ADICIONAR){
            //BUTTONS_ADICIONAR.setBorder(null);
            BUTTONS_ADICIONAR.setForeground(Color.WHITE);
            BUTTONS_ADICIONAR.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_EDITAR){
            BUTTONS_EDITAR.setForeground(Color.WHITE);
            BUTTONS_EDITAR.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_REMOVER){
            BUTTONS_REMOVER.setForeground(Color.WHITE);
            BUTTONS_REMOVER.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_TABELA){
            BUTTONS_TABELA.setForeground(Color.WHITE);
            BUTTONS_TABELA.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_BUSCAR){
            BUTTONS_BUSCAR.setForeground(Color.WHITE);
            BUTTONS_BUSCAR.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_ORDENAR){
            BUTTONS_ORDENAR.setForeground(Color.WHITE);
            BUTTONS_ORDENAR.setFont(new Font("Arial",Font.PLAIN,16));
        }
        else if(e.getSource()==BUTTONS_EXPORTAR){
            BUTTONS_EXPORTAR.setForeground(Color.WHITE);
            BUTTONS_EXPORTAR.setFont(new Font("Arial",Font.PLAIN,16));
        }

    }
    
}
