/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Virus;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Adam
 */

public class Virus extends JFrame{

    public Virus(){
        setTitle("Matrix");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRandom();
        setContentPane(new VirusPane());
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Virus();
    }
    
    private void setLocationRandom(){
        Random random = new Random();
        Dimension screenD = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = (int) screenD.getWidth();
        int screenH = (int) screenD.getHeight();
        
        Point point = new Point(random.nextInt(screenW)  - VirusPane.WIDTH/2, random.nextInt(screenH) - VirusPane.HEIGHT/2);
        setLocation(point);
    }
}

