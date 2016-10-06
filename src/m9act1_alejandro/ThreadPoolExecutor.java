
package m9act1_alejandro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException,
ExecutionException { 
        
    List<Multiplicacio> llistaTasques= new ArrayList<Multiplicacio>();
    
    int delay = 100;
    for (int i = 0; i < 10; i++) {

        Multiplicacio calcula = new Multiplicacio(i,(int)(Math.random()*10),(int)(Math.random()*10),delay);
        System.out.println("Multiplicacio" + i);
        System.out.println("\t" + calcula.num1);
        System.out.println("\t" + calcula.num2);
        llistaTasques.add(calcula);
        delay += 200;
        
    }    

       List<Future<Integer>> llistaResultats = new ArrayList <>();   
         
        Servidor servidor = new Servidor(); 
        for (int i = 0; i < llistaTasques.size(); i++) {
        Future<Integer> future = servidor.ejecutaTarea(llistaTasques.get(i));
        llistaResultats.add(future);
                
            for (Future<Integer> result : llistaResultats) {
                while (!future.isDone()) {
                    System.out.println("Esperaaaaaa" /*+ result*/);
                    Thread.sleep(100);
                };    
            }

        
        }    
     
    servidor.terminaServidor();
     
    
    for (int i = 0; i < llistaResultats.size(); i++) {
        Future<Integer> resultat = llistaResultats.get(i);
        try {
            System.out.println("Resultat tasca "+i+ " és:" + resultat.get()/*+resultat*/);
        } catch (InterruptedException | ExecutionException e) {
        }
    } 
     
    }
    
 
}