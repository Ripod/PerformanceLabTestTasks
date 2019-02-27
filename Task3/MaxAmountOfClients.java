import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxAmountOfClients {
    public static void main(String[] args) {
        try {
            System.out.println("Введите пути до файлов ввода, каждый на новой строчке");
            Scanner input = new Scanner(System.in);
            Scanner[] inputScannerArray = new Scanner[5];
            for (int i = 0; i < 5; i++) {
                inputScannerArray[i] = new Scanner(new File(input.nextLine()));
            }
            double currentAmount, maxAmount = 0;
            int startOfMaxPeriod = 0, endOfMaxPeriod = 0;
            boolean prevMaxperiod = false;
            for (int i = 0; i < 16; i++) {
                currentAmount = 0;
                for (int j = 0; j < 5; j++) {
                    currentAmount += inputScannerArray[j].nextDouble();
                }

                if (currentAmount >= maxAmount) {
                    endOfMaxPeriod = i + 1;
                    if (currentAmount > maxAmount || !prevMaxperiod) {
                        maxAmount = currentAmount;
                        startOfMaxPeriod = i;
                    }
                    prevMaxperiod = true;
                }else{
                    prevMaxperiod = false;
                }
            }
            System.out.printf("Максимальное количество клиентов с %d:%02d до %d:%02d", startOfMaxPeriod / 2, startOfMaxPeriod % 2 * 30, endOfMaxPeriod / 2, endOfMaxPeriod % 2 * 30);
        }catch (FileNotFoundException e){
            System.err.println("File not found");
            e.printStackTrace();
        }
    }
}
