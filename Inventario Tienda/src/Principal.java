import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {

            System.out.println("\n=========================");
            System.out.println(" Sistema de Inventario");
            System.out.println("=========================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Editar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    
                System.out.print("Codigo: ");
                String codigo = entrada.nextLine();

                System.out.print("Nombre: ");
                String nombre = entrada.nextLine();

                System.out.print("Precio: ");
                double precio = entrada.nextDouble();

                System.out.print("Cantidad: ");
                int cantidad = entrada.nextInt();
                entrada.nextLine();

                Producto producto = new Producto(codigo, nombre, precio, cantidad);
                inventario.agregarProducto(producto);
                
                    break;

                case 2:
                    inventario.mostrarProductos();
                    break;

                case 3:
                    System.out.print("Ingrese el codigo del producto a buscar: ");
                    codigo = entrada.nextLine();

                    Producto productoBuscado = inventario.buscarProducto(codigo);
                    
                    if(productoBuscado !=null) {
                        productoBuscado.mostrarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    
                    }

                    break;
                    
                case 4:

                    System.out.print("Codigo del producto a editar: ");
                    codigo = entrada.nextLine();

                    System.out.print("Nuevo nombre: ");
                    nombre = entrada.nextLine();

                    System.out.print("Nuevo precio: ");
                    precio = entrada.nextDouble();

                    System.out.print("Nueva cantidad: ");
                    cantidad = entrada.nextInt();
                    entrada.nextLine();

                    inventario.editarProducto(codigo, nombre, precio, cantidad);
                    break;
                    
                case 5:
                    System.out.print("Ingrese el codigo del producto a eliminar: ");
                    codigo = entrada.nextLine();

                    inventario.eliminarProducto(codigo);

                    break;
                case 6:

                    System.out.println("Saliendo del sistema...");
                    
                    break;
                
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            
    }while (opcion != 6);
    entrada.close();
    }
}

class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado.");
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        for (Producto p : productos) {
            p.mostrarProducto();
        }
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    public void editarProducto(String codigo, String nombre, double precio, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCantidad(cantidad);
            System.out.println("Producto actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void eliminarProducto(String codigo) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            productos.remove(p);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarProducto() {
        System.out.println("Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad);
    }
}

