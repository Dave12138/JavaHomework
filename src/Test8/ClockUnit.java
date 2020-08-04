package Test8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ClockUnit extends JPanel {
    private JLabel time;
    private Calendar clock;
    private JButton pauseButton;
    private int timeInterval;
    private ClockThread thread;

    public ClockUnit(String name, int deltaHour) {
        timeInterval = deltaHour;
        setName(name);

        setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel(" " + name + " ", JLabel.CENTER);
        nameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        add(nameLabel, BorderLayout.NORTH);
        clock = Calendar.getInstance();
        clock.add(Calendar.HOUR, deltaHour);
        time = new JLabel(clock.get(Calendar.HOUR_OF_DAY) + ":" + clock.get(Calendar.MINUTE) + ":" + clock.get(Calendar.SECOND), JLabel.CENTER);
        time.setFont(new Font("微软雅黑", Font.BOLD, 30));
        add(time, BorderLayout.CENTER);
        pauseButton = new JButton("暂停");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(pauseButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        clock.add(Calendar.SECOND, 1);
        time.setText(clock.get(Calendar.HOUR_OF_DAY) + ":" + clock.get(Calendar.MINUTE) + ":" + clock.get(Calendar.SECOND));

    }

    public void setListener(ActionListener l) {
        pauseButton.addActionListener(l);
    }

    public void pause() {
        if (pauseButton.getText().equals("暂停")) {
            pauseButton.setText("开始");
            thread.setWorking(false);
        } else {

            pauseButton.setText("暂停");
            thread.setWorking(true);
        }
    }

    public void boot() {
        thread = new ClockThread(this);
        clock = Calendar.getInstance();
        clock.add(Calendar.HOUR, timeInterval);
        setListener(new MyListener(this));
        thread.setWorking(true);
        thread.start();
    }

    public static void main(String[] args) {
        var f = new JFrame("se");
        var s = new ClockUnit("本地时间", 0);

        f.add(s);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocation(300, 200);
        f.setVisible(true);
        s.boot();
    }

}
