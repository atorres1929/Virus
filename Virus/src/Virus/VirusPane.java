/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Virus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class VirusPane extends JPanel implements KeyListener, Runnable {

    private boolean running;
    public final static int WIDTH = 799;
    public final static int HEIGHT = 800;
    private Thread thread;
    private Graphics2D g;
    private Image image;
    
    private int numberSizeW;
    private int numberSizeH;
    private int correct = 0;
    public VirusPane(){
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
    }
    
    public void addNotify(){
        super.addNotify();
        if (thread == null)
            thread = new Thread(this);     
        
        thread.start();
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        boolean hasChecked = false;
        if (correct == 0 && !hasChecked){
            if (key == KeyEvent.VK_P){
                correct++;
                System.out.println("p");  
                hasChecked = true;
            }
            else
                correct = 0;
        }
        if (correct == 1 && !hasChecked){
            if (key == KeyEvent.VK_A){
                correct++;
                System.out.print("a");
                hasChecked = true;
            }
            else
                correct = 0;
            
        }
        
        if ((correct == 2 || correct == 3) && !hasChecked){
            if (key == KeyEvent.VK_S){
                correct++;
                System.out.print("s");
                hasChecked = true;
            }
            else
                correct = 0;
        }
        
        if (correct == 4 && !hasChecked){
            if (key == KeyEvent.VK_W){
                correct++;
                System.out.println("w");
                hasChecked = true;
            }
            else
                correct = 0;
        }
        
        if (correct == 5 && !hasChecked){
            if (key == KeyEvent.VK_O){
                correct++;
                System.out.println("o");
                hasChecked = true;
            }
            else
                correct = 0;
        }
        
        if (correct == 6 && !hasChecked){
            if (key == KeyEvent.VK_R){
                correct++;
                System.out.println("r");
                hasChecked = true;
            }
            else
                correct = 0;
        }
        
        if (correct == 7 && !hasChecked){
            if (key == KeyEvent.VK_D){
                correct++;
                System.out.println("d");
                hasChecked = true;
            }
            else
                correct = 0;
        }
        
    }

    @Override
    public void run() {
        
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        getNumberSizes();
        
//        int FPS = 30;
//        long start, now, elapsedTime;
//        long targetTime = 1000000000/FPS;
//        long waitTime=0;
//        long totalTime = 0;
        while (running){
            render();
            draw();
            if (correct == 8)
                System.exit(0);
//            
//            now = System.nanoTime();
//            elapsedTime = now-start;
//            waitTime = targetTime - elapsedTime;
//            try{
//                Thread.sleep(waitTime/1000000);
//            }catch(Exception e){}
        }

    }
    
    private void render(){         
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, WIDTH, HEIGHT);
       drawTheMatrix();
    }
    
    private void draw(){
        Graphics2D g2 = (Graphics2D) this.getGraphics();    
        g2.drawImage(image, 0,0, WIDTH, HEIGHT, null);
        g2.dispose();
    }
    
    private void drawTheMatrix(){
        g.setColor(Color.GREEN);
        Random gen = new Random(); 
        String current = String.valueOf(gen.nextInt(10));
        int xCoord = 0, yCoord = 0;
        
        for (int i = 0; i < HEIGHT; i+= numberSizeH){
            
            for (int j = 0; j < WIDTH; j+=numberSizeW){
                int num = gen.nextInt(10);
                current += String.valueOf(num);
            }
            g.drawString(current,xCoord, yCoord+=numberSizeH);
        }
       
        
    }
    
    private void getNumberSizes(){  
        int largestW = 0, largestH = 0;
        for(int i = 0; i < 10; i++){
            int currW = (int) Math.ceil(g.getFontMetrics().getStringBounds(Integer.toString(i), g).getWidth());
            int currH = (int) Math.ceil(g.getFontMetrics().getStringBounds(Integer.toString(i), g).getHeight());
            if (largestW < currW)
                numberSizeW = currW;
            if (largestH < currH)
                numberSizeH = currH;
        }
    }

}
    
