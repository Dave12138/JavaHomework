package Test8;

import javax.swing.*;
import java.awt.*;

public class WorldClock {

    private ClockUnit beijingClock;
    private ClockUnit newYorkClock;
    private ClockUnit londonClock;
    private JFrame window;
    public WorldClock(){
        beijingClock=new ClockUnit("北京时间",0);
        newYorkClock=new ClockUnit("纽约时间",-12);
        londonClock=new ClockUnit("伦敦时间",-7);
        window = new JFrame("世界时钟");
        window.setLayout(new FlowLayout());
        window.add(beijingClock);
        window.add(newYorkClock);
        window.add(londonClock);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void go() {
        window.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = window.getSize();

        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;

        window.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
//        window.setLocation(500,500);
        window.setVisible(true);
        beijingClock.boot();
        newYorkClock.boot();
        londonClock.boot();
    }
    
}
