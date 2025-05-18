package listeners;
import database.Item;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import screen.Screen;
import sub_panels.AddPanel;

public class MyActionListener implements ActionListener{

    public static long dayToTimestamp(int day, int month, int year) {
        LocalDate data = LocalDate.of(year, month, day);
        return data.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Screen.getMy_BUTTONSpanel().getADICIONARbutton()){ //ADICIONAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyAddPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyAddPanel().add_btn){ //OK ADICIONAR
            
            AddPanel addPanel = Screen.getMy_CENTERpanel().getMyAddPanel();

            Double preco = null;
            Integer quantidade = null;
            Integer setor = null;
            Integer dia = null;
            Integer mes = null;
            Integer ano = null;   

            //checar variáveis
            if(addPanel.getName().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O nome do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getPreco().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O preço do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getMarca().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A marca do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getValidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A validade do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getQuantidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A quantidade do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getSetor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O setor do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                try {
                    preco = Double.parseDouble(addPanel.getPreco().getText().replace(',','.'));
                    quantidade = Integer.parseInt(addPanel.getQuantidade().getText());
                    setor = Integer.parseInt(addPanel.getQuantidade().getText());
                    if(addPanel.getValidade().getText().length()>=10){
                        dia=Integer.parseInt(addPanel.getValidade().getText().substring(0, 2));
                        mes=Integer.parseInt(addPanel.getValidade().getText().substring(3, 5));
                        ano=Integer.parseInt(addPanel.getValidade().getText().substring(6, 10));
                    
                        boolean successful = false;
                    
                        successful = Queries.adicionar_item(
                            new Item(
                                addPanel.getName().getText(),
                                preco, //Double.parseDouble(addPanel.getPreco().getText()),
                                addPanel.getMarca().getText(),
                                new Date(
                                    dayToTimestamp(
                                        dia, //Integer.parseInt(addPanel.getValidade().getText().substring(0, 2)),
                                        mes, //Integer.parseInt(addPanel.getValidade().getText().substring(3, 5)),
                                        ano //Integer.parseInt(addPanel.getValidade().getText().substring(6, 10))
                                    )
                                ),
                                quantidade, //Integer.parseInt(addPanel.getQuantidade().getText()),
                                setor //Integer.parseInt(addPanel.getSetor().getText())
                            )
                        );

                        if(!successful){
                            JOptionPane.showMessageDialog(null,"Não foi possível inserir o item na base de dados","Erro!",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"O item foi adicionado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                    else{
                        if(dia==null || mes==null || ano==null){JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);}
                    }
                    
                } catch (NumberFormatException error) {
                    if(preco==null){JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);}
                    else if(quantidade==null){JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);}
                    else if(setor==null){JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);}
                }

            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEDITARbutton()){ //EDITAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyEditPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVERbutton()){ //REMOVER

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyRemovePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getTABELAbutton()){ //TABELA

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyTablePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

            try{
                Screen.getMy_CENTERpanel().getMyTablePanel().setitemList(Queries.retorna_tabela());
                Screen.getMy_CENTERpanel().getMyTablePanel().update_table();
            }catch(Exception tableERROR){}

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getBUSCARbutton()){ //BUSCAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySearchPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getORDENARbutton()){ //ORDENAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySortPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEXPORTARbutton()){ //EXPORTAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyExportPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        

    }
    
}
