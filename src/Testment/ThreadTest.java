package Testment;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        while(true)
        System.out.println(this.getName());
    }

    public static void main(String[] args) {
        var x=new ThreadTest();
        x.setName("p1");
        x.start();
        var y=new ThreadTest();
        y.setName("p2");
        y.start();
        var l = new JButton();
        l.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }
}
