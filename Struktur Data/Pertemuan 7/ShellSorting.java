/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class ShellSorting {

    public int[] data;
    public int jumData;

    public ShellSorting(int Data[]) {
        jumData = Data.length;
        data = Data;
    }

    void tampilData() {
        for (int i = 0; i < jumData; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

    void shellSort() {
        int interval;
        for (interval = jumData / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < jumData; i += 1) {
                System.out.println("i = "+i);
                int temp = data[i];
                int j;
                for (j = i; j >= interval && data[j - interval] > temp; j -= interval) {
                    System.out.println("j = "+j);
                    data[j] = data[j - interval];
                }
                data[j] = temp;
            }
        }
    }
}
