package ec.edu.espoch.pruebaproductos.modelo;

public class GestorProductos {

    private Producto[] productos;
    private int cont;

    public GestorProductos(int tamañoMaximo) {
        this.productos = new Producto[tamañoMaximo];
        this.cont = 0;
    }

    private int idCounter = 1;

    public String agregarProducto(Producto producto) {
        if (cont < productos.length) {
            producto.setId(idCounter);
            productos[cont] = producto;
            cont++;
            idCounter++;
            return "Producto agregado correctamente con ID: " + producto.getId();
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
        int ide = 0;
        for (Producto producto : productos) {
            if (producto != null && producto.isDisponible()) {
                disponibles[ide++] = producto;
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
        int ide = 0;
        for (Producto producto : productos) {
            if (producto != null && !producto.isDisponible()) {
                noDisponibles[ide++] = producto;
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
