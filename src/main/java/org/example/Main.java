package org.example;

import org.example.dao.*;

import org.example.model.cliente;
import org.example.model.vehiculo;
import org.example.model.servicio;
import org.example.model.registroLavado;

import org.example.util.conexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = conexionBD.obtenerConexion()) {
            clienteDAO clienteDAO = new clienteDAOimpl(connection);
            vehiculoDAO vehiculoDAO = new vehiculoDAOimpl(connection);
            servicioDAO servicioDAO = new servicioDAOimpl(connection);
            registroLavadoDAO registroLavadoDAO = new registroLavadoDAOimpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Gestionar Clientes");
                System.out.println("2.Gestionar Vehiculos");
                System.out.println("3. Gestionar Servicios");
                System.out.println("4. Gestionar Registro de lavado");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion){
                    case 1:
                        int opcionCliente=-1;
                        do{
                            System.out.println("1. Agregar");
                            System.out.println("2. Leer");
                            System.out.println("3. Actualizar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Listar");
                            System.out.println("0. Volverr");
                            opcionCliente = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcionCliente){
                                case 1:
                                    System.out.println("Nombre: ");
                                    String nombre = scanner.nextLine();
                                    System.out.print("Apellido: ");
                                    String apellido = scanner.nextLine();
                                    System.out.println("telefono: ");
                                    String telefono = scanner.nextLine();
                                    System.out.println("Email: ");
                                    String email = scanner.nextLine();
                                    System.out.println("Direccion: ");
                                    String direccion = scanner.nextLine();

                                    cliente c = new cliente(nombre, apellido, telefono, email, direccion);
                                    clienteDAO.agregar(c);
                                    System.out.println("Cliente registrado.");
                                    break;
                                case 2:
                                    System.out.print("Ingrese el ClienteID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    cliente c1 = clienteDAO.leer(id);
                                    if (c1 != null) {
                                        System.out.println(c1);
                                    } else {
                                        System.out.println("Cliente no encontrado.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("ID a actualizar ");
                                    int IDactulizar = scanner.nextInt();
                                    scanner.nextLine();
                                    cliente c3 = clienteDAO.leer(IDactulizar);
                                    if (c3 != null) {
                                        System.out.print("Nuevo nombre: ");
                                        c3.setNombre(scanner.nextLine());
                                        System.out.print("Nuevo apellido: ");
                                        c3.setApellido(scanner.nextLine());
                                        System.out.print("Nuevo telefono: ");
                                        c3.setTelefono(scanner.nextLine());
                                        System.out.print("Nuevo email: ");
                                        c3.setEmail(scanner.nextLine());
                                        System.out.println("Nueva direccion: ");
                                        c3.setDireccion(scanner.nextLine());

                                        clienteDAO.actualizar(c3);
                                        System.out.println("cliente actualizado.");
                                    } else {
                                        System.out.println("cliente no encontrado.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("ID del cliente a eliminar: ");
                                    int IDeliminar = scanner.nextInt();
                                    scanner.nextLine();
                                    clienteDAO.eliminar(IDeliminar);
                                    System.out.println("Cliente elimindao");
                                    break;
                                case 5:
                                    List<cliente>listaClientes = clienteDAO.listar();
                                    for (cliente c4 : listaClientes){
                                        System.out.println(c4);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal ");
                                    break;
                            }
                        }while (opcionCliente != 0);
                        break;
                    case 2:
                        int opcionVehiculo=-1;
                        do{
                            System.out.println("1. Agregar");
                            System.out.println("2. Leer");
                            System.out.println("3. Actualizar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Listar");
                            System.out.println("0. Volverr");
                            opcionVehiculo = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcionVehiculo){
                                case 1:
                                    System.out.println("ClienteID: ");
                                    int clienteID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Marca: ");
                                    String marca = scanner.nextLine();
                                    System.out.println("Modelo: ");
                                    String modelo = scanner.nextLine();
                                    System.out.println("Placa: ");
                                    String placa = scanner.nextLine();
                                    System.out.println("Color: ");
                                    String color = scanner.nextLine();
                                    System.out.println("Tipo: ");
                                    String tipo = scanner.nextLine();

                                    vehiculo v = new vehiculo(clienteID, marca, modelo, placa, color, tipo);
                                    vehiculoDAO.agregar(v);
                                    System.out.println("Vehiculo registrado.");
                                    break;
                                case 2:
                                    System.out.print("Ingrese el vehiculoID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    vehiculo v1 = vehiculoDAO.leer(id);
                                    if (v1 != null) {
                                        System.out.println(v1);
                                    } else {
                                        System.out.println("Vehiculo no encontrado.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("IDvehiculo a actualizar ");
                                    int Vactulizar = scanner.nextInt();
                                    scanner.nextLine();
                                    vehiculo v3 = vehiculoDAO.leer(Vactulizar);
                                    if (v3 != null) {
                                        System.out.print("Nuevo cliente ID: ");
                                        v3.setClienteID(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.print("Nueva marca: ");
                                        v3.setMarca(scanner.nextLine());
                                        System.out.print("Nuevo modelo: ");
                                        v3.setModelo(scanner.nextLine());
                                        System.out.print("Nueva placa: ");
                                        v3.setPlaca(scanner.nextLine());
                                        System.out.println("Nuevo color: ");
                                        v3.setColor(scanner.nextLine());
                                        System.out.println("Nuevo tipo: ");
                                        v3.setTipo(scanner.nextLine());

                                        vehiculoDAO.actualizar(v3);
                                        System.out.println("Vehiculo actualizado.");
                                    } else {
                                        System.out.println("Vehiculo no encontrado.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("ID del vehiculo a eliminar: ");
                                    int IDeliminar = scanner.nextInt();
                                    scanner.nextLine();
                                    vehiculoDAO.eliminar(IDeliminar);
                                    System.out.println("vehiculo elimindao");
                                    break;
                                case 5:
                                    List<vehiculo>listaVehiculos = vehiculoDAO.listar();
                                    for (vehiculo v4 : listaVehiculos){
                                        System.out.println(v4);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal ");
                                    break;
                            }
                        }while (opcionVehiculo != 0);
                        break;
                    case 3:
                        int opcionServicios=-1;
                        do{
                            System.out.println("1. Agregar");
                            System.out.println("2. Leer");
                            System.out.println("3. Actualizar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Listar");
                            System.out.println("0. Volverr");
                            opcionServicios = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcionServicios){
                                case 1:
                                    System.out.println("Nombre: ");
                                    String nombre = scanner.nextLine();
                                    System.out.print("Precio: ");
                                    double precio = scanner.nextDouble();
                                    scanner.nextLine();
                                    servicio s = new servicio(nombre, precio);
                                    servicioDAO.agregar(s);
                                    System.out.println("Servicio registrado.");
                                    break;
                                case 2:
                                    System.out.print("Ingrese el servicioID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    servicio s1= servicioDAO.leer(id);
                                    if (s1 != null) {
                                        System.out.println(s1);
                                    } else {
                                        System.out.println("Servicio no encontrado.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("IDservicio a actualizar ");
                                    int Sactulizar = scanner.nextInt();
                                    scanner.nextLine();
                                    servicio s3 = servicioDAO.leer(Sactulizar);
                                    if (s3 != null) {
                                        System.out.print("Nuevo nombre: ");
                                        s3.setNombre(scanner.nextLine());
                                        System.out.print("Nuevo precio: ");
                                        s3.setPrecio(scanner.nextDouble());
                                        scanner.nextLine();
                                        servicioDAO.actualizar(s3);
                                        System.out.println("Servicio actualizado.");
                                    } else {
                                        System.out.println("Servicio no encontrado.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("ID del servicio a eliminar: ");
                                    int IDeliminar = scanner.nextInt();
                                    scanner.nextLine();
                                    servicioDAO.eliminar(IDeliminar);
                                    System.out.println("servicio elimindao");
                                    break;
                                case 5:
                                    List<servicio>listaServicios = servicioDAO.listar();
                                    for (servicio s4 : listaServicios){
                                        System.out.println(s4);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal ");
                                    break;
                            }
                        }while (opcionServicios != 0);
                        break;
                    case 4:
                        int opcionRegistro=-1;
                        do{
                            System.out.println("1. Agregar");
                            System.out.println("2. Leer");
                            System.out.println("3. Actualizar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Listar");
                            System.out.println("0. Volverr");
                            opcionRegistro = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcionRegistro){
                                case 1:
                                    System.out.println("VehiculoID: ");
                                    int vehiculoID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("ServicioID: ");
                                    int servicioID = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Fecha de lavado: ");
                                    String fechaLavado = scanner.nextLine();
                                    System.out.println("Hora de inicio: ");
                                    String horaInicio = scanner.nextLine();
                                    System.out.println("Hora de fin: ");
                                    String horaFin = scanner.nextLine();
                                    System.out.println("Precio total: ");
                                    double precio = scanner.nextDouble();
                                    scanner.nextLine();

                                    registroLavado r = new registroLavado(vehiculoID, servicioID, fechaLavado, horaInicio, horaFin, precio);
                                    registroLavadoDAO.agregar(r);
                                    System.out.println("Registro de lavado registrado.");
                                    break;
                                case 2:
                                    System.out.print("Ingrese el registro de lavado ID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    registroLavado r1 = registroLavadoDAO.leer(id);
                                    if (r1 != null) {
                                        System.out.println(r1);
                                    } else {
                                        System.out.println("Registro de lavado no encontrado.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("ID del regsitro del lavado a actualizar ");
                                    int Ractulizar = scanner.nextInt();
                                    scanner.nextLine();
                                    registroLavado r3 = registroLavadoDAO.leer(Ractulizar);
                                    if (r3 != null) {
                                        System.out.print("Nuevo vehiculo ID: ");
                                        r3.setVehiculoID(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.print("Nuevo servicio ID: ");
                                        r3.setServicioID(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.print("Nueva fecha de lavado: ");
                                        r3.setFechaLavado(scanner.nextLine());
                                        System.out.print("Nueva hora inicio de lavado: ");
                                        r3.setHoraInicio(scanner.nextLine());
                                        System.out.print("Nueva hora fin de lavado: ");
                                        r3.setHoraFin(scanner.nextLine());
                                        System.out.println("Nuevo precio final: ");
                                        r3.setPrecioTotal(scanner.nextDouble());
                                        scanner.nextLine();

                                        registroLavadoDAO.actualizar(r3);
                                        System.out.println("Registrp de lavado actualizado.");
                                    } else {
                                        System.out.println("Registro de lavado no encontrado.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("ID del Registro de lavado a eliminar: ");
                                    int IDeliminar = scanner.nextInt();
                                    scanner.nextLine();
                                    registroLavadoDAO.eliminar(IDeliminar);
                                    System.out.println("Registro de lavado elimindao");
                                    break;
                                case 5:
                                    List<registroLavado>listaregistros = registroLavadoDAO.listar();
                                    for (registroLavado r4 : listaregistros){
                                        System.out.println(r4);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal ");
                                    break;
                            }
                        }while (opcionRegistro != 0);
                        break;

                }
            } while (opcion != 0);
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}