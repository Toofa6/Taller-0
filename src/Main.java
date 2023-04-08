import java.util.Random;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double min = -1;
        double max = 1;


        //Bordes del area de dibujado
        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);


        double vx = min+(max-min)*Math.random()*0.01;
        double vy = min+(max-min)*Math.random()*0.01;

        //Paleta de Colores
        Color[] colores = {Color.BLACK,Color.BLUE,Color.RED,Color.GREEN,Color.CYAN,Color.pink};
        Color color;



        //Ciclo while
        while (true){
            //Limpiar pantalla
            StdDraw.clear();

            //Largo de la linea de manera aleatoria
            double x = min+(max-min)*Math.random();
            double y = min+(max-min)*Math.random();
            double x2 = x+vx;
            double y2 = y+vy;

            //Sistema de Colisiones
            if(x < -1 || x > 1){
                vx = -vx;
            }
            if(y < -1 || y > 1){
                vy = -vy;
            }
            //Escoger un color aleatorio para la siguiente linea
            StdDraw.setPenColor(colores[(int)(Math.random()*colores.length)]);

            //Dibujar linea
            StdDraw.line(x,y,x2,y2);

            //Guardar la posicion de la primera linea
            x = x2;
            y = y2;

            //Generacion de las demas lineas
            for(int i = 0; i < 5; i++) {
                color = colores[i];
                double x3 = x+vx;
                double y3 = y+vy;

                //Sistema de colisiones
                if(x < -1 || x > 1){
                    vx = -vx;
                }
                if(y < -1 || y > 1){
                    vy = -vy;
                }

                //Seleccion de color de la siguiente linea
                StdDraw.setPenColor(color);
                StdDraw.line(x,y,x3,y3);
                x = x3;
                y = y3;
            }
            //Mostrar en pantalla
            StdDraw.show();
            StdDraw.pause(80);
        }
    }
}