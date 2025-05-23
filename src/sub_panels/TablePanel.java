package sub_panels;

import database.Item;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import listeners.MyActionListener;
import screen.ScreenFunctions;

public class TablePanel{
    
    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel();
    private JLabel subtitle = new JLabel();
    private JPanel panelTABLE = new JPanel();
    private JTable table = new JTable();
    private int WIDTH;
    private int HEIGHT;
    private ArrayList<Object[]> data = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();
    
    public ArrayList<Item> getItemList(){
        return this.itemList;
    }

    public void setItemList(ArrayList<Item> i){
        this.itemList=i;
    }
        
    public TablePanel(int WIDTH, int HEIGHT){

        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;

        panel.setBounds(0,0, WIDTH, HEIGHT);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, WIDTH, 10*HEIGHT/85-3, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);
        
        ScreenFunctions.label_setup(subtitle, "Ver tabela de itens", false, 0, HEIGHT/10, WIDTH, HEIGHT/8, panel);
        ScreenFunctions.label_edit(subtitle,new Font("Arial",Font.PLAIN,20),null,Color.WHITE);

        ScreenFunctions.panel_edit(panelTABLE, true, null);

        update_table();

    }

    public void update_table(){

        table.removeAll();
        panelTABLE.removeAll();
        data.clear();

        String[] columnsName = {"ID","Nome","Preço","Marca","Validade","Quantidade","Setor"};
        int[] columnsWidth = {50,100,100,100,100,100,100};

        for(Item i : itemList){
            Object item[] = {i.getId(),i.getNome(),i.getPreco(),i.getMarca(),MyActionListener.convertDateToBR(i.getValidade().toString()),i.getQuantidade(),i.getSetor()};
            data.add(item);
        }

        DefaultTableModel modelTABLE = new DefaultTableModel(null, columnsName);
        for(int i=0;i<data.size();i++){
            modelTABLE.addRow(data.get(i));
        }
        table = new JTable(modelTABLE);

        table.setPreferredScrollableViewportSize(new Dimension(8*WIDTH/10, 3*HEIGHT/5));
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer centralizer = new DefaultTableCellRenderer();
        centralizer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<columnsWidth.length;i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(columnsWidth[i]);
            table.getColumnModel().getColumn(i).setCellRenderer(centralizer);
        }

        panelTABLE.add(table);
        panelTABLE.add(new JScrollPane(table));
        panelTABLE.setBounds(WIDTH/10, HEIGHT/4, (int) ((8*WIDTH/10)*1.03), (int) ((3*HEIGHT/5)*1.20));
        panel.add(panelTABLE);
        
        table.getTableHeader().setBackground(new Color(48,48,48));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setBackground(new Color(64,64,64));
        table.setForeground(Color.WHITE);

    }

}
