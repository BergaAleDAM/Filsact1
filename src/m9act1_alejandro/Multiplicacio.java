
package m9act1_alejandro;

import java.util.concurrent.Callable;


public class Multiplicacio implements Callable<Integer> {
    int num1, num2;
    
    public Multiplicacio (int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    
    @Override
    public Integer call() throws Exception {
        int multi = num1*num2;
        
        return multi;
    }
}
