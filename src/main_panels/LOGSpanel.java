package main_panels;
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
import log.Log;
import screen.ScreenFunctions;

public class LOGSpanel {
    
    private JPanel panel;
    private JPanel panelTABLE = new JPanel();
    private JTable table = new JTable();
    private JLabel titleLABEL = new JLabel();

    private int WIDTH;
    private int HEIGHT;

    private ArrayList<Log> item_list=new ArrayList<>();
    private ArrayList<Object[]> data = new ArrayList<>();

    public JPanel getPanel() {
        return panel;
    }

    public JTable getTable(){
        return table;
    }

    public JPanel getTablePanel(){
        return panelTABLE;
    }

    public ArrayList<Log> getItem_list() {
        return item_list;
    }

    public LOGSpanel(int WIDTH, int HEIGHT){

        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;

        panel = new JPanel();
        panel.setBounds(WIDTH/4, 13*HEIGHT/20, 7*WIDTH/10, HEIGHT/4);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(titleLABEL, "Histórico recente de comandos na base de dados", false, 0, 0, 7*WIDTH/10, 6*HEIGHT/100, panel);
        ScreenFunctions.label_edit(titleLABEL, new Font("Arial",Font.PLAIN,20), null, Color.WHITE);
        panel.add(titleLABEL);

        ScreenFunctions.panel_edit(panelTABLE, true, null);

        update_table();

    }

    public void update_table(){

        table.removeAll();
        panelTABLE.removeAll();
        data.clear();
        
        String[] columns_name = {"Tipo do comando","Comando","Timestamp"};
        int[] columns_width = {WIDTH/20,9*WIDTH/20,WIDTH/20};

        for(Log a : item_list){
            Object item[] = {a.getType(),a.getStatement(),a.getTimestamp()};
            data.add(item);
        }

        DefaultTableModel modelTABLE = new DefaultTableModel(null, columns_name);
        for(int i=0;i<data.size();i++){
            modelTABLE.addRow(data.get(i));
        }
        table = new JTable(modelTABLE);

        table.setPreferredScrollableViewportSize(new Dimension(64*WIDTH/100, HEIGHT/7));
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
        panelTABLE.setBounds(2*WIDTH/100, 6*HEIGHT/100, (int) ((64*WIDTH/100)*1.03), (int) ((HEIGHT/7)*1.20));
        panel.add(panelTABLE);
        
        table.getTableHeader().setBackground(new Color(48,48,48));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setBackground(new Color(64,64,64));
        table.setForeground(Color.WHITE);

    }
    
}
