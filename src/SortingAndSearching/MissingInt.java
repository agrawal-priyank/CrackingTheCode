package SortingAndSearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {

    long numberOfBits = ((long) Integer.MAX_VALUE) + 1;
    byte[] bitField = new byte[(int) (numberOfBits / 8)];
    String fileName = "";

    public void scanFilesAndFindNumber() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileName));
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            bitField[n / 8] |= 1 << (n % 8);
        }
        for(int i = 0; i < bitField.length; i++){
            for(int j = 0; j < 8; j++){
                if((bitField[i] & (1 << j)) == 0){
                    System.out.println(i * 8 + j);
                    break;
                }
            }
        }
    }

}