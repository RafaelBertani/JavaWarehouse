package mainPanels;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import screen.ScreenFunctions;
import subPanels.AddPanel;
import subPanels.EditPanel;
import subPanels.ExportPanel;
import subPanels.RemovePanel;
import subPanels.SearchPanel;
import subPanels.SortPanel;
import subPanels.TablePanel;

public class CENTERpanel {

    private JPanel panel;
    private JPanel myAddPanel;
    private JPanel myEditPanel;
    private JPanel myRemovePanel;
    private JPanel myTablePanel;
    private JPanel mySearchPanel;
    private JPanel mySortPanel;
    private JPanel myExportPanel;

    private JLabel title = new JLabel();

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getMyAddPanel() {
        return myAddPanel;
    }

    public JPanel getMyEditPanel() {
        return myEditPanel;
    }

    public JPanel getMyRemovePanel() {
        return myRemovePanel;
    }

    public JPanel getMyTablePanel() {
        return myTablePanel;
    }

    public JPanel getMySearchPanel() {
        return mySearchPanel;
    }

    public JPanel getMySortPanel() {
        return mySortPanel;
    }

    public JPanel getMyExportPanel() {
        return myExportPanel;
    }

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
        myAddPanel = new AddPanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        myEditPanel = new EditPanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        myRemovePanel = new RemovePanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        myTablePanel = new TablePanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        mySearchPanel = new SearchPanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        mySortPanel = new SortPanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();
        myExportPanel = new ExportPanel(7*WIDTH/10, 6*HEIGHT/10).getPanel();

    }

}
