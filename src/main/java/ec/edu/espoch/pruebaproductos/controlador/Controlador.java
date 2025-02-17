/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.pruebaproductos.controlador;

import ec.edu.espoch.pruebaproductos.modelo.GestorProductos;
import ec.edu.espoch.pruebaproductos.modelo.Producto;
import ec.edu.espoch.pruebaproductos.vista.Disponibles;
import ec.edu.espoch.pruebaproductos.vista.NoDisponibles;
import ec.edu.espoch.pruebaproductos.vista.Vista;
import javax.swing.JOptionPane;

public class Controlador {

    private Vista vista;
    private GestorProductos gestorProductos;
    private Disponibles disponiblesFrame;
    private NoDisponibles noDisponiblesFrame;

    public Controlador(Vista vista, GestorProductos gestorProductos) {
        this.vista = vista;
        this.gestorProductos = gestorProductos;
        this.disponiblesFrame = new Disponibles();
        this.noDisponiblesFrame = new NoDisponibles();
    }

    public void agregarProducto() {

        String nombre = vista.getNombre();
        String precio = vista.getPrecio();
        boolean disponible = vista.isDisponible();

        if (nombre.isEmpty() || precio.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto producto = new Producto(0, nombre, precio, disponible);
        String mensaje = gestorProductos.agregarProducto(producto);
        JOptionPane.showMessageDialog(vista, mensaje);

    }

    public void mostrarDisponibles() {
        Producto[] disponibles = gestorProductos.getProductosDisponibles();
        disponiblesFrame.mostrarProductos(disponibles);
        disponiblesFrame.setVisible(true);
    }

    public void mostrarNoDisponibles() {
        Producto[] noDisponibles = gestorProductos.getProductosNoDisponibles();
        noDisponiblesFrame.mostrarProductos(noDisponibles);
        noDisponiblesFrame.setVisible(true);
    }

    public void mostrarTodosLosProductos() {
        Producto[] todos = gestorProductos.getTodosLosProductos();
        disponiblesFrame.mostrarProductos(todos); 
        disponiblesFrame.setVisible(true);
    }
}
