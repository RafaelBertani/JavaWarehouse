package mainPanels;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import screen.Screen;
import screen.ScreenFunctions;

public class BUTTONSpanel {
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JButton ADICIONARbutton;
    private JButton EDITARbutton;
    private JButton REMOVERbutton;
    private JButton TABELAbutton;
    private JButton BUSCARbutton;
    private JButton ORDENARbutton;
    private JButton EXPORTARbutton;

    public JButton getADICIONARbutton() {
        return ADICIONARbutton;
    }

    public JButton getEDITARbutton() {
        return EDITARbutton;
    }

    public JButton getREMOVERbutton() {
        return REMOVERbutton;
    }

    public JButton getTABELAbutton() {
        return TABELAbutton;
    }

    public JButton getBUSCARbutton() {
        return BUSCARbutton;
    }

    public JButton getORDENARbutton() {
        return ORDENARbutton;
    }

    public JButton getEXPORTARbutton() {
        return EXPORTARbutton;
    }


    public BUTTONSpanel(int WIDTH, int HEIGHT){

        panel = new JPanel();
        panel.setBounds(0, HEIGHT/40, WIDTH/5, 35*HEIGHT/40);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));

        ADICIONARbutton = new JButton();
        ScreenFunctions.button_setup(ADICIONARbutton, "Adicionar item", 0, 0, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(ADICIONARbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        ADICIONARbutton.setFocusable(false);
        ADICIONARbutton.setBorder(null);
        ADICIONARbutton.addMouseListener(Screen.myMouseListener);
        panel.add(ADICIONARbutton);

        EDITARbutton = new JButton();
        ScreenFunctions.button_setup(EDITARbutton, "Editar item", 0, 1*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(EDITARbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        EDITARbutton.setFocusable(false);
        EDITARbutton.setBorder(null);
        EDITARbutton.addMouseListener(Screen.myMouseListener);
        panel.add(EDITARbutton);

        REMOVERbutton = new JButton();
        ScreenFunctions.button_setup(REMOVERbutton, "Remover item", 0, 2*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(REMOVERbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        REMOVERbutton.setFocusable(false);
        REMOVERbutton.setBorder(null);
        REMOVERbutton.addMouseListener(Screen.myMouseListener);
        panel.add(REMOVERbutton);

        TABELAbutton = new JButton();
        ScreenFunctions.button_setup(TABELAbutton, "Ver tabela de items", 0, 3*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(TABELAbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        TABELAbutton.setFocusable(false);
        TABELAbutton.setBorder(null);
        TABELAbutton.addMouseListener(Screen.myMouseListener);
        panel.add(TABELAbutton);

        BUSCARbutton = new JButton();
        ScreenFunctions.button_setup(BUSCARbutton, "Buscar item", 0, 4*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(BUSCARbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        BUSCARbutton.setFocusable(false);
        BUSCARbutton.setBorder(null);
        BUSCARbutton.addMouseListener(Screen.myMouseListener);
        panel.add(BUSCARbutton);

        ORDENARbutton = new JButton();
        ScreenFunctions.button_setup(ORDENARbutton, "Ordenar por", 0, 5*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(ORDENARbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        ORDENARbutton.setFocusable(false);
        ORDENARbutton.setBorder(null);
        ORDENARbutton.addMouseListener(Screen.myMouseListener);
        panel.add(ORDENARbutton);

        EXPORTARbutton = new JButton();
        ScreenFunctions.button_setup(EXPORTARbutton, "Exportar dados", 0, 6*(35*HEIGHT/40)/8, WIDTH/5, (35*HEIGHT/40)/8, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(EXPORTARbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        EXPORTARbutton.setFocusable(false);
        EXPORTARbutton.setBorder(null);
        EXPORTARbutton.addMouseListener(Screen.myMouseListener);
        panel.add(EXPORTARbutton);
        
    }

}
