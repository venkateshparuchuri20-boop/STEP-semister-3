package week3.assignments;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Atm{
    int pin;
    Atm(int pin){
        this.pin=pin;
    }
    void checkPinlength(){
        if(String.valueOf(pin).length()==4){
            System.out.println("valid pin");
        }
        else{
            System.out.println("not a valid pin");
        }
    }
    public static void main(String[] args){
        System.out.println("enter 4 digit UPI pin");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Atm b=new Atm(a);
        b.checkPinlength();
    }
}
