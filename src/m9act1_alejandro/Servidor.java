
package m9act1_alejandro;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Servidor {
    
    private final ThreadPoolExecutor executor;
    
    
       public Servidor() {  

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3); //Crea el objeto executor con 3 threads

    }
       
//    public void ejecutaTarea(Tarea tarea){
//        
//    }   
}
