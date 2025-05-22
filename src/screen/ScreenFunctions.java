package screen;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import listeners.MyActionListener;

public class ScreenFunctions{

    public static void frame_setup(JFrame frame_name, boolean setVisible, int setDefaultCloseOperation, int width, int height){
        frame_name.setDefaultCloseOperation(setDefaultCloseOperation);
        frame_name.setVisible(true);
        frame_name.setSize(width,height);
    }

    public static void frame_edit(JFrame frame_name, String title, Color back){
        frame_name.setTitle(title);
        if(back!=null){frame_name.getContentPane().setBackground(back);}
    }

    public static void panel_setup(JPanel panel_name, JFrame frame, int x, int y, int width, int height){

        panel_name.setBounds(x,y,width,height);
        panel_name.setLayout(null);
        
        frame.add(panel_name);
        
    }

    public static void panel_on_panel_setup(JPanel panel_name, JPanel panel_do_panel, int x, int y, int width, int height){

        panel_name.setBounds(x,y,width,height);
        panel_name.setLayout(null);
        
        panel_do_panel.add(panel_name);
        
    }

    public static void panel_edit(JPanel panel_name, boolean transparent, Color back){
        if(transparent){panel_name.setOpaque(false); panel_name.setBackground(new Color(0,0,0,64));}
        else{panel_name.setOpaque(true); panel_name.setBackground(back);}
    }

    public static void label_setup(JLabel label_name, String text_label, boolean borda, int x, int y, int width, int height, JPanel label_panel){

        label_name.setText(text_label);
        label_name.setBounds(x, y, width, height);
        if(borda==false){label_name.setBorder(null);}
        else{label_name.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));}
        label_name.setHorizontalAlignment(JLabel.CENTER);
        
        label_panel.add(label_name);

    }
    
    public static void label_edit(JLabel label_name, Font f, Color back, Color fore){
        if(f!=null){label_name.setFont(f);}
        if(back!=null){label_name.setOpaque(true);label_name.setBackground(back);}
        if(fore!=null){label_name.setForeground(fore);}
    }

    public static void textfield_setup(JTextField textfield_name, String textfield_text, int x, int y, int width, int height, boolean editable, boolean border, JPanel textfield_panel){

        textfield_name.setBounds(x, y, width, height);
        textfield_name.setEditable(editable);
        textfield_name.setText(textfield_text);
        if(border==false){textfield_name.setBorder(null);}
        textfield_name.setHorizontalAlignment(JTextField.LEFT); //left

        textfield_panel.add(textfield_name);

    }

    public static void textfield_edit(JTextField textfield_name, Font f, Color back, Color fore){
        if(f!=null){textfield_name.setFont(f);}
        if(back!=null){textfield_name.setBackground(back);}
        if(fore!=null){textfield_name.setForeground(fore);}
    }

    public static void button_setup(JButton button_name, String button_text, int x, int y, int width, int height, MyActionListener actionclass, JPanel panel_button){
        
        button_name.setText(button_text);
        button_name.addActionListener(actionclass);
        button_name.setBounds(x,y,width,height);

        panel_button.add(button_name);

    }

    public static void button_edit(JButton button_name, Font f, Color back, Color fore){
        if(f!=null){button_name.setFont(f);}
        if(back!=null){button_name.setBackground(back);}
        if(fore!=null){button_name.setForeground(fore);}
    }

    public static void combobox_setup(JComboBox<String> combobox_name, int x, int y, int width, int height, int n_of_lines, int initial_item, JPanel combobox_panel){
    
        combobox_name.setMaximumRowCount(n_of_lines);
        combobox_name.setEditable(false);
        combobox_name.setBounds(x,y,width,height);
        combobox_name.setAlignmentX(JComboBox.CENTER_ALIGNMENT); //center
        combobox_name.setSelectedIndex(initial_item);
        
        //centralize
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        combobox_name.setRenderer(dlcr);
        
        combobox_panel.add(combobox_name);
        
    }

    public static void combobox_edit(JComboBox<String> combobox_name, Font f, Color back, Color fore){
        if(f!=null){combobox_name.setFont(f);}
        if(back!=null){combobox_name.setBackground(back);}
        if(fore!=null){combobox_name.setForeground(fore);}
    }
   
    public static void radiobutton_setup(JRadioButton rb_name, String radio_button_text, int x, int y, int width, int height, ButtonGroup bg_name, JPanel ra_panel){
        
        rb_name.setText(radio_button_text);
        rb_name.setBounds(x,y,width,height);    
        
        rb_name.setActionCommand(rb_name.getText());
        
        bg_name.add(rb_name);

        ra_panel.add(rb_name);
    
    }

    public static void radiobutton_edit(JRadioButton nome_rb, Font f, Color back, Color fore){

        if(f!=null){nome_rb.setFont(f);}
        if(back!=null){nome_rb.setBackground(back);}
        if(fore!=null){nome_rb.setForeground(fore);}

    }

}