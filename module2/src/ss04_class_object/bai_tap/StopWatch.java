package ss04_class_object.bai_tap;

import java.util.Scanner;

public class StopWatch {
    private long startTime, endTime;

    StopWatch() {
    }

    public long getterStartTime() {
        return startTime;
    }

    public long getterEndTime() {
        return endTime;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        System.out.println("Start time is: " + stopWatch1.getterStartTime());
        System.out.print("Input something to continue ");
        String x = sc.nextLine();
        stopWatch1.stop();
        System.out.println("End time is: " + stopWatch1.getterEndTime());
        System.out.println("Elapsed time is: " + stopWatch1.getElapsedTime() + " milliseconds");
    }
}
