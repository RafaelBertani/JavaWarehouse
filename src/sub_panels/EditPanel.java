package sub_panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import screen.Screen;
import screen.ScreenFunctions;

public class EditPanel{
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel();
    private JLabel subtitle = new JLabel();
    private JLabel id_label = new JLabel();
    private JTextField id_text = new JTextField();
    public  ButtonGroup bg_edit = new ButtonGroup();
    public JRadioButton rb_nome = new JRadioButton();
    public JRadioButton rb_preco = new JRadioButton();
    public JRadioButton rb_marca = new JRadioButton();
    public JRadioButton rb_validade = new JRadioButton();
    public JRadioButton rb_quantidade = new JRadioButton();
    public JRadioButton rb_setor = new JRadioButton();
    private JLabel new_label = new JLabel();
    private JTextField new_text = new JTextField();
    public JButton edit_btn = new JButton();

    public JTextField getId_text() {
        return id_text;
    }

    public JTextField getNew_text() {
        return new_text;
    }
    
    public EditPanel(int WIDTH, int HEIGHT){

        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, WIDTH, 10*HEIGHT/85-3, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);
        
        ScreenFunctions.label_setup(subtitle, "Editar item", false, 0, HEIGHT/10, WIDTH, HEIGHT/8, panel);
        ScreenFunctions.label_edit(subtitle,new Font("Arial",Font.PLAIN,20),null,Color.WHITE);

        ScreenFunctions.label_setup(id_label, "ID do item que deseja editar:", false, 7*WIDTH/20, 3*HEIGHT/10, WIDTH/5, HEIGHT/15, panel);
        ScreenFunctions.label_edit(id_label, new Font("Arial",Font.PLAIN,14), null, Color.WHITE);
        ScreenFunctions.textfield_setup(id_text, "", 11*WIDTH/20, 3*HEIGHT/10, WIDTH/20, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(id_text, new Font("Arial",Font.PLAIN,14), new Color(64,64,64), Color.WHITE);
        id_text.setHorizontalAlignment(JTextField.CENTER);

        int btnWidth = WIDTH / 6;
        int btnHeight = HEIGHT / 10;
        int totalBtnWidth = 3 * btnWidth;
        int startX = (WIDTH - totalBtnWidth) / 2;

        int linhaSuperiorY = 4 * HEIGHT / 10;
        int linhaInferiorY = (int)(5.5 * HEIGHT / 10);

        //nome
        ScreenFunctions.radiobutton_setup(rb_nome, "Nome", startX + 0 * btnWidth, linhaSuperiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_nome, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_nome.setHorizontalAlignment(JRadioButton.CENTER);

        //preço
        ScreenFunctions.radiobutton_setup(rb_preco, "Preço", startX + 1 * btnWidth, linhaSuperiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_preco, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_preco.setHorizontalAlignment(JRadioButton.CENTER);

        //marca
        ScreenFunctions.radiobutton_setup(rb_marca, "Marca", startX + 2 * btnWidth, linhaSuperiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_marca, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_marca.setHorizontalAlignment(JRadioButton.CENTER);

        //validade
        ScreenFunctions.radiobutton_setup(rb_validade, "Validade", startX + 0 * btnWidth, linhaInferiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_validade, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_validade.setHorizontalAlignment(JRadioButton.CENTER);

        //quantidade
        ScreenFunctions.radiobutton_setup(rb_quantidade, "Quantidade", startX + 1 * btnWidth, linhaInferiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_quantidade, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_quantidade.setHorizontalAlignment(JRadioButton.CENTER);

        //setor
        ScreenFunctions.radiobutton_setup(rb_setor, "Setor", startX + 2 * btnWidth, linhaInferiorY, btnWidth, btnHeight, bg_edit, panel);
        ScreenFunctions.radiobutton_edit(rb_setor, new Font("Arial", Font.PLAIN, 14), new Color(32, 32, 32), Color.WHITE);
        rb_setor.setHorizontalAlignment(JRadioButton.CENTER);

        //novo valor
        ScreenFunctions.label_setup(new_label, "Novo valor:", false, 4*WIDTH/10, 7*HEIGHT/10, WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(new_label, new Font("Arial",Font.PLAIN,14), null, Color.WHITE);
        ScreenFunctions.textfield_setup(new_text, "", 5*WIDTH/10, 7*HEIGHT/10, WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(new_text, new Font("Arial",Font.PLAIN,14), new Color(64,64,64), Color.WHITE);
        new_text.setHorizontalAlignment(JTextField.CENTER);
     
        //OK BUTTON
        ScreenFunctions.button_setup(edit_btn, "Editar!", 4*WIDTH/10, 17*HEIGHT/20, 2*WIDTH/10, HEIGHT/10, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(edit_btn,new Font("Arial",Font.PLAIN,16),new Color(200,200,200),Color.BLACK);
        edit_btn.setFocusable(false);
        edit_btn.setBorder(new LineBorder(new Color(0,0,0), 2));

    }

    public void resetFields(){
        id_text.setText("");
        bg_edit.clearSelection();
        new_text.setText("");
    }

}
