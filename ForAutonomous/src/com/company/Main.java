package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Main extends JComponent{
    Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    int crow = sSize.height/15;
    Rectangle car = new Rectangle(10,sSize.height/2+sSize.height/50,sSize.width/20,sSize.height/15);
    Rectangle car3 = new Rectangle(sSize.width/5, 10,sSize.height/15,sSize.width/20);

    Rectangle car2 = new Rectangle(sSize.width- sSize.width/8,sSize.height/2-sSize.height/11,sSize.width/20,sSize.height/15);
            Timer t = new Timer(10, this:: ActionListener);


    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Variant");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setSize(1000,400);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(sSize.width,sSize.height);
        frame.setLocation(0,0);
        frame.getContentPane().add(new Main());
        frame.setVisible(true);

    }
    public void paint(Graphics painter){
        Graphics2D g = (Graphics2D)painter;
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        BasicStroke pen = new BasicStroke(sSize.width/8);
        BasicStroke line = new BasicStroke(5);
        BasicStroke line2 = new BasicStroke(sSize.width/8);
        g.setStroke(pen);
        g.setColor(Color.gray);
        g.drawLine(0,sSize.height/2,sSize.width,sSize.height/2);
        g.setStroke(line2);
        g.setColor(Color.gray);
        g.drawLine(sSize.width/4, 0 , sSize.width/4, sSize.height);
        g.setStroke(line);
        g.setColor(Color.WHITE);
        for (int i = 0; i< sSize.width;){
            g.drawLine(i,sSize.height/2,i+50,sSize.height/2);
            i = i + 100;
        }

        g.setColor(Color.BLACK);
        g.fill(car);
        g.setColor(Color.BLACK);
        g.fill(car2);
        g.setColor(Color.BLACK);
        g.fill(car3);
        t.start();


    }
    private void ActionListener(ActionEvent actionEvent) {
        int v = 6;
        car.setLocation(car.x+v,car.y);
        car2.setLocation(car2.x-4,car2.y);
        car3.setLocation(car3.x,car3.y+v);
        int x = car.x + sSize.width/10;
        int y = car3.x - sSize.width/20;
        int z = car3.x + sSize.height/5;
        int l = car2.x;
        int w;
        if (car3.y >= (sSize.height/2 - 3*crow)) {
            if (x > y) {
                //System.out.println("Hear " + y + " " + x);
                if (car.x < z-50) { // z
                    car3.setLocation(car3.x, car3.y - v);
                    //System.out.println("car.x " + car.x + " car3.x " + car3.x);
                }
            }
            if (l < z){
                if (car2.x > y){
                    car3.setLocation(car3.x, car3.y - v);
                }
            }
        }
        if (car3.y >= sSize.height){
            car3.setLocation(sSize.width/5, 0);
        }
        if (car.x >= sSize.width){
            car.setLocation(0,sSize.height/2+sSize.height/50);
        }
        repaint();
    }




}
