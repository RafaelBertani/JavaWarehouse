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
import sub_panels.EditPanel;
import sub_panels.RemovePanel;
import sub_panels.SearchPanel;

public class MyActionListener implements ActionListener{

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

            if(addPanel.getName().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O nome do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getPreco().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O preço do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getMarca().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A marca do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getValidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A validade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(addPanel.getQuantidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A quantidade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
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
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_nome){
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();            
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "nome"));}
        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_preco){

            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{
                if(doubleValido(editPanel.getId_text().getText())){
                    editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "preco"));
                }
            }

        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_marca){
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "marca"));}
        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_validade){
            //verifica data válida
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "validade"));}
        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_quantidade){
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{
                if(inteiroValido(editPanel.getId_text().getText())){
                    editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "quantidade"));
                }
            }

        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_setor){
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();

            if(inteiroValido(editPanel.getId_text().getText())){
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "setor"));
            }
        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyEditPanel().edit_btn){ //OK EDIT
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
    
            if(!inteiroValido(editPanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{
                int id=Integer.parseInt(editPanel.getId_text().getText());
                if(editPanel.rb_nome.isSelected()){
                    Queries.editar_item(id, "nome", editPanel.getNovo_text().getText());
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_preco.isSelected()){
                    Queries.editar_item(id, "preco", editPanel.getNovo_text().getText());
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_marca.isSelected()){
                    Queries.editar_item(id, "marca", editPanel.getNovo_text().getText());
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_validade.isSelected()){
                    Queries.editar_item(id, "validade", editPanel.getNovo_text().getText());                    
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_quantidade.isSelected()){
                    Queries.editar_item(id, "quantidade", editPanel.getNovo_text().getText());                    
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_setor.isSelected()){
                    Queries.editar_item(id, "setor", editPanel.getNovo_text().getText());                    
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVERbutton()){ //REMOVER

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyRemovePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyRemovePanel().remove_btn){ //OK REMOVE
            RemovePanel removePanel = Screen.getMy_CENTERpanel().getMyRemovePanel();
            if(!inteiroValido(removePanel.getId_text().getText())){JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);}
            else{
                Queries.remove_item(Integer.parseInt(removePanel.getId_text().getText()));
                JOptionPane.showMessageDialog(null,"O item foi removido no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getTABELAbutton()){ //TABELA

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyTablePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

            try{
                Screen.getMy_CENTERpanel().getMyTablePanel().setitemList(Queries.retorna_tabela());
                Screen.getMy_CENTERpanel().getMyTablePanel().update_table();
            }catch(Exception tableERROR){tableERROR.printStackTrace();}

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getBUSCARbutton()){ //BUSCAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySearchPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMySearchPanel().src_btn){ //OK BUSCAR
            
            SearchPanel searchPanel = Screen.getMy_CENTERpanel().getMySearchPanel();
            String[] objeto = new String[]{"id","nome","preco","marca","validade","quantidade","setor"};

            if(searchPanel.getVariavel().getSelectedItem().equals("Nome") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O nome do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Preço") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O preço do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Marca") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A marca do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Validade") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A validade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Quantidade") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A quantidade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Setor") && searchPanel.getValor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O setor do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(
                searchPanel.getVariavel().getSelectedItem().equals("Validade") &&
                (searchPanel.getValor().getText().length()!=10 || searchPanel.getValor().getText().substring(0, 2).length()!=2 || searchPanel.getValor().getText().substring(3, 5).length()!=2 || searchPanel.getValor().getText().substring(6, 10).length()!=4)
            ){
                JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Preço") && !doubleValido(searchPanel.getValor().getText())){
                JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);    
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Quantidade") && !inteiroValido(searchPanel.getValor().getText())){
                JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getVariavel().getSelectedItem().equals("Setor") && !inteiroValido(searchPanel.getValor().getText())){
                JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{

                    //arruma a ordem se for data (talvez arruma na base de dados)
                    Screen.getMy_CENTERpanel().getMySearchPanel().setitemList(Queries.retorna_busca(objeto[searchPanel.getVariavel().getSelectedIndex()-1], searchPanel.getOperador().getSelectedItem().toString(), searchPanel.getValor().getText()));
                    Screen.getMy_CENTERpanel().getMySearchPanel().getPanel().setVisible(false);
                    Screen.getMy_CENTERpanel().getMySearchPanel().update_table();
                    Screen.getMy_CENTERpanel().getMySearchPanel().getPanel().setVisible(true);

                    JOptionPane.showMessageDialog(null,"Não foi possível inserir o item na base de dados","Erro!",JOptionPane.ERROR_MESSAGE);

                }catch(Exception searchERROR){searchERROR.printStackTrace();}
            }
        
        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getORDENARbutton()){ //ORDENAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySortPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }

    }

    public static long dayToTimestamp(int day, int month, int year) {
        LocalDate data = LocalDate.of(year, month, day);
        return data.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    public static boolean inteiroValido(String s) {

        boolean ok = false;

        try {
            Integer.parseInt(s.trim());
            ok = true;
        } catch (NumberFormatException e) {
        
        }

        return ok;

    }
    
    public static boolean doubleValido(String s) {
        
        s = s.trim().replace(',', '.');

        return s.matches("^[0-9]+(\\.[0-9]+)?$");

    }

}
