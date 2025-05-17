import java.awt.Dimension;
import java.awt.Toolkit;
import screen.Screen;

public class Main{

    public static void main(String[] args) {
    
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        if(width<1200 || height<600){
            width=1200;
            height=600;
        }
        
        new Screen(width,height);
    
    }    
}
