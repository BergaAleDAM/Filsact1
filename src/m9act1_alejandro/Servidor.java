
package m9act1_alejandro;


import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Servidor {
    
    private final ThreadPoolExecutor executor;
    
    /**
     * Usamos un executor con el .newFixedThreadPool para fijar la cantidad de hilos que vamos a usar.
     */
       public Servidor() {  

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3); //Crea el objeto executor con 3 threads

    }
       
    /**
     * Con este método cerramos el executor
     */   
    public void terminaServidor () {
        executor.shutdown();
        
    }
    
    /**
     * 
     * Este método nos hará un submit, que es basicamente que está haciendo la tarea 
     * mandada desde el ThreadPoolExecutor que hace referencia al metodo callable.
     * Basicamente añadimos a cada multiplicacion un Integer de tipo Future
     * @param multiplicacion
     * @return
     * @throws InterruptedException 
     */
    public Future<Integer> ejecutaTarea(Multiplicacio multiplicacion) throws InterruptedException{
        Future <Integer>  future= executor.submit(multiplicacion);

        return future;


    }

    

}
