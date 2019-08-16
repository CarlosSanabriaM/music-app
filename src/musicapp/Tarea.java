/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp;

/**
 *
 * @author Usuario
 */
abstract public class Tarea implements SincroForeBack {
    
    // Métodos para especificar la tarea a realizar
    private int SegundosCancion=100;
    private float SegsIte=1.0F;
    
    public void setSegundosCancion(int segs){
        this.SegundosCancion=segs;
    }
    public void setSegsIte(float SegsIte){
        this.SegsIte=SegsIte;    
    }
    
            
    public void Run(){
        System.out.println("Start");
        Start();// Indica que empieza
     
     for(int i=1;i<=SegundosCancion;i++){
        Duerme(); // Simula una tarea no interrumpida
        if(PauseStop()) // El interfaz informa al proceso
            break;  // Fuerza a terminar

        ProportionExecuted(1F*i/SegundosCancion,i,SegundosCancion); // Informar al interfaz
        
        //Tenemos que mostrar la letra de la cancion en otra ventana
        if((i%5)==0)
            Message("Frase"+i/5); // Informar al interfaz
     }
     Finish(); // Indica que termina
    }
    
    // Métodos llamados por Run
    private void Duerme(){
        try{
            Thread.sleep((int)(SegsIte*1000));
        }
        catch(java.lang.InterruptedException E){}
    }
}
