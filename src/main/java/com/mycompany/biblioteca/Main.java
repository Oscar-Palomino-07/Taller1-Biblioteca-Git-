package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTION DE BIBLIOTECA =====");
            System.out.println("--- Clientes ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("--- Libros ---");
            System.out.println("6. Crear libro");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("--- Prestamos ---");
            System.out.println("11. Registrar prestamo");
            System.out.println("12. Registrar devolucion");
            System.out.println("13. Listar prestamos activos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 6 -> crearLibro();
                case 7 -> listarLibros();
                case 8 -> buscarLibro();
                case 9 -> actualizarLibro();
                case 10 -> eliminarLibro();
                case 11 -> crearPrestamo();
                case 12 -> registrarDevolucion();
                case 13 -> listarPrestamos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);
    }

    public static void crearCliente() {
        System.out.println("\n--- Crear Cliente ---");

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, email);
        clientes.add(nuevoCliente);

        System.out.println("Cliente creado exitosamente.");
    }
    
        public static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public static Cliente buscarClientePorId(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void buscarCliente() {
        System.out.println("\n--- Buscar Cliente por ID ---");
        System.out.print("ID a buscar: ");
        String id = sc.nextLine();

        Cliente encontrado = buscarClientePorId(id);

        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró un cliente con ese ID.");
        }
    }
    
    public static void actualizarCliente() {
        System.out.println("\n--- Actualizar Cliente ---");
        System.out.print("ID del cliente a actualizar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("No se encontró un cliente con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.isBlank()) {
            cliente.setNombre(nombre);
        }

        System.out.print("Nuevo telefono (" + cliente.getTelefono() + "): ");
        String telefono = sc.nextLine();
        if (!telefono.isBlank()) {
            cliente.setTelefono(telefono);
        }

        System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.isBlank()) {
            cliente.setEmail(email);
        }

        System.out.println("Cliente actualizado exitosamente.");
    }
    
    public static void eliminarCliente() {
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("ID del cliente a eliminar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("No se encontró un cliente con ese ID.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente eliminado exitosamente.");
    }
    
        public static void crearLibro() {
        System.out.println("\n--- Crear Libro ---");

        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Anio de publicacion: ");
        int anioPublic = Integer.parseInt(sc.nextLine());

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro nuevoLibro = new Libro(codigo, titulo, anioPublic, autor, true);
        libros.add(nuevoLibro);

        System.out.println("Libro creado exitosamente.");
    }
    
    public static void listarLibros() {
        System.out.println("\n--- Lista de Libros ---");

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro l : libros) {
            System.out.println(l);
        }
    }
    
        public static Libro buscarLibroPorCodigo(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public static void buscarLibro() {
        System.out.println("\n--- Buscar Libro por Codigo ---");
        System.out.print("Codigo a buscar: ");
        String codigo = sc.nextLine();

        Libro encontrado = buscarLibroPorCodigo(codigo);

        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró un libro con ese código.");
        }
    }
    
        public static void actualizarLibro() {
        System.out.println("\n--- Actualizar Libro ---");
        System.out.print("Codigo del libro a actualizar: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibroPorCodigo(codigo);

        if (libro == null) {
            System.out.println("No se encontró un libro con ese código.");
            return;
        }

        System.out.print("Nuevo titulo (" + libro.getTitulo() + "): ");
        String titulo = sc.nextLine();
        if (!titulo.isBlank()) {
            libro.setTitulo(titulo);
        }

        System.out.print("Nuevo autor (" + libro.getAutor() + "): ");
        String autor = sc.nextLine();
        if (!autor.isBlank()) {
            libro.setAutor(autor);
        }

        System.out.println("Libro actualizado exitosamente.");
    }
        
    public static void eliminarLibro() {
        System.out.println("\n--- Eliminar Libro ---");
        System.out.print("Codigo del libro a eliminar: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibroPorCodigo(codigo);

        if (libro == null) {
            System.out.println("No se encontró un libro con ese código.");
            return;
        }

        libros.remove(libro);
        System.out.println("Libro eliminado exitosamente.");
    }
    
    public static void crearPrestamo() {
        System.out.println("\n--- Registrar Prestamo ---");

        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("No se encontró un cliente con ese ID.");
            return;
        }

        System.out.print("Codigo del libro: ");
        String codigoLibro = sc.nextLine();
        Libro libro = buscarLibroPorCodigo(codigoLibro);

        if (libro == null) {
            System.out.println("No se encontró un libro con ese código.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible actualmente.");
            return;
        }

        System.out.print("ID del prestamo: ");
        String idPrestamo = sc.nextLine();

        Prestamo nuevoPrestamo = new Prestamo(idPrestamo, cliente, libro, LocalDate.now(), "ACTIVO");
        prestamos.add(nuevoPrestamo);

        libro.setDisponible(false);

        System.out.println("Prestamo registrado exitosamente.");
    }
        
        public static Prestamo buscarPrestamoPorId(String idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo)) {
                return p;
            }
        }
        return null;
    }

    public static void registrarDevolucion() {
        System.out.println("\n--- Registrar Devolucion ---");
        System.out.print("ID del prestamo: ");
        String idPrestamo = sc.nextLine();

        Prestamo prestamo = buscarPrestamoPorId(idPrestamo);

        if (prestamo == null) {
            System.out.println("No se encontró un prestamo con ese ID.");
            return;
        }

        if (prestamo.getEstado().equals("DEVUELTO")) {
            System.out.println("Este prestamo ya fue devuelto.");
            return;
        }

        prestamo.setEstado("DEVUELTO");
        prestamo.getLibro().setDisponible(true);

        System.out.println("Devolucion registrada exitosamente.");
    }
    
        public static void listarPrestamos() {
        System.out.println("\n--- Lista de Prestamos Activos ---");

        boolean hayActivos = false;

        for (Prestamo p : prestamos) {
            if (p.getEstado().equals("ACTIVO")) {
                System.out.println(p);
                hayActivos = true;
            }
        }

        if (!hayActivos) {
            System.out.println("No hay prestamos activos.");
        }
    }
}