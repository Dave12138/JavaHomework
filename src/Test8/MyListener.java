package Test8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
    ClockUnit clock;

    MyListener(ClockUnit clock) {
        this.clock = clock;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clock.pause();
    }
}