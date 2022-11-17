package ss13_sorting_algorithms.bai_tap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArr = new int[]{2,4,6,2,1,6,7,8,4,15,3,0,-7,12};
        insertSort(myArr);

    }
    public static void insertSort(int[] array){
        int pos, x;
        System.out.println("Array before sorting:");
        for(int item: array) {
            System.out.print(item+"\t");
        }
        for(int i = 1; i < array.length; i++){
            x = array[i];
            System.out.println("\nTurn "+i+", sort for "+x);
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                System.out.println("Change the position of " + x + " and "+array[pos-1]);
                array[pos] = array[pos-1];
                pos--;
            }
            array[pos] = x;
            System.out.println("Array after this turn:");
            for(int item: array) {
                System.out.print(item+"\t");
            }
        }
    }
}
