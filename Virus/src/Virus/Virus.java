/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Virus;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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
        setLocationMiddle();
        setContentPane(new VirusPane());
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args){
        while (true)
            new Virus();
    }
    
    private void setLocationMiddle(){
        Dimension screenD = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = (int) screenD.getWidth();
        int screenH = (int) screenD.getHeight();
        
        System.out.println(screenW/2);
        System.out.println(screenH/2);
        System.out.println(VirusPane.WIDTH);
        Point point = new Point(screenW/2  - VirusPane.WIDTH/2, screenH/2 - VirusPane.HEIGHT/2);
        setLocation(point);
    }
}

