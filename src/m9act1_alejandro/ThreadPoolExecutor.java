
package m9act1_alejandro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Esta es la clase principal desde donde accedemos a las otras dos clases 
 * 
 * @author Alejandro
 */
public class ThreadPoolExecutor {

    
    /**
     * Generamos un arraylist para meter las 10 tareas dentro que meteremos con un bucle for
     * los numero de las multiplicaciones serán aleatorios y mientras se van generando se 
     * muestran por pantalla y se añaden al ArrayList
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException 
     */
    public static void main(String[] args) throws InterruptedException,
ExecutionException { 
        
    List<Multiplicacio> llistaTasques= new ArrayList<>();
    
    for (int i = 0; i < 10; i++) {

        Multiplicacio calcula = new Multiplicacio(i,(int)(Math.random()*10),(int)(Math.random()*10));
        System.out.println("Multiplicacio" + i);
        System.out.println("\t" + calcula.num1);
        System.out.println("\t" + calcula.num2);
        llistaTasques.add(calcula);
        
    }    

    /**
     * Este segundo bucle sirve para meter en un ArrayList de Integers de tipo Future el resultado
     * del metodo callable de multiplicaio.java, mientras se va ejecutando no espera a que acabe para continuar con el 
     * siguiente, ya que en metodo de servidor especificamos que trabajará con tres hilos.
     */
       List<Future<Integer>> llistaResultats = new ArrayList <>();   
         
        Servidor servidor = new Servidor(); 
        for (int i = 0; i < llistaTasques.size(); i++) {
        Future<Integer> future = servidor.ejecutaTarea(llistaTasques.get(i));
        llistaResultats.add(future);
            
        /**
         * Hasta que no haya acabado el bucle anterior se mandará un mensaje cada 0.1 segundos que 
         * nos diga que aun no ha acabado
         */
            for (Future<Integer> result : llistaResultats) {
                while (!future.isDone()) {
                    System.out.println("Esperaaaaaa" + result);
                    Thread.sleep(100);
                };    
            }

        
        }    
 
    servidor.terminaServidor();
     
    /**
     * Aqui pasa por cada uno de los datos de la lista de resultados y los muestra
     */
    for (int i = 0; i < llistaResultats.size(); i++) {
        Future<Integer> resultat = llistaResultats.get(i);
        try {
            System.out.println("Resultat tasca "+i+ " és:" + resultat.get());
        } catch (InterruptedException | ExecutionException e) {
        }
    } 
     
    }
    
 
}