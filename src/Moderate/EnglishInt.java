package Moderate;

import java.util.LinkedList;

public class EnglishInt {

    private String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] bigs = {"", "Thousand", "Million", "Billion"};
    private String hundred = "Hundred";
    private String negative = "Negative";

    public static void main(String[] args){
        int num = 1256789;
        EnglishInt eI = new EnglishInt();
        System.out.println(eI.convert(num));
    }

    public String convert(int num){
        if(num == 0){
            return smalls[0];
        } else if(num < 0){
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<String>();
        int chunkCount = 0;
        while(num > 0){
            if(num % 1000 != 0){
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000;
            chunkCount++;
        }

        return listToString(parts);
    }

    private String convertChunk(int num){
        LinkedList<String> parts = new LinkedList<String>();

        if(num >= 100){
            parts.add(smalls[num / 100]);
            parts.add(hundred);
            num %= 100;
        }

        if(num >= 10 && num <= 19){
            parts.add(smalls[num]);
        } else if (num >= 20){
            parts.add(tens[num / 10]);
            num %= 10;
        }

        if(num >= 1 &&  num <= 9){
            parts.add(smalls[num]);
        }

        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts){
        StringBuilder sb = new StringBuilder();
        while(parts.size() > 1){
            sb.append(parts.remove());
            sb.append(" ");
        }
        sb.append(parts.remove());
        return sb.toString();
    }

}