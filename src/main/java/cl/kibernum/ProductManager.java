package cl.kibernum;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {

    private final Map<Integer, Producto> productos = new HashMap<>();
    private int contadorId = 0;

    public boolean agregarProducto(String nombre, String descripcion, double precio) {
        if (!validarNombre(nombre) || !validarDescripcion(descripcion) || !validarPrecio(precio)) {
            return false;
        }
        contadorId++;
        productos.put(contadorId, new Producto(nombre, descripcion, precio));
        return true;
    }

    public Map<Integer, Producto> getMap() {
       return Map.copyOf(this.productos);
    }

    public boolean actualizarProducto(int id, String nombre, String descripcion, double precio) {
        Producto producto = productos.get(id);
        if (producto == null || !validarNombre(nombre) || !validarDescripcion(descripcion) || !validarPrecio(precio)) {
            return false;
        }
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        return true;
    }

    public boolean borrarProducto(int id) {
        return productos.remove(id) != null;
    }

    public boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }

    public boolean validarPrecio(double precio) {
        return precio > 0;
    }
    public boolean validarProducto(Producto producto) {
        return validarNombre(producto.getNombre()) &&
               validarDescripcion(producto.getDescripcion()) &&
               validarPrecio(producto.getPrecio());
    }
}
