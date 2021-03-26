package bug;
import java.util.Random;

public class bug {
    static int check(int[][] buggy)
    {
        int cnt=0;
        for(int i=0; i<buggy.length;i++)
        {
            for(int j=0; j<buggy[0].length;j++)
            {
                if (buggy[i][j]>=1)
                {
                    cnt++;
                }
            }
        }

        return cnt;

    }
    static void show(int[][] buggy)
    {
        for(int i=0; i<buggy.length;i++)
        {
            for(int j=0; j<buggy[0].length;j++)
            {
                System.out.printf("%3d",buggy[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    static void move(int[][] buggy)
    {
        Random rand = new Random();
        int offset=0;
        int row=0,col=0;
        int cnt=0;

        while(true)
        {
            cnt++;
            show(buggy);
            offset = rand.nextInt(8)+1;
            if (check(buggy) == buggy.length * buggy[0].length) {
                System.out.println("loop: "+cnt);
                break;
            }
            if (offset==1 && col<11)
            {
                col++;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==2 && col<11 && row>=1)
            {
                col++;
                row--;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==3 &&row>=1)
            {
                row--;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==4 && row>=1 && col>=1)
            {
                row--;
                col--;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==5 && col>=1)
            {
                col--;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==6 && col>=1 && row<11)
            {
                col--;
                row++;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==7 && row<11)
            {
                row++;
                buggy[row][col]+=1;
                continue;
            }
            if (offset==8 && col<11 && row<11)
            {
                col++;
                row++;
                buggy[row][col]+=1;
            }
        }

    }

    public static void main(String[] args)
    {
        int [][]buggy = new int [12][12];
        move(buggy);
    }
}