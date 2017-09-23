package BitManipulation;

public class BinaryToString {

    public static void main(String[] args){
        double num = 0.625;
        BinaryToString bTS = new BinaryToString();
        String res1 = bTS.getBinary(num);
        String res2 = bTS.getBinary2(num);
        System.out.println(res1);
        System.out.println(res2);
    }

    public String getBinary(double num){
        if(num >= 1 || num <= 0){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num > 0){
            if(binary.length() >= 32){
                return "ERROR";
            }
            double r = num * 2;
            if(r >= 1){
                binary.append("1");
                num = r - 1;
            } else{
                binary.append("0");
                num = r;
            }
        }
        return binary.toString();
    }

    public String getBinary2(double num){
        if(num >= 1 || num <= 0){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        double frac = 0.5;
        while(num > 0){
            if(binary.length() >= 32){
                return "ERROR";
            }
            if(num >= frac){
                binary.append("1");
                num -= frac;
            }else{
                binary.append("0");
            }
            frac /= 2;
        }
        return binary.toString();
    }

}