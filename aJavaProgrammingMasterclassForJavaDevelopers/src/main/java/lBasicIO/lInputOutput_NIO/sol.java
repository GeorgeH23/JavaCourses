package lBasicIO.lInputOutput_NIO;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class sol {

    public static void main(String[] args) throws IOException {
        /*try(BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            InputStreamReader isr =  new InputStreamReader(new BufferedInputStream(new FileInputStream("file.txt")));
            OutputStreamWriter osr = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("file.txt")));
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("file.dat")));
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("file.dat")));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("file.dat")));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("file.dat")));
            RandomAccessFile raf = new RandomAccessFile("file_random.txt", "rwd")) {


        }*/

        int[][] a = new int[6][6];
        int maxSum = Integer.MIN_VALUE;
        try (Scanner scanner = new Scanner(System.in))
        {
            int count=0;
            for(int i = 0; i < 6; i++)
            {
                for(int j = 0; j < 6; j++)
                {
                    System.out.println("Introduceti elementul:");
                    a[i][j] = scanner.nextInt();
                    if (i > 1 && j > 1)
                    {
                                 int sum =
                                         a[i][j] + a[i][j-1] + a[i][j-2]

                                                 + a[i-1][j-1]

                                        + a[i-2][j] + a[i-2][j-1] + a[i-2][j-2];

                        String[][] patern = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}} ;
                        patern[2][2] =""+ a[i][j];
                        patern[2][1] =""+ a[i][j-1];
                        patern[2][0] =""+ a[i][j-2];

                        patern[1][1] =""+ a[i-1][j-1];

                        patern[0][2] =""+ a[i-2][j];
                        patern[0][1] =""+ a[i-2][j-1];
                        patern[0][0] =""+ a[i-2][j-2];

                        for (String[] mtrx : patern){
                            System.out.println(mtrx[0] + " " + mtrx[1] + " " + mtrx[2]);
                        }
                        System.out.println("Pattern " + ++count + ": " + sum);
                        if (sum > maxSum) {maxSum = sum;}
                        for (int[] mtrx : a){
                            System.out.println(Arrays.toString(mtrx));
                        }
                    }
                }
            }
        }
        for (int[] mtrx : a){
            System.out.println(Arrays.toString(mtrx));
        }
        System.out.println("Suma maxima este: " + maxSum);
    }
}