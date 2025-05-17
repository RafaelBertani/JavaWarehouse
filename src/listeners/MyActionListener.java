package listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import screen.Screen;

public class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Screen.getMy_BUTTONSpanel().getADICIONARbutton()){ //ADICIONAR

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEDITARbutton()){ //EDITAR

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVERbutton()){ //REMOVER

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getTABELAbutton()){ //TABELA

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getBUSCARbutton()){ //BUSCAR

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getORDENARbutton()){ //ORDENAR

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEXPORTARbutton()){ //EXPORTAR

        }
        

    }
    
}
