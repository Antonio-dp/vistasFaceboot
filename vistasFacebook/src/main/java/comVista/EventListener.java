/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comVista;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import events.ManejadorEventos;
import peticiones.Peticion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Clase que escucha todos los eventos que envia el servidor y decide a quien notificar estos eventos
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class EventListener implements Runnable{
    private int puerto;
    private BufferedReader in;
    private BufferedWriter out;
    private Socket sc;
    private IJsonToObject conversor;
    private static EventListener eventListener;
    
    /**
     * Constructor que inicializa el atributo del puerto 
     * @param puerto Puerto del socket
     */
    public EventListener(int puerto){
        this.puerto = puerto;
        this.conversor = new JsonToObject();
    }
    
    /**
     * Inicializa una objeto de EventListener si este es nulo, 
     * @return Retorna un objeto EventListener
     */
    public static EventListener getInstance(){
        if(eventListener == null){
            eventListener = new EventListener(9000);
        }
        return eventListener;
    }
    
    /**
     * Corre el hilo para que el eventlistener este a la escucha de peticiones
     */
    public void iniciarListener(){
        new Thread(eventListener).start();
    }
    
    /**
     * Hilo donde se reciben las peticiones enviadas por el server y se decide a donde enviarlas
     */
    @Override
    public void run() {
        final String HOST = "127.0.0.1";
        try{
            sc = new Socket(HOST, puerto);
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
            System.out.println("Hola");
            while(true){
                String mensaje = in.readLine();
                if(mensaje == null) break;
                Peticion peticion = conversor.convertirPeticion(mensaje);
                ManejadorEventos.getInstance().get(peticion.getEvento()).notificar(mensaje);
            }
        } catch(IOException ie){
            cerrarTodo(sc, in, out);
        }
    }

    /**
     * Envia un mensaje al servidor
     * @param mensaje mensaje que se le envia el servidor
     */
    public void enviarMensaje(String mensaje){
        try{
                out.write(mensaje);
                out.newLine();
                out.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
        
    }
    
    /**
     * Cierra el socket, BufferedWriter y BufferedReader
     * @param socket Socket del cliente
     * @param in BufferedReader 
     * @param out BufferedWriter
     */
    public void cerrarTodo(Socket socket, BufferedReader in, BufferedWriter out){
        try{
            socket.close();
            in.close();
            out.close();
        } catch(IOException io){
            io.printStackTrace();
        }
        
    }
    
}
