package sub_panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import screen.Screen;
import screen.ScreenFunctions;

public class RemovePanel{
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel();
    private JLabel subtitle = new JLabel();
    private JLabel id_label = new JLabel();
    private JTextField id_text = new JTextField();
    public JButton remove_btn = new JButton();

    public JTextField getId_text() {
        return id_text;
    }
    
    public RemovePanel(int WIDTH, int HEIGHT){

        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, WIDTH, 10*HEIGHT/85-3, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);
        
        ScreenFunctions.label_setup(subtitle, "Remover item", false, 0, HEIGHT/10, WIDTH, HEIGHT/8, panel);
        ScreenFunctions.label_edit(subtitle,new Font("Arial",Font.PLAIN,20),null,Color.WHITE);

        ScreenFunctions.label_setup(id_label, "ID do item que deseja remover:", false, 7*WIDTH/20+40, 4*HEIGHT/10, WIDTH/5, HEIGHT/15, panel);
        ScreenFunctions.label_edit(id_label, new Font("Arial",Font.PLAIN,14), null, Color.WHITE);
        ScreenFunctions.textfield_setup(id_text, "", 11*WIDTH/20+40, 4*HEIGHT/10, WIDTH/25, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(id_text, new Font("Arial",Font.PLAIN,14), new Color(64,64,64), Color.WHITE);
        id_text.setHorizontalAlignment(JTextField.CENTER);

        //OK BUTTON
        ScreenFunctions.button_setup(remove_btn, "Remover!", 4*WIDTH/10, 7*HEIGHT/10, 2*WIDTH/10, HEIGHT/10, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(remove_btn,new Font("Arial",Font.PLAIN,16),new Color(200,200,200),Color.BLACK);
        remove_btn.setFocusable(false);
        remove_btn.setBorder(new LineBorder(new Color(0,0,0), 2));
        
    }

}
