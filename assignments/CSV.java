package week3.assignments;

public class CSV{
    static void parseInventoryRecord(String csvLine){
        String[] b=csvLine.split(",");
        if(b.length==3){
            System.out.println("product" + b[0] + " |SKU:"+ b[1] +"| Qty: "+ b[2]);
        }
        else{
            System.out.println("invalid record");
        }
    }
    public static void main(String[] args){
        String a="Wireless Mouse,WM-2201,150";
        parseInventoryRecord(a);
    }
}
