package Test8;

public class ClockThread extends Thread {
    private ClockUnit clock;
    private boolean working;
    ClockThread(ClockUnit clock){
        this.clock=clock;
    }

    @Override
    public void run() {
        System.out.println("run");
        while (true) {
            try {
                sleep(1000);
                if (working) {
                    clock.refresh();
                    System.out.println("tick("+clock.getName()+")");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
