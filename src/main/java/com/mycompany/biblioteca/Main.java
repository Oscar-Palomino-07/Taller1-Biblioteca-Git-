package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
}