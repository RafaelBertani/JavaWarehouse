package log;
//import java.awt.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    private int ID;
    private String tipo;
    private String comando;
    private String timestamp;
    
    public Log(String tipo, String comando, String timestamp){
        this.tipo=tipo;
        this.comando=comando;
        this.timestamp=timestamp;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setComando(String comando) {
        this.comando = comando;
    }
    public String getComando() {
        return comando;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getTimestamp() {
        return timestamp;
    }

    public static String current_timestamp(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

        String dataHoraFormatada = agora.format(formatter);
        return dataHoraFormatada;
    }

}