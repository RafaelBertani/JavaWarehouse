package listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import screen.Screen;

public class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Screen.getMy_BUTTONSpanel().getADICIONARbutton()){ //ADICIONAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyAddPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEDITARbutton()){ //EDITAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyEditPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVERbutton()){ //REMOVER

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyRemovePanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getTABELAbutton()){ //TABELA

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyTablePanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getBUSCARbutton()){ //BUSCAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySearchPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getORDENARbutton()){ //ORDENAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySortPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEXPORTARbutton()){ //EXPORTAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyExportPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        

    }
    
}
