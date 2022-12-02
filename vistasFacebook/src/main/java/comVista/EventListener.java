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
 *
 * @author jegav
 */
public class EventListener implements Runnable{
    private int puerto;
    private BufferedReader in;
    private BufferedWriter out;
    private Socket sc;
    private IJsonToObject conversor;
    private static EventListener eventListener;
    
    public EventListener(int puerto){
        this.puerto = puerto;
        this.conversor = new JsonToObject();
    }
    
    public static EventListener getInstance(){
        if(eventListener == null){
            eventListener = new EventListener(9000);
        }
        return eventListener;
    }
    
    public void iniciarListener(){
        new Thread(eventListener).start();
    }
    
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

    public void enviarMensaje(String mensaje){
        try{
                out.write(mensaje);
                out.newLine();
                out.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
        
    }
    
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
