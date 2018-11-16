
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        String d = "";

        while (true) {
            System.out.println("What do you want to calculate?"
                    + "\n1: Modulo"
                    + "\n2: Euklid"
                    + "\n3: "
            );

            int input = sc.nextInt();

            switch (input)
            {
                case 1:
                    System.out.println("Modulo Operation Active");
                    System.out.print("Please enter a: ");
                    a = sc.nextInt();
                    System.out.print("Please enter b: ");
                    b = sc.nextInt();

                    // For at find sfd af to tal.
                    sfd(a, b);
                    break;
                case 2:
                    System.out.println("Euklids algoritme Active\n");
                    System.out.print("Please enter a: ");
                    a = sc.nextInt();
                    System.out.print("Please enter b: ");
                    b = sc.nextInt();
                    System.out.print("Hvad sfd skal være lig: ");
                    c = sc.nextInt();
                    euklid(a, b, c);
                    break;
                case 3:

                default:
                    System.out.println("This is not a calculator \n");
                    break;
            }

        }

    }






    // Udregning af Euklids algoritme.
    public static String euklid(int a, int b, int c)
    {
        int[] rk = new int[20];
        rk[0] = a;
        rk[1] = b;
        int k = -1;
        int qk = 0;
        int[] sk = new int[20];
        sk[0] = 1;
        sk[1] = 0;
        int[] tk = new int[20];
        tk[0] = 0;
        tk[1] = 1;
        int i = 0;
        String d = null;
        String konstant = d;

        if (b == 0)
        {
            return Integer.toString(a);
        }

        System.out.println("\n  k  |  qk    rk     sk    tk");
        System.out.println("-----|------------------------");
        System.out.println(" "+k+"  |   -"+"    "+rk[0]+"     "+"1"+"    "+"0"); k++;
        System.out.println("  "+k+"  |   -"+"    "+rk[1]+"      0"+"    "+"1"); k++;
        System.out.println("-----|------------------------");

        for (i = 2; i < rk.length; i++)
        {
            try
            {
                rk[i] = Math.abs(rk[i-2]%rk[i-1]);
            }
            catch (Exception e)
            {
                break;
            }

            qk = Math.floorDiv(rk[i-2], rk[i-1]);

            System.out.print("  "+k+"  |   "+qk+"    "+rk[i]+"      ");

            if (rk[i]!=0)
            {
                sk[i] = sk[i-2]-(qk*sk[i-1]);

                tk[i] = tk[i-2]-(qk*tk[i-1]);
                System.out.println(+sk[i]+"    "+tk[i]);
            }

            k++;
        }

        System.out.println("\n");

        boolean test = (sk[i-2]*a+tk[i-2]*b == c);

        System.out.println("sfd("+a+","+b+") = "+c+" = "+sk[i-2]+"*"+a+"+("+tk[i-2]+"*"+b+")  "+test);

        System.out.println("");

        return Arrays.toString(rk);

    }






    // Udregning af sfd.
    public static String sfd(int a, int b)
    {
        int[] rk = new int[10];
        rk[0] = a;
        rk[1] = b;
        int k = -1;

        if (b == 0)
        {
            return Integer.toString(a);
        }
        System.out.println("\n  k  |  rk  ");
        System.out.println("-----|-----");
        System.out.println("  "+k+"  |  "+rk[0]); k++;
        System.out.println(" "+k+"  |  "+rk[1]); k++;


        for (int i = 2; i < rk.length; i++)
        {
            try
            {
                rk[i] = Math.abs(rk[i-2]%rk[i-1]);
            }
            catch (Exception e)
            {
                break;
            }

            System.out.println("  "+k+"  |  "+rk[i]);
            k++;

        }

        System.out.println("");
        return Arrays.toString(rk);

    }



}


