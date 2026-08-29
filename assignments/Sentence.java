package week3.assignments;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Sentence{
    static String reversetheword(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseword = new StringBuilder(word);
            result.append(reverseword.reverse());
            result.append(" ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a sentence");
        String a=sc.nextLine();
        String output = reversetheword(a);
        System.out.println(output);
    }
}
