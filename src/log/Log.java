package log;
//import java.awt.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    private String type;
    private String statement;
    private String timestamp;
    
    public Log(String type, String statement, String timestamp){
        this.type=type;
        this.statement=statement;
        this.timestamp=timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setStatement(String statement) {
        this.statement = statement;
    }
    public String getStatement() {
        return statement;
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