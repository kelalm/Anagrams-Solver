import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);  // Reading from System.in

        System.out.println("Enter 6 or 7 letters: ");


        String entered = scan.nextLine();

        char[] puzzle = new char[entered.length()];


        for (int i = 0; i < entered.length(); i++) {
            puzzle[i] = entered.charAt(i);
        }

        //once finished
        scan.close();

        System.out.println(Arrays.toString(puzzle));


        System.out.println();
        System.out.println("LETS GO");

        permute(entered);

        System.out.println("Size of all combinations found");
        System.out.println(arrli.size());

        //traverse the arraylist and compare it to the text file


        String[] combinations = arrli.toArray(new String[0]);

        System.out.println(Arrays.toString(combinations));


        //Read file and compare to string array

        String currentLine;


        HashSet<String> hs = new HashSet<String>();

        createHashFromFile(hs);

        for(int i = 0; i < combinations.length; i++){

            powerSet(combinations[i]);

        }

        String[] finalSearch = all.toArray(new String[0]);

        for(int i = 0; i < finalSearch.length; i++){

            findWordInText(finalSearch[i], hs);
        }


        for (String s : answerKey) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("7 letters: " );
        for (String s : answerKey) {
            if(s.length() == 7){
                System.out.print(s + " ");
            }
        }


        System.out.println();


        System.out.println("6 letters: " );
        for (String s : answerKey) {
            if(s.length() == 6){
                System.out.print(s + " ");
            }
        }

        System.out.println();

        System.out.println("5 letters: ");
        for (String s : answerKey) {
            if(s.length() == 5){
                System.out.print(s + " ");
            }
        }

        System.out.println();


        System.out.println("4 letters: ");
        for (String s : answerKey) {
            if(s.length() == 4){
                System.out.print(s + " ");
            }
        }

        System.out.println();


        System.out.println("3 letters: ");
        for (String s : answerKey) {
            if(s.length() == 3){
                System.out.print(s + " ");
            }
        }



        //System.out.println(answerKey.size());

    }

    static void createHashFromFile(HashSet<String> hs) throws Exception{
        String currentLine;
        //BufferedReader reader = new BufferedReader(new FileReader("anagramssolutionkeyfinal.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("engmix.txt"));

        while((currentLine = reader.readLine()) != null){
            hs.add(currentLine);
        }

        reader.close();
    }

    static void findWordInText(String s, HashSet<String> hs) throws Exception{

        if(hs.contains(s) && !answerKey.contains(s)){
            answerKey.add(s);
        }

    }

    static ArrayList<String> arrli = new ArrayList<String>();
    static ArrayList<String> answerKey = new ArrayList<String>();
    static ArrayList<String> all = new ArrayList<String>();



    static void permuteHelper(String s, String chosen){
        //System.out.println("permuteHelper(" + s + ", " + chosen + ")");

        if(s.isEmpty()){
            arrli.add(chosen);

        } else {
            //choose / explore / unchoose
            for(int i = 0; i < s.length(); i++){
                //choose
                char c = s.charAt(i);

                chosen += c;
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);

                s = sb.toString();

                //explore
                permuteHelper(s, chosen);

                //un-choose\
                StringBuilder sb2 = new StringBuilder(s);

                sb2.insert(i, c);

                s = sb2.toString();

                StringBuilder sb3 = new StringBuilder(chosen);
                sb3.deleteCharAt(chosen.length()-1);
                chosen = sb3.toString();

            }

        }
    }


    static void permute(String s){
        permuteHelper(s, "");
    }

    static void powerSet(String input){

        for (int i = 1; i <(int) Math.pow(2,input.length()) ; i++) {

            String eleman = "";
            int arrayindex = 0;

            for (int k = input.length() -1; k >= 0; k--) {

                String index = ((i >> k) & 1) == 1 ? "1" : "0";

                if(index == "1"){
                    eleman += input.charAt(arrayindex);
                }
                arrayindex++;
            }

            all.add(eleman);
        }
    }

}
