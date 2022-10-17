package ss04_class_object.bai_tap;

import java.util.Random;

public class StopWatch {
    private long startTime, endTime;

    StopWatch() {
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(300000) + 1;
        }
        System.out.println("Bat dau tinh gio");
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        System.out.println("Start time is: " + stopWatch1.getterStartTime());
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        stopWatch1.stop();
        System.out.println("Mang da sap xep:");
        System.out.println("End time is: " + stopWatch1.getterEndTime());
        System.out.println("Elapsed time is: " + stopWatch1.getElapsedTime() + " milliseconds");
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
}
