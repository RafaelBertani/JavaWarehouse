package main_panels;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import screen.Screen;
import screen.ScreenFunctions;

public class BUTTONSpanel {
    
    /*
    * 
    * Nesta classe o painel de botões é preenchido
    * 
    */

    //este é o painel que receberá todos os botões
    private final JPanel panel;

    // este getPanel que retorna o painel preparado para ser adicionado ao mainPANEL fora dessa classe
    public JPanel getPanel() {
        return panel;
    }

    private final JButton ADDbutton;
    private final JButton EDITbutton;
    private final JButton REMOVEbutton;
    private final JButton TABLEbutton;
    private final JButton SEARCHbutton;
    private final JButton SORTbutton;

    public JButton getADDbutton() {
        return ADDbutton;
    }

    public JButton getEDITbutton() {
        return EDITbutton;
    }

    public JButton getREMOVEbutton() {
        return REMOVEbutton;
    }

    public JButton getTABLEbutton() {
        return TABLEbutton;
    }

    public JButton getSEARCHbutton() {
        return SEARCHbutton;
    }

    public JButton getSORTbutton() {
        return SORTbutton;
    }
    

    public BUTTONSpanel(int WIDTH, int HEIGHT){

        //define a altura padrão de um botão
        int button_height = (35*HEIGHT/40)/6;

        panel = new JPanel();
        panel.setBounds(0, HEIGHT/40, WIDTH/5, 35*HEIGHT/40);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));

        //cria e edita botão ADICIONAR
        ADDbutton = new JButton();
        ScreenFunctions.button_setup(ADDbutton, "Adicionar item", 0, 0, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(ADDbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        ADDbutton.setBorder(null);
        ADDbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        ADDbutton.setFocusPainted(false);
        ADDbutton.setContentAreaFilled(false);
        ADDbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(ADDbutton);

        //cria e edita botão EDITAR
        EDITbutton = new JButton();
        ScreenFunctions.button_setup(EDITbutton, "Editar item", 0, 1*button_height, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(EDITbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        EDITbutton.setBorder(null);
        EDITbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        EDITbutton.setFocusPainted(false);
        EDITbutton.setContentAreaFilled(false);
        EDITbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(EDITbutton);

        //cria e edita botão REMOVER
        REMOVEbutton = new JButton();
        ScreenFunctions.button_setup(REMOVEbutton, "Remover item", 0, 2*button_height, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(REMOVEbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        REMOVEbutton.setBorder(null);
        REMOVEbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        REMOVEbutton.setFocusPainted(false);
        REMOVEbutton.setContentAreaFilled(false);
        REMOVEbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(REMOVEbutton);

        //cria e edita botão VER TABELA
        TABLEbutton = new JButton();
        ScreenFunctions.button_setup(TABLEbutton, "Ver tabela de items", 0, 3*button_height, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(TABLEbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        TABLEbutton.setBorder(null);
        TABLEbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        TABLEbutton.setFocusPainted(false);
        TABLEbutton.setContentAreaFilled(false);
        TABLEbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(TABLEbutton);

        //cria e edita botão BUSCAR
        SEARCHbutton = new JButton();
        ScreenFunctions.button_setup(SEARCHbutton, "Buscar itens", 0, 4*button_height, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(SEARCHbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        SEARCHbutton.setBorder(null);
        SEARCHbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        SEARCHbutton.setFocusPainted(false);
        SEARCHbutton.setContentAreaFilled(false);
        SEARCHbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(SEARCHbutton);

        //cria e edita botão ORDENAR
        SORTbutton = new JButton();
        ScreenFunctions.button_setup(SORTbutton, "Ordenar por", 0, 5*button_height, WIDTH/5, button_height, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(SORTbutton, new Font("Arial",Font.PLAIN,16), new Color(32,32,32), Color.WHITE);
        SORTbutton.setBorder(null);
        SORTbutton.addMouseListener(Screen.myMouseListener);
        //remover preenchimento automático de fundo quando clicar
        SORTbutton.setFocusPainted(false);
        SORTbutton.setContentAreaFilled(false);
        SORTbutton.setOpaque(true);
        //adiciona botão no painel BUTTONSpanel
        panel.add(SORTbutton);
        
    }

}
