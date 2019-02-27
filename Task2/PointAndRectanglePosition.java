import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PointAndRectanglePosition {
    public static void main(String[] args) {
        try {
            System.out.println("Введите путь до файла ввода");
            Scanner input = new Scanner(System.in);
            String inputName = input.nextLine();
            Scanner inputScanner = new Scanner(new File(inputName));
            double[] x = new double[5];
            double[] y = new double[5];
            for (int i = 0; i < 4; i++) {
                x[i] = inputScanner.nextDouble();
                y[i] = inputScanner.nextDouble();
            }
            double pointX, pointY, pseudoScalar;
            System.out.println("Введите координаты точки");
            pointX = input.nextDouble();
            pointY = input.nextDouble();
            boolean inside = true, onSide = false, outside = false, apex = false;
            for (int i = 0; i < 4; i++) {
                pseudoScalar = (pointX - x[i]) * (y[i + 1] - y[i]) - (pointY - y[i]) * (x[i + 1] - x[i]);
                if (pseudoScalar < 0) {
                    outside = true;
                    inside = false;
                } else {
                    if (pseudoScalar == 0) {
                        inside = false;
                        if (pointX == x[i] && pointY == y[i] || pointX == x[i + 1] && pointY == y[i + 1]) {
                            apex = true;
                        }
                    }
                }
            }
            if (inside){
                System.out.println("точка внутри четырехугольника");
            }else{
                if(outside){
                    System.out.println("точка снаружи четырехугольника");
                }else{
                    if(apex){
                        System.out.println("точка - вершина четырехугольника");
                    }else{
                        System.out.println("точка лежит на сторонах четырехугольника");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
