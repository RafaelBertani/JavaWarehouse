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
            
            // Check if the item's name field is empty
            if(addPanel.getName().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O nome do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the item's price field is empty
            else if(addPanel.getPreco().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O preço do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the item's brand field is empty
            else if(addPanel.getMarca().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A marca do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the item's expiration date field is empty
            else if(addPanel.getValidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A validade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the item's quantity field is empty
            else if(addPanel.getQuantidade().getText().equals("")){
                JOptionPane.showMessageDialog(null,"A quantidade do item não pode ficar vazia.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the item's sector field is empty
            else if(addPanel.getSetor().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O setor do item não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the price is a valid double value (replace comma with dot)
            else if(!doubleValido(addPanel.getPreco().getText().replace(',','.'))){
                JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the quantity is a valid integer
            else if(!inteiroValido(addPanel.getQuantidade().getText())){
                JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the sector is a valid integer
            else if(!inteiroValido(addPanel.getSetor().getText())){
                JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            // Check if the expiration date has a valid format (dd/mm/yyyy)
            else if(!isValidDateFormat(addPanel.getValidade().getText())){
                JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                try {
                    
                    boolean successful = false;
                
                    successful = Queries.adicionar_item(
                        new Item(
                            addPanel.getName().getText(),
                            Double.parseDouble(addPanel.getPreco().getText().replace(',','.')),
                            addPanel.getMarca().getText(),
                            new Date(
                                dayToTimestamp(
                                    Integer.parseInt(addPanel.getValidade().getText().split("/")[0]),
                                    Integer.parseInt(addPanel.getValidade().getText().split("/")[1]),
                                    Integer.parseInt(addPanel.getValidade().getText().split("/")[2])
                                )
                            ),
                            Integer.parseInt(addPanel.getQuantidade().getText()),
                            Integer.parseInt(addPanel.getSetor().getText())
                        )
                    );

                    if(successful){JOptionPane.showMessageDialog(null,"O item foi adicionado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);}
                    else{JOptionPane.showMessageDialog(null,"Não foi possível inserir o item na base de dados","Erro!",JOptionPane.ERROR_MESSAGE);                            }
                    
                } catch (NumberFormatException error) {
                    error.printStackTrace();                    
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
            
            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "nome"));
            }
        
        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_preco){

            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            
            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "preco"));
            }

        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_marca){
            
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            
            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "marca"));
            }
        
        }
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_validade){

            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();

            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(converterDataParaBR(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "validade")));
            }

        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_quantidade){
            
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();
            
            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "quantidade"));
            }

        } 
        else if(e.getSource() == Screen.getMy_CENTERpanel().getMyEditPanel().rb_setor){
            
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();

            if(!inteiroValido(editPanel.getId_text().getText()) && !editPanel.getId_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                editPanel.getAtual_text().setText(Queries.retorna_valor_especifico(Integer.parseInt(editPanel.getId_text().getText()), "setor"));
            }
            
        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyEditPanel().edit_btn){ //OK EDIT
            EditPanel editPanel = Screen.getMy_CENTERpanel().getMyEditPanel();

            if(!inteiroValido(editPanel.getId_text().getText())){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else if(editPanel.getNovo_text().getText().equals("")){
                JOptionPane.showMessageDialog(null,"O novo valor não pode ficar vazio.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                int id = Integer.parseInt(editPanel.getId_text().getText());
                String new_value = editPanel.getNovo_text().getText();
                
                if(editPanel.rb_nome.isSelected()){
                    Queries.editar_item(id, "nome", editPanel.getNovo_text().getText());
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_preco.isSelected()){
                    if(!doubleValido(new_value.replace(',','.'))){
                        JOptionPane.showMessageDialog(null,"O preço deve conter apenas números\nExemplo: 123 ou 456.78","Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Queries.editar_item(id, "preco", editPanel.getNovo_text().getText());
                        JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(editPanel.rb_marca.isSelected()){
                    Queries.editar_item(id, "marca", editPanel.getNovo_text().getText());
                    JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(editPanel.rb_validade.isSelected()){
                    if(!isValidDateFormat(new_value)){
                        JOptionPane.showMessageDialog(null,"A data de validade deve estar no formato dd/mm/aaaa\nExemplo: 30/08/2014","Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Queries.editar_item(id, "validade", converterDataParaISO(editPanel.getNovo_text().getText()));                    
                        JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(editPanel.rb_quantidade.isSelected()){
                    if(!inteiroValido(new_value)){
                        JOptionPane.showMessageDialog(null,"A quantidade deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Queries.editar_item(id, "quantidade", converterDataParaISO(editPanel.getNovo_text().getText()));                    
                        JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);   
                    }
                }
                else if(editPanel.rb_setor.isSelected()){
                    if(!inteiroValido(new_value)){
                        JOptionPane.showMessageDialog(null,"O setor deve conter apenas números inteiros\nExemplo: 123","Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Queries.editar_item(id, "setor", editPanel.getNovo_text().getText());                    
                        JOptionPane.showMessageDialog(null,"O item foi modificado no banco de dados.","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }

        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getREMOVERbutton()){ //REMOVER

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMyRemovePanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMyRemovePanel().remove_btn){ //OK REMOVER
            
            RemovePanel removePanel = Screen.getMy_CENTERpanel().getMyRemovePanel();
            
            if(!inteiroValido(removePanel.getId_text().getText())){
                JOptionPane.showMessageDialog(null,"O ID deve ser um número inteiro.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
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
                searchPanel.getVariavel().getSelectedItem().equals("Validade") && !isValidDateFormat(searchPanel.getValor().getText())){
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
            else if(searchPanel.getVariavel().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione algum atributo.","Erro!",JOptionPane.ERROR_MESSAGE);                
            }
            else if(searchPanel.getOperador().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione algum comparador.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{

                    searchPanel.setitemList(
                        Queries.retorna_busca(objeto[searchPanel.getVariavel().getSelectedIndex()-1],
                        searchPanel.getOperador().getSelectedItem().toString(),
                        searchPanel.getVariavel().getSelectedItem().equals("Validade")?converterDataParaISO(searchPanel.getValor().getText()):searchPanel.getValor().getText())
                    );
                    searchPanel.getPanel().setVisible(false);
                    searchPanel.update_table();
                    searchPanel.getPanel().setVisible(true);

                    JOptionPane.showMessageDialog(null,"Busca realizada com sucesso!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);

                }catch(Exception searchERROR){searchERROR.printStackTrace();}
            }
        
        }
        else if(e.getSource()==Screen.getMy_BUTTONSpanel().getORDENARbutton()){ //ORDENAR

            Screen.getMy_CENTERpanel().getPanel().setVisible(false);
            Screen.getMy_CENTERpanel().getPanel().removeAll();
            Screen.getMy_CENTERpanel().getPanel().add(Screen.getMy_CENTERpanel().getMySortPanel().getPanel());
            Screen.getMy_CENTERpanel().getPanel().setVisible(true);

        }
        else if(e.getSource()==Screen.getMy_CENTERpanel().getMySortPanel().sort_btn){ //OK ORDENAR
            
            SortPanel sortPanel = Screen.getMy_CENTERpanel().getMySortPanel();
            
            if(sortPanel.getOrdem().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione se você quer ordem crescente ou descrescente.","Erro!",JOptionPane.ERROR_MESSAGE);                
            }
            else if(sortPanel.getColuna().getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Selecione o atributo que você quer ordenar.","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            
            String[] objeto = new String[]{"id","nome","preco","marca","validade","quantidade","setor"};
            sortPanel.setitemList(Queries.ordenar_por_coluna(objeto[sortPanel.getColuna().getSelectedIndex()-1], sortPanel.getOrdem().getSelectedIndex()==1));
            sortPanel.getPanel().setVisible(false);
            sortPanel.update_table();
            sortPanel.getPanel().setVisible(true);

            JOptionPane.showMessageDialog(null,"Ordenação realizada!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
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

    public static String converterDataParaISO(String data) {
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

    public static String converterDataParaBR(String data) {
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
