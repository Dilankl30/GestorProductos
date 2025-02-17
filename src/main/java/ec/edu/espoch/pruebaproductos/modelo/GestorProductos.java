/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.pruebaproductos.modelo;

/**
 *
 * @author mundo
 */
public class GestorProductos {

    private Producto[] productos;
    private int cont;

    public GestorProductos(int tamañoMaximo) {
        this.productos = new Producto[tamañoMaximo];
        this.cont = 0;
    }

    public String agregarProducto(Producto producto) {
        if (cont < productos.length) {
            productos[cont] = producto;
            cont++;
            return "Producto agregado correctamente.";
        } else {
            return "No hay espacio para más productos.";
        }
    }

    public Producto[] getProductosDisponibles() {
        int count = 0;
        for (Producto producto : productos) {
            if (producto != null && producto.isDisponible()) {
                count++;
            }
        }
        Producto[] disponibles = new Producto[count];
        int index = 0;
        for (Producto producto : productos) {
            if (producto != null && producto.isDisponible()) {
                disponibles[index++] = producto;
            }
        }
        return disponibles;
    }

    public Producto[] getProductosNoDisponibles() {
        int count = 0;
        for (Producto producto : productos) {
            if (producto != null && !producto.isDisponible()) {
                count++;
            }
        }
        Producto[] noDisponibles = new Producto[count];
        int index = 0;
        for (Producto producto : productos) {
            if (producto != null && !producto.isDisponible()) {
                noDisponibles[index++] = producto;
            }
        }
        return noDisponibles;
    }

    public Producto[] getTodosLosProductos() {
        Producto[] todos = new Producto[cont];
        for (int i = 0; i < cont; i++) {
            todos[i] = productos[i];
        }
        return todos;
    }
}
