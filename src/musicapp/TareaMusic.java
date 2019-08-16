/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario
 */
public class TareaMusic extends Tarea {
    // Acceso al interfaz
    private VentanaPrincipal VP;
    private boolean IsStoped;
    Semaphore SPause;
    private String cancion;
    
    public void setCancion(String c){
        this.cancion=c;
    }
    
    public TareaMusic(VentanaPrincipal VP){
        IsStoped=false;
        this.VP=VP;
        SPause=new Semaphore(1,true);
    }
            
    // Información que manda a la interfaz
    public void Start(){
        VP.pbCancion.setValue(0);//ponemos el pb a 0
        IsStoped=false;//inicialmente la cancion no está parada
        
        //Ponemos el nombre de la cancion en la label
        VP.lNombreCancion.setText(cancion);
        
        //Ponemos la label de Terminar Cancion activada
        VP.lTerminarCancion.setEnabled(true);
        //Desactivamos la label Reproducor
        VP.lReproducir.setEnabled(false);
        
        //Vaciamos el ta de LetraCancion y escribimos arriba del todo el titulo de la misma
        VP.LC.taLetraCancion.setText(cancion+":\n");
    }
    
    public void Finish(){
        VP.pbCancion.setValue(100);//rellenamos el pb

        // Permitir que se pueda volver a ejecutar
        VP.lReproducir.setEnabled(true);
        VP.lTerminarCancion.setEnabled(false);
    }
    

    public void ProportionExecuted(float p,int segundosActuales, int segundosTotales){
        VP.pbCancion.setValue((int)(p*100));
        
        int horActual=segundosActuales/3600;
        int minActual=(segundosActuales-(3600*horActual))/60;
        int segActual=segundosActuales-((horActual*3600)+(minActual*60));
        
        String horActualString=String.valueOf(horActual);
        String minActualString=String.valueOf(minActual);
        String segActualString;
        if(segActual<=9)
            segActualString="0"+segActual;
        else
            segActualString=String.valueOf(segActual);
        
        int horTotal=segundosTotales/3600;
        int minTotal=(segundosTotales-(3600*horTotal))/60;
        int segTotal=segundosTotales-((horTotal*3600)+(minTotal*60));
        
        String horTotalString=String.valueOf(horTotal);
        String minTotalString=String.valueOf(minTotal);
        String segTotalString;
        if(segTotal<=9)
            segTotalString="0"+segTotal;
        else
            segTotalString=String.valueOf(segTotal);
           
        //Traza
        //System.out.printf("Segundos: %s:%s-%s:%s\n",minActualString,segActualString,minTotalString,segTotalString);
        
        //Modificamos las labels del panel superior
        String ta = String.format("%s:%s", minActualString,segActualString);
        String tt = String.format("%s:%s", minTotalString,segTotalString);
        VP.lTiempoActualCancion.setText(ta);
        VP.lTiempoFinalCancion.setText(tt);
    }
    
    public void Message(String M){
        VP.LC.taLetraCancion.setText(VP.LC.taLetraCancion.getText()+M+"\n");
    }
    
    // Información que el interfaz manda al proceso
    public void setStop(){
        // Indicar un Stop
        this.IsStoped=true;
        
        // si está en pause quitar el pause
        while(SPause.hasQueuedThreads()){
            SPause.release();
            // Duerme 1 ms (para cambiar de hilo)
            try{Thread.sleep(1);}catch(java.lang.InterruptedException E){} 
        }
        SPause.drainPermits(); // Deja la semáforo sin permisos
        SPause.release(); // Deja uno
    }
    public void setPause(){
        try{SPause.acquire();}catch(InterruptedException E){}
        System.out.println("setPause");
    }
    public void setContinue(){
        SPause.release();
        System.out.println("setContinue");
    }
    public boolean PauseStop(){
        System.out.println("PauseStop:"+SPause.availablePermits());
        try{SPause.acquire();}catch(InterruptedException E){}
        SPause.release();
        return IsStoped;
    }
    
}
