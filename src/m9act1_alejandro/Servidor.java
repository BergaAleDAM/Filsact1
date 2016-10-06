
package m9act1_alejandro;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Servidor {
    
    private final ThreadPoolExecutor executor;
    
    
       public Servidor() {  

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3); //Crea el objeto executor con 3 threads

    }
       
    public void terminaServidor () {
        executor.shutdown();
        
    }
       
    public Future<Integer> ejecutaTarea(Multiplicacio multiplicacion) throws InterruptedException{
        Future <Integer>  future= executor.submit(multiplicacion);

        return future;


    }

    

}
