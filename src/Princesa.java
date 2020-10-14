import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Princesa {

    int posX, posY, velocida, largura, altura;

    int timer;

    private BufferedImage princesaIdle[];
    private int idleAtual;

    public Princesa(){
        posX = 200;
        posY = 350;
        velocida = 5;
        largura = 200;
        altura = 200;



        princesaIdle = new BufferedImage[20];
        idleAtual = 0;

       try {
           for(int i = 0; i < 20; i++){
               String idle = "src/Sprites/Idle (" + (i + 1) + ").png";
               princesaIdle[i] = ImageIO.read(new File(idle));
               System.out.println("Imagens " + idle + "Carregadas");
           }

       } catch(Exception e){
           System.out.println("Imagens idle Não Carregadas");
       }

    }

    public void pintar(Graphics g){
        g.drawImage(princesaIdle[idleAtual], posX, posY, posX + largura, posY + altura, 0, 0, princesaIdle[idleAtual].getWidth(), princesaIdle[idleAtual].getHeight(), null
        );
    }

    public void update(){

        timer++;
        if(timer > 2){
            idleAtual++;
            if(idleAtual == 20){
                idleAtual = 0;
            }
            timer = 0;
        }

    }

}
