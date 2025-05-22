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

public class AddPanel{
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel();
    private JLabel subtitle = new JLabel();

    private JLabel labelName = new JLabel();
    private JTextField name = new JTextField();
    private JLabel labelPreco = new JLabel();
    private JTextField preco = new JTextField();
    private JLabel labelMarca = new JLabel();
    private JTextField marca = new JTextField();
    private JLabel labelValidade = new JLabel();
    private JTextField validade = new JTextField();
    private JLabel labelQuantidade = new JLabel();
    private JTextField quantidade = new JTextField();
    private JLabel labelSetor = new JLabel();
    private JTextField setor = new JTextField();

    public JButton add_btn = new JButton();

    public JTextField getName() { return name; }
    public JTextField getPreco() { return preco; }
    public JTextField getMarca() { return marca; }
    public JTextField getValidade() { return validade; }
    public JTextField getQuantidade() { return quantidade; }
    public JTextField getSetor() { return setor; }

    public AddPanel(int WIDTH, int HEIGHT){

        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, WIDTH, 10*HEIGHT/85-3, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);
        
        ScreenFunctions.label_setup(subtitle, "Adicionar item", false, 0, HEIGHT/10, WIDTH, HEIGHT/8, panel);
        ScreenFunctions.label_edit(subtitle,new Font("Arial",Font.PLAIN,20),null,Color.WHITE);

        //nome
        ScreenFunctions.label_setup(labelName, "Digite o nome do item: ", false, WIDTH/20, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelName, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelName.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(name, "", WIDTH/4, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(name, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //preco
        ScreenFunctions.label_setup(labelPreco, "Digite o preço do item: ", false, 5*WIDTH/10, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelPreco, labelName.getFont(), null, Color.WHITE);
        labelPreco.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(preco, "", 3*WIDTH/4-WIDTH/20, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(preco, name.getFont(), new Color(64,64,64), Color.WHITE);

        //marca
        ScreenFunctions.label_setup(labelMarca, "Digite a marca do item: ", false, WIDTH/20, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelMarca, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelMarca.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(marca, "", WIDTH/4, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(marca, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //validade
        ScreenFunctions.label_setup(labelValidade, "Digite a validade do item: ", false, 5*WIDTH/10, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelValidade, labelName.getFont(), null, Color.WHITE);
        labelValidade.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(validade, "", 3*WIDTH/4-WIDTH/20, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(validade, name.getFont(), new Color(64,64,64), Color.WHITE);

        //quantidade
        ScreenFunctions.label_setup(labelQuantidade, "Digite a quantidade do item: ", false, WIDTH/20, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelQuantidade, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelQuantidade.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(quantidade, "", WIDTH/4, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(quantidade, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //setor
        ScreenFunctions.label_setup(labelSetor, "Digite o nº do setor do item: ", false, 5*WIDTH/10, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelSetor, labelName.getFont(), null, Color.WHITE);
        labelSetor.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(setor, "", 3*WIDTH/4-WIDTH/20, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(setor, name.getFont(), new Color(64,64,64), Color.WHITE);

        //OK BUTTON
        ScreenFunctions.button_setup(add_btn, "Adicionar!", 4*WIDTH/10, 8*HEIGHT/10, 2*WIDTH/10, HEIGHT/10, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(add_btn,new Font("Arial",Font.PLAIN,16),new Color(200,200,200),Color.BLACK);
        add_btn.setFocusable(false);
        add_btn.setBorder(new LineBorder(new Color(0,0,0), 2));
        
    }

}
