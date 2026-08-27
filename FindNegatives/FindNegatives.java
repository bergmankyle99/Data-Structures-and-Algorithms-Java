import java.util.Random;

public class FindNegatives {


public static void main(String[] args) {
    int []array = new int[10];
    Random rand = new Random();
     for(int i = 0; i < array.length; i++){
          array[i] = rand.nextInt(20)-10;
     }
    System.out.println("Array Position \tValue");
    findNegatives(array, 0);  
           
}
    
public static void findNegatives(int[] array, int pos){

    if(pos != 10){
            
         if(array[pos] < 0)
          {
               System.out.println("#"+(pos) +"\t\t" + array[pos] + " (Negative)"); 
          }
          else
          {
               System.out.println("#"+(pos) +"\t\t" + array[pos]);
          }
        findNegatives(array, pos +1);
        return;
    }      
}
}
    
        
    