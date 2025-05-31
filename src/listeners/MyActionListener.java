package listeners;

import database.Item;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import screen.Screen;
import sub_panels.AddPanel;
import sub_panels.EditPanel;
import sub_panels.RemovePanel;
import sub_panels.SearchPanel;
import sub_panels.SortPanel;

public class MyActionListener implements ActionListener{

    /*
     * 
     * Essa é classe que é passada como ActionListener na criação de botões. 
     * Aqui programamos as ações que eles farão ao serem apertados.
     * 
    */

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Screen.getMy_BUTTONSpanel().getADDbutton()){ //ADICIONAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyAddPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyAddPanel().add_btn){ //OK ADICIONAR
            
            AddPanel addPanel = Screen.getMy_CENTERpanel().getMyAddPanel();
            
            // Check if any field is empty
            if(
                addPanel.getName().getText().equals("") ||
                addPanel.getPrice().getText().equals("") ||
                addPanel.getBrand().getText().equals("") ||
                addPanel.getExpiration().getText().equals("") ||
                addPanel.getAmount().getText().equals("") ||
                addPanel.getSection().getText().equals("")
            ){
                JOptionPane.showMessageDialog(null,"Nenhum campo do novo item pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the price is a valid double value (replace comma with dot)
            else if(!doubleValid(addPanel.getPrice().getText().replace(',','.'))){
                JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the quantity is a valid integer
            else if(!integerValid(addPanel.getAmount().getText())){
                JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the sector is a valid integer
            else if(!integerValid(addPanel.getSection().getText())){
                JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the expiration date has a valid format (dd/mm/yyyy)
            else if(!isValidDateFormat(addPanel.getExpiration().getText())){
                JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                try {
                    
                    boolean successful = false;
                
                    successful = Queries.addItem(
                        new Item(
                            addPanel.getName().getText(),
                            Double.parseDouble(addPanel.getPrice().getText().replace(',','.')),
                            addPanel.getBrand().getText(),
                            new Date(
                                dayToTimestamp(
                                    Integer.parseInt(addPanel.getExpiration().getText().split("/")[0]),
                                    Integer.parseInt(addPanel.getExpiration().getText().split("/")[1]),
                                    Integer.parseInt(addPanel.getExpiration().getText().split("/")[2])
                                )
                            ),
                            Integer.parseInt(addPanel.getAmount().getText()),
                            Integer.parseInt(addPanel.getSection().getText())
                        )
                    );

                    if(successful){
                        JOptionPane.showMessageDialog(null,"O item foi adicionado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                        addPanel.resetFields();
                    }
                    else{JOptionPane.showMessageDialog(null,"Não foi possível inserir o item na base de dados","Erro!",JOptionPane.ERROR_MESSAGE);                            }
                    
                } catch (NumberFormatException error) {
                    error.printStackTrace();                    
                }

            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getEDITbutton()){ //EDITAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyEditPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyEditPanel().edit_btn){ //OK EDIT
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();

            int id = Integer.parseInt(editPanel.getId_text().getText());
            String new_value = editPanel.getNew_text().getText();

            if(!integerValid(editPanel.getId_text().getText())){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(editPanel.getNew_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O novo valor não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if( editPanel.rb_preco.isSelected() && !doubleValid(new_value.replace(',','.')) ){
                JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if( editPanel.rb_quantidade.isSelected() && !integerValid(new_value)){
                JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);                
            }
            else if( editPanel.rb_setor.isSelected() && !integerValid(new_value) ) {
                JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(editPanel.rb_validade.isSelected() && !isValidDateFormat(new_value)){
                JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                boolean success = false;

                if(editPanel.rb_nome.isSelected()){
                    success = Queries.editItem(id, "nome", editPanel.getNew_text().getText());
                }
                else if(editPanel.rb_preco.isSelected()){
                    success = Queries.editItem(id, "preco", editPanel.getNew_text().getText().replace(',','.'));
                }
                else if(editPanel.rb_marca.isSelected()){
                    success = Queries.editItem(id, "marca", editPanel.getNew_text().getText());
                }
                else if(editPanel.rb_validade.isSelected()){
                    success = Queries.editItem(id, "validade", convertDateToISO(editPanel.getNew_text().getText()));                    
                }
                else if(editPanel.rb_quantidade.isSelected()){
                    success = Queries.editItem(id, "quantidade", editPanel.getNew_text().getText());                    
                }
                else if(editPanel.rb_setor.isSelected()){
                    success = Queries.editItem(id, "setor", editPanel.getNew_text().getText());                    
                }

                if(success){
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                    editPanel.resetFields();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Não foi possível modificar o item no banco de dados.","Erro!",JOptionPane.ERROR_MESSAGE);
                }

            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVEbutton()){ //REMOVER

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyRemovePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyRemovePanel().remove_btn){ //OK REMOVER
            
            RemovePanel removePanel = Screen.getMy_CENTERpanel().getMyRemovePanel();
            
            if(!integerValid(removePanel.getId_text().getText())){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                Queries.removeItem(Integer.parseInt(removePanel.getId_text().getText()));

                JOptionPane.showMessageDialog(null,"O item foi removido do banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                
                removePanel.resetFields();
            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getTABLEbutton()){ //TABELA

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyTablePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

            try{
                Screen.getMy_CENTERpanel().getMyTablePanel().setItemList(Queries.returnTable());
                Screen.getMy_CENTERpanel().getMyTablePanel().update_table();
            }catch(Exception tableERROR){tableERROR.printStackTrace();}

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getSEARCHbutton()){ //BUSCAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySearchPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMySearchPanel().src_btn){ //OK BUSCAR
            
            SearchPanel searchPanel = Screen.getMy_CENTERpanel().getMySearchPanel();
            String[] object = new String[]{"id","nome","preco","marca","validade","quantidade","setor"};

            String value = searchPanel.getValue().getText();

            if(value.equals("")){
                JOptionPane.showMessageDialog(null,"O campo de busca não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(
                searchPanel.getColumn().getSelectedItem().equals("Validade") && !isValidDateFormat(value)){
                JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getColumn().getSelectedItem().equals("Preço") && !doubleValid(value)){
                JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);    
            }
            else if(searchPanel.getColumn().getSelectedItem().equals("Quantidade") && !integerValid(value)){
                JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getColumn().getSelectedItem().equals("Setor") && !integerValid(value)){
                JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(searchPanel.getColumn().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione algum atributo.","Erro!",JOptionPane.ERROR_MESSAGE);                
            }
            else if(searchPanel.getOperator().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione algum comparador.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{

                    searchPanel.setItemList(
                        Queries.returnSearch(object[searchPanel.getColumn().getSelectedIndex()-1],
                        searchPanel.getOperator().getSelectedItem().toString(),
                        searchPanel.getColumn().getSelectedItem().equals("Validade")?convertDateToISO(value):value)
                    );
                    searchPanel.getPanel().setVisible(false);
                    searchPanel.update_table();
                    searchPanel.getPanel().setVisible(true);

                    JOptionPane.showMessageDialog(null,"Busca realizada com sucesso!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);

                }catch(Exception searchERROR){searchERROR.printStackTrace();}
            }
        
        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getSORTbutton()){ //ORDENAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySortPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMySortPanel().sort_btn){ //OK ORDENAR
            
            SortPanel sortPanel = Screen.getMy_CENTERpanel().getMySortPanel();
            
            if(sortPanel.getOrder().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione se você quer ordem crescente ou descrescente.","Erro!",JOptionPane.ERROR_MESSAGE);                
            }
            else if(sortPanel.getColumn().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione o atributo que você quer ordenar.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] objeto = new String[]{"id","nome","preco","marca","validade","quantidade","setor"};
                sortPanel.setItemList(Queries.sortByColumn(objeto[sortPanel.getColumn().getSelectedIndex()-1], sortPanel.getOrder().getSelectedIndex()==1));
                sortPanel.getPanel().setVisible(false);
                sortPanel.update_table();
                sortPanel.getPanel().setVisible(true);
                JOptionPane.showMessageDialog(null,"Ordenação realizada!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    public static long dayToTimestamp(int day, int month, int year) {
        LocalDate data = LocalDate.of(year, month, day);
        return data.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static boolean isValidDateFormat(String dateStr) {
        // Aceita datas com ou sem zero à esquerda
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        sdf.setLenient(false);

        try {
            java.util.Date date = sdf.parse(dateStr);

            // Após parse, formatar de volta e comparar com original normalizado isso evita aceitar inputs como "9/3/2020abc"
            String normalizedInput = dateStr.trim().replaceAll("^0+", "").replaceAll("/0+", "/");
            String normalizedParsed = sdf.format(date);

            return normalizedInput.equals(normalizedParsed);
        } catch (ParseException e) {
            return false;
        }
    }

    public static String convertDateToISO(String data) {
        // Divide a string usando "/" como separador
        String[] partes = data.split("/");

        // Verifica se tem exatamente 3 partes: dia, mês, ano
        if (partes.length != 3) {
            throw new IllegalArgumentException("Data inválida. Use o formato dd/mm/aaaa.");
        }

        // Extrai dia, mês e ano
        String dia = partes[0];
        String mes = partes[1];
        String ano = partes[2];

        // Adiciona zero à esquerda se necessário (para dia e mês)
        if (dia.length() == 1) dia = "0" + dia;
        if (mes.length() == 1) mes = "0" + mes;

        // Retorna no formato ISO: aaaa/mm/dd
        return ano + "/" + mes + "/" + dia;
    }

    public static String convertDateToBR(String data) {
        // Divide a string usando "-" como separador
        String[] partes = data.split("-");

        // Verifica se tem exatamente 3 partes: ano, mês, dia
        if (partes.length != 3) {
            throw new IllegalArgumentException("Data inválida. Use o formato aaaa/mm/dd.");
        }

        // Extrai ano, mês e dia
        String ano = partes[0];
        String mes = partes[1];
        String dia = partes[2];

        // Adiciona zero à esquerda se necessário (para dia e mês)
        if (dia.length() == 1) dia = "0" + dia;
        if (mes.length() == 1) mes = "0" + mes;

        // Retorna no formato brasileiro: dd/mm/aaaa
        return dia + "/" + mes + "/" + ano;
    }

    public static boolean integerValid(String s) {

        boolean ok = false;

        try {
            Integer.parseInt(s.trim());
            ok = true;
        } catch (NumberFormatException e) {
        
        }

        return ok;

    }
    
    public static boolean doubleValid(String s) {
        
        s = s.trim().replace(',', '.');

        return s.matches("^[0-9]+(\\.[0-9]+)?$");  //formatação de qualquer double possível

    }

}
