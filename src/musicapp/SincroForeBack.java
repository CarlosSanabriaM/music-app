/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp;

/**
 *
 * @author Usuario
 */
public interface SincroForeBack {
    // Lanzar la tarea
    void Run();
    
    // Información que la tarea manda a la interfaz
    void Start(); // Empezó 
    void Finish(); // Terminó 
    void ProportionExecuted(float p,int segundosActuales, int segundoTotales); // Me indica la proporción de su ejecución
    void Message(String M); // Me indica que muestre un mensaje (Nº iteraciones)
    // Indica a la interfaz el nuevo sumando usado y la suma actual

    // Información que el interfaz manda la tarea en tiempo de ejecucion de la tarea
    boolean PauseStop(); // Función bloqueante que fuerza un pause
                         // Si retorna verdadero la tarea debe intentar terminar
    
}
