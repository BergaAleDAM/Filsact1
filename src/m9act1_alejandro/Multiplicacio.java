
package m9act1_alejandro;

import java.util.concurrent.Callable;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Se crea el método callable para pasarle por parámetro los valores de las multiplicaciones:
 * numero de multiplicaion, y los valores a multiplicar y devolverá el resultado de la multiplicaiocn 
 * @author Alejandro
 */
public class Multiplicacio implements Callable<Integer> {
    int num, num1, num2, delay;
    
    public Multiplicacio (int num, int num1, int num2) throws InterruptedException{
        this.num = num;
        this.num1 = num1;
        this.num2 = num2;
    }

/**
 * Aqui basicamente imprimimos el hilo por el que se ha hecho la operación y decimos cuando la ha hecho
 * @return 
 */
    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + "   multiplicaion" + num + ", creado"+ new Date());
        try {
            Thread.sleep(delay);
        }catch(InterruptedException e) {  
        }
        
        
        int multi = num1*num2;
        
        return multi;
    }
    
 
}
