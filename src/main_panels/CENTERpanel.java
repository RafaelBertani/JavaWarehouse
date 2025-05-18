package main_panels;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import screen.ScreenFunctions;
import sub_panels.AddPanel;
import sub_panels.EditPanel;
import sub_panels.ExportPanel;
import sub_panels.RemovePanel;
import sub_panels.SearchPanel;
import sub_panels.SortPanel;
import sub_panels.TablePanel;

public class CENTERpanel {

    private JPanel panel;
    private AddPanel myAddPanel;
    private EditPanel myEditPanel;
    private RemovePanel myRemovePanel;
    private TablePanel myTablePanel;
    private SearchPanel mySearchPanel;
    private SortPanel mySortPanel;
    private ExportPanel myExportPanel;

    private JLabel title = new JLabel();

    public JPanel getPanel() {
        return panel;
    }

    public AddPanel getMyAddPanel() { return myAddPanel; }
    public EditPanel getMyEditPanel() { return myEditPanel; }
    public RemovePanel getMyRemovePanel() { return myRemovePanel; }
    public TablePanel getMyTablePanel() { return myTablePanel; }
    public SearchPanel getMySearchPanel() { return mySearchPanel; }
    public SortPanel getMySortPanel() { return mySortPanel; }
    public ExportPanel getMyExportPanel() { return myExportPanel; }

    public CENTERpanel(int WIDTH, int HEIGHT){

        panel = new JPanel();
        panel.setBounds(WIDTH/4, HEIGHT/40, 7*WIDTH/10, 6*HEIGHT/10);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(32,32,32));
        panel.setBorder(new LineBorder(new Color(0,0,172), 2));

        ScreenFunctions.label_setup(title, "Gerenciamento do armazém", false, 0, 0, 7*WIDTH/10, HEIGHT/15, panel);
        ScreenFunctions.label_edit(title,new Font("Arial",Font.PLAIN,25),null,Color.WHITE);

        //instancia todos os subpanels para futuro uso
        myAddPanel = new AddPanel(7*WIDTH/10, 6*HEIGHT/10);
        myEditPanel = new EditPanel(7*WIDTH/10, 6*HEIGHT/10);
        myRemovePanel = new RemovePanel(7*WIDTH/10, 6*HEIGHT/10);
        myTablePanel = new TablePanel(7*WIDTH/10, 6*HEIGHT/10);
        mySearchPanel = new SearchPanel(7*WIDTH/10, 6*HEIGHT/10);
        mySortPanel = new SortPanel(7*WIDTH/10, 6*HEIGHT/10);
        myExportPanel = new ExportPanel(7*WIDTH/10, 6*HEIGHT/10);

    }

}
