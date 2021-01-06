import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryDecimalConvert
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to this fantastic Decimal/Binary number-converter!");
        System.out.println();
        System.out.println("(╯°□°)╯︵ ┻━┻ ");
        scanMainMenu();
    }

    public static void scanMainMenu()
    {
        while(true)
        {
            System.out.println();
            System.out.println("1) Binary -> Decimal conversion");
            System.out.println("2) Decimal -> Binary conversion");
            System.out.println("0) Quit");
            System.out.print("> ");
            String input = scan.nextLine();

            if(input.equals("0"))
            {
                System.out.println("Bye. Thanks for your \"input\" ;)");
                System.exit(0);
            }

            if(!(input.equals("1") || input.equals("2")))
            {
                System.out.println("Wrong input, try again.");
            }

            if(input.equals("1"))
            {
                scanBinaryToDecimalMenu();
            }

            if(input.equals("2"))
            {
                scanDecimalToBinaryMenu();
            }
        }
    }

    private static void scanBinaryToDecimalMenu()
    {
        System.out.print("Binary to Decimal: ");
        try
        {
            String input = scan.nextLine();
            if(Integer.parseInt(input) < 0)
            {
                // Nummer-validering
                // Hvis denne kaster en exception, beder vi bruger om at indtaste nyt binær nummer
                throw new Exception();
            }
            convertDecimal(Integer.parseInt(input));
        }
        catch(Exception e)
        {
            System.out.println("Please enter a correct number");
            System.out.println("Exception: " + e);
        }
        scanMainMenu();
    }

    private static void scanDecimalToBinaryMenu()
    {
        System.out.print("Decimal to Binary: ");
        try
        {
            // Nummer-validering
            // Hvis denne kaster en exception, beder vi bruger om at indtaste nyt decimal nummer
            convertBinary(Integer.parseInt(scan.nextLine()));
        }
        catch(Exception e)
        {
            System.out.println("Please enter a correct number");
        }
        System.out.println();
        scanMainMenu();
    }

    private static void convertBinary(int number)
    {
        // Vi deklarer en ny liste der skal indeholde vores "række" af integers til binary tallet
        ArrayList<Integer> binaryList = new ArrayList<>();

        // Vi laver en while løkke der kører sålænge vores metode parameter "number" er over 0
        while(number > 0)
        {
            // Vi tilføjer vores metode parameter "number" efter vi har lavet modulus 2 på den
            binaryList.add(number % 2);

            // Herefter dividerer vi metode parameter "number" med 2
            number = number / 2;
        }

        // Her bruger vi Collections framework til at gøre vores integer arrayliste i baglæns rækkefølge, da måden vi udregner på, indsætter tallet 'længst til højre' i listen
        Collections.reverse(binaryList);

        // Her laver vi et simpelt for-each loop i vores liste, der printer hver enkelt nummer ud i samme linie
        for(int binaryNumber : binaryList)
        {
            System.out.print(binaryNumber);
        }
    }

    private static void convertDecimal(int binary)
    {
        // Vi deklarer en int variabel, som vi vil bruge til udregne decimal tallet fra binær
        int decimal = 0;

        // Vi deklarerer en int variabel, som skal bruges som counter i vores while-loop
        int i = 0;

        // While loop der kører, sålænge binary-variablen IKKE er 0
        while(binary != 0)
        {
            // Midlertidig variabel, som vi giver værdien binary og kører modulus 10 på.
            int temp = binary % 10;

            // Vi lægger værdien fra udregningen af {temp * ( 2^i)} oven i decimal, tallet vi vil printe til sidst i metoden
            decimal += temp * Math.pow(2, i);

            // Vi dividerer Binary med 10, for at fjerne et ciffer fra tallet
            binary = binary/10;

            // inkrementerer i, som er vores iterator til udregningen
            i++;
        }

        // Print til console med resultatet
        System.out.println("Converted to Decimal: " + decimal);

        // Line space til visuel nydelse :)
        System.out.println();
    }
}
