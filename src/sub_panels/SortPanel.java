package sub_panels;

import database.Item;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import listeners.MyActionListener;
import screen.Screen;
import screen.ScreenFunctions;

public class SortPanel{
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel();
    private JLabel subtitle = new JLabel();
    private JLabel ordem_label = new JLabel();
    private JLabel coluna_label = new JLabel();
    private JComboBox<String> ordem = new JComboBox<>(new String[]{"--Ordem--","Crescente","Descrescente"});
    private JComboBox<String> coluna = new JComboBox<>(new String[]{"--Coluna--","ID","Nome","Preço","Marca","Validade","Quantidade","Setor"});
    private JPanel panelTABLE = new JPanel();
    private JTable table = new JTable();
    private int WIDTH;
    private int HEIGHT;
    private ArrayList<Object[]> data = new ArrayList<>();
    private ArrayList<Item> item_list = new ArrayList<>();
    private String[] columns_name = {"ID","Nome","Preço","Marca","Validade","Quantidade","Setor"};
    private int[] columns_width = {50,100,100,100,100,100,100};
    public JButton sort_btn = new JButton();

    public ArrayList<Item> getItemList(){
        return this.item_list;
    }

    public void setitemList(ArrayList<Item> i){
        this.item_list=i;
    }

    public JComboBox<String> getOrdem() {
        return ordem;
    }

    public JComboBox<String> getColuna() {
        return coluna;
    }

    public SortPanel(int WIDTH, int HEIGHT){

        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;

        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, WIDTH, 10*HEIGHT/85-3, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);
        
        ScreenFunctions.label_setup(subtitle, "Ordenar itens", false, 0, HEIGHT/10, WIDTH, HEIGHT/8, panel);
        ScreenFunctions.label_edit(subtitle,new Font("Arial",Font.PLAIN,20),null,Color.WHITE);

        ScreenFunctions.label_setup(ordem_label, "Ordenar os itens em ordem", false, 3*WIDTH/20, 3*HEIGHT/10, WIDTH/5, HEIGHT/15, panel);
        ScreenFunctions.label_edit(ordem_label, new Font("Arial",Font.PLAIN,14), null, Color.WHITE);
        ScreenFunctions.combobox_setup(ordem, 7*WIDTH/20, 3*HEIGHT/10, 3*WIDTH/20, HEIGHT/15, 3, 0, panel);
        ScreenFunctions.combobox_edit(ordem, new Font("Arial",Font.PLAIN,14), new Color(64,64,64), Color.WHITE);
        ScreenFunctions.label_setup(coluna_label, "de acordo com a coluna", false, (int)(5*WIDTH/10*1.05), 3*HEIGHT/10, 3*WIDTH/20, HEIGHT/15, panel);
        ScreenFunctions.label_edit(coluna_label, new Font("Arial",Font.PLAIN,14), null, Color.WHITE);
        ScreenFunctions.combobox_setup(coluna, 7*WIDTH/10, 3*HEIGHT/10, 3*WIDTH/20, HEIGHT/15, 8, 0, panel);
        ScreenFunctions.combobox_edit(coluna, new Font("Arial",Font.PLAIN,14), new Color(64,64,64), Color.WHITE);
        
        //OK SORT
        ScreenFunctions.button_setup(sort_btn, "Ordenar!", WIDTH/2-WIDTH/10, 17*HEIGHT/20, WIDTH/5, HEIGHT/10, Screen.myActionListener, panel);
        ScreenFunctions.button_edit(sort_btn,new Font("Arial",Font.PLAIN,16),new Color(200,200,200),Color.BLACK);
        sort_btn.setFocusable(false);
        sort_btn.setBorder(new LineBorder(new Color(0,0,0), 2));

        ScreenFunctions.panel_edit(panelTABLE, true, null);

        update_table();
        
    }

    public void update_table(){

        table.removeAll();
        panelTABLE.removeAll();
        data.clear();

        for(Item i : item_list){
            Object item[] = {i.getId(),i.getNome(),i.getPreco(),i.getMarca(),MyActionListener.convertDateToBR(i.getValidade().toString()),i.getQuantidade(),i.getSetor()};
            data.add(item);
        }

        DefaultTableModel modelTABLE = new DefaultTableModel(null, columns_name);
        for(int i=0;i<data.size();i++){
            modelTABLE.addRow(data.get(i));
        }
        table = new JTable(modelTABLE);

        table.setPreferredScrollableViewportSize(new Dimension(8*WIDTH/10, 3*HEIGHT/10));
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centralizer = new DefaultTableCellRenderer();
        centralizer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<columns_width.length;i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(columns_width[i]);
            table.getColumnModel().getColumn(i).setCellRenderer(centralizer);
        }

        panelTABLE.add(table);
        panelTABLE.add(new JScrollPane(table));
        panelTABLE.setBounds(WIDTH/10, 9*HEIGHT/20, (int) ((8*WIDTH/10)*1.03), (int) ((3*HEIGHT/10)*1.20));
        panel.add(panelTABLE);
        
        table.getTableHeader().setBackground(new Color(48,48,48));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setBackground(new Color(64,64,64));
        table.setForeground(Color.WHITE);

    }

}
