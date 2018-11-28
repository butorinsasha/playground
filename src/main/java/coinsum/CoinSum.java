package coinsum;

import java.io.*;
import java.util.Random;

public class CoinSum {

    private static File writeToCsvFile(String filename, int[][] res) throws IOException {
        File outputFile = File.createTempFile(filename, ".csv", new File(".\\target\\classes\\coinsum\\"));
//        File outputFile = new File("C:\\Users\\butorin\\Documents\\work\\qa\\coinsum\\res\\coinsum.csv");
        PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)));
        System.out.println("res.length = " + res.length);

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
//        bufferedWriter. // see what can do

        for (int i = 0; i < res.length; i++) {
            printWriter.println(res[i][0] + "," + res[i][1]);
        }

        printWriter.close();
        return outputFile;
    }

    public static void main(String[] args) throws IOException {
	    int sum = 0;
        int maxNumTosses = 10000;
        int h = 100;
//        int maxNumExperiments = 100;

//	    for (int i =0; i < numTosses; i++) {
//            if (Math.random() >= 0.5) {
//                sum++;
//            } else {
//                sum--;
//            }
//        }

        Random generate = new Random();
        int[][] coinArr = new int[maxNumTosses / h + 1][2];
        int n = 0;
        for (int i = 0; i < coinArr.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (generate.nextBoolean()) {
                    sum++;
                } else {
                    sum--;
                }
            }
            coinArr[i][0] = n;
            coinArr[i][1] = sum;
            n += h;
        }

//        System.out.println("numTosses = " + maxNumTosses);
//        System.out.println("sum = " + sum);

        writeToCsvFile("sumcoin", coinArr);



    }
}
