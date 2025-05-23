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
    private JLabel labelPrice = new JLabel();
    private JTextField price = new JTextField();
    private JLabel labelBrand = new JLabel();
    private JTextField brand = new JTextField();
    private JLabel labelExpiration = new JLabel();
    private JTextField expiration = new JTextField();
    private JLabel labelAmount = new JLabel();
    private JTextField amount = new JTextField();
    private JLabel labelSection = new JLabel();
    private JTextField section = new JTextField();

    public JButton add_btn = new JButton();

    public JTextField getName() { return name; }
    public JTextField getPrice() { return price; }
    public JTextField getBrand() { return brand; }
    public JTextField getExpiration() { return expiration; }
    public JTextField getAmount() { return amount; }
    public JTextField getSection() { return section; }

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
        ScreenFunctions.label_setup(labelName, "Digite o nome: ", false, WIDTH/20, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelName, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelName.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(name, "", WIDTH/4, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(name, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //preco
        ScreenFunctions.label_setup(labelPrice, "Digite o preço: ", false, 5*WIDTH/10, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelPrice, labelName.getFont(), null, Color.WHITE);
        labelPrice.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(price, "", 3*WIDTH/4-WIDTH/20, 3*HEIGHT/10, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(price, name.getFont(), new Color(64,64,64), Color.WHITE);

        //marca
        ScreenFunctions.label_setup(labelBrand, "Digite a marca: ", false, WIDTH/20, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelBrand, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelBrand.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(brand, "", WIDTH/4, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(brand, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //validade
        ScreenFunctions.label_setup(labelExpiration, "Digite a validade: ", false, 5*WIDTH/10, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelExpiration, labelName.getFont(), null, Color.WHITE);
        labelExpiration.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(expiration, "", 3*WIDTH/4-WIDTH/20, 9*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(expiration, name.getFont(), new Color(64,64,64), Color.WHITE);

        //quantidade
        ScreenFunctions.label_setup(labelAmount, "Digite a quantidade: ", false, WIDTH/20, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelAmount, new Font("Arial",Font.PLAIN,16), null, Color.WHITE);
        labelAmount.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(amount, "", WIDTH/4, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(amount, new Font("Arial",Font.PLAIN,16), new Color(64,64,64), Color.WHITE);

        //setor
        ScreenFunctions.label_setup(labelSection, "Digite o nº do setor: ", false, 5*WIDTH/10, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(labelSection, labelName.getFont(), null, Color.WHITE);
        labelSection.setHorizontalAlignment(JLabel.RIGHT);
        ScreenFunctions.textfield_setup(section, "", 3*WIDTH/4-WIDTH/20, 12*HEIGHT/20, 2*WIDTH/10, HEIGHT/15, true, false, panel);
        ScreenFunctions.textfield_edit(section, name.getFont(), new Color(64,64,64), Color.WHITE);

        //OK BUTTON
        ScreenFunctions.button_setup(add_btn, "Adicionar!", 4*WIDTH/10, 8*HEIGHT/10, 2*WIDTH/10, HEIGHT/10, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(add_btn,new Font("Arial",Font.PLAIN,16),new Color(200,200,200),Color.BLACK);
        add_btn.setFocusable(false);
        add_btn.setBorder(new LineBorder(new Color(0,0,0), 2));
        
    }

    public void resetFields(){
        this.name.setText("");
        this.price.setText("");
        this.brand.setText("");
        this.expiration.setText("");
        this.amount.setText("");
        this.section.setText("");
    }

}
