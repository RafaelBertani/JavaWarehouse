package log;
//import java.awt.List;
import java.util.ArrayList;

public class Log {
    
    private int ID;
    private String tipo;
    private String comando;
    private String timestamp;
    
    public Log(int ID, String tipo, String comando, String timestamp){
        this.ID=ID;
        this.tipo=tipo;
        this.comando=comando;
        this.timestamp=timestamp;
    }

    public void setID(int iD) {
        ID = iD;
    }
    public int getID() {
        return ID;
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

    public static ArrayList<Log> retorna(){

        ArrayList<Log> lista = new ArrayList<>();

        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"oi","123","22/1/2025 - 17:12:08"));

        return lista;

    }

    public static ArrayList<Log> retorna_atualizados(){

        ArrayList<Log> lista = new ArrayList<>();

        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));
        lista.add(new Log(0,"olá","456","22/1/2025 - 17:12:08"));

        return lista;

    }

}