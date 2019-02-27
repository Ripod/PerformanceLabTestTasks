import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NumParser {
    public static void main(String[] args) {
        try {
            System.out.println("Введите путь до файла ввода");
            Scanner inputNameScanner = new Scanner(System.in);
            String inputName = inputNameScanner.nextLine();
            Scanner inputScanner = new Scanner(new File(inputName));
            int numSum = 0;
            List<Integer> numList = new LinkedList<>();
            while (inputScanner.hasNext()) {
                Integer numBuf = inputScanner.nextInt();
                numList.add(numBuf);
                numSum += numBuf;
            }
            numList.sort(null);
            int averageNum = numSum / numList.size();
            double ninetyPerc, median;
            if (numList.size() % 2 == 0) {
                median = ((double) numList.get(numList.size() / 2) + (double) numList.get(numList.size() / 2 - 1)) / 2;
            } else {
                median = (double) numList.get(numList.size() / 2);
            }
            if (numList.size() % 10 == 0) {
                ninetyPerc = ((double) numList.get((int) (numList.size() * 0.9)) + (double) numList.get((int) (numList.size() * 0.9) - 1)) / 2;
            } else {
                ninetyPerc = (double) numList.get((int) (numList.size() * 0.9));
            }
            System.out.println("90 percentile " + ninetyPerc +
                    "\nmedian " + median +
                    "\naverage " + averageNum +
                    "\nmax " + numList.get(numList.size() - 1) +
                    "\nmin " + numList.get(0));
        }catch(FileNotFoundException e){
            System.err.println("File not found");
        }

    }
}
