
package m9act1_alejandro;

import java.util.concurrent.Callable;
import java.util.Date;
import java.util.concurrent.ExecutionException;


public class Multiplicacio implements Callable<Integer> {
    int num, num1, num2, delay;
    
    public Multiplicacio (int num, int num1, int num2, int delay) throws InterruptedException{
        this.num = num;
        this.num1 = num1;
        this.num2 = num2;
        Thread.sleep(delay);
    }


    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + "   multiplicaion" + num + ", creado"+ new Date() + "Delay= " + delay);
        try {
            Thread.sleep(delay);
        }catch(InterruptedException e) {  
        }
        
        
        int multi = num1*num2;
        
        return multi;
    }
    
 
}
