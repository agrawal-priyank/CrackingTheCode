package RecursionAndDynamicProgramming;

import java.util.Arrays;

import static RecursionAndDynamicProgramming.PaintFill.Color.Red;
import static RecursionAndDynamicProgramming.PaintFill.Color.White;

public class PaintFill {

    enum Color {Black, White, Red, Blue, Yellow, Green};

    public static void main(String[] args){
        int r = 5;
        int c = 5;
        Color[][] screen = new Color[r][c];
        for(Color[] row : screen){
            Arrays.fill(row, White);
        }
        PaintFill pF = new PaintFill();
        pF.fillPaint(screen, r - 1, c - 1, White, Red);
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillPaint(Color[][] screen, int r, int c, Color oldColor, Color newColor){
        if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length){
            return;
        }
        if(screen[r][c] == oldColor){
            screen[r][c] = newColor;
            fillPaint(screen, r + 1, c, oldColor, newColor);
            fillPaint(screen, r - 1, c, oldColor, newColor);
            fillPaint(screen, r, c - 1, oldColor, newColor);
            fillPaint(screen, r, c + 1, oldColor, newColor);
        }
    }

}