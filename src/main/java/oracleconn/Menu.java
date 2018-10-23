package oracleconn;

import java.util.Scanner;

import commons.Crud;
import models.Departamento;
import models.Empleado;

public class Menu {
  private Scanner scanner;
  private int selected;

  public Menu() {
    this.scanner = new Scanner(System.in);
  }

  public void start() {
    this.printHeader();
    this.printMenu1();

  }

  public void printHeader() {
    sout("===============================================");
    sout("========== Oracle conexion por JBDC ===========");
    sout("==== Enfasis 2 - Politecnico Grancolombiano ===");
  }

  private void printMenu1() {
    sout("===============================================");
    sout("MENU > Seleccione la tabla a operar");
    sout("0 => Departamento");
    sout("1 => Empleado");
    sout("===============================================");
    this.triggerMenu1(this.scanner.nextInt());
  }

  private void printMenu1(String alertMessage) {
    sout("===============================================");
    sout("!! " + alertMessage + " !!");
    sout("===============================================");
    sout("MENU > Seleccione la tabla a operar");
    sout("0 => Departamento");
    sout("1 => Empleado");
    sout("===============================================");
    this.triggerMenu1(this.scanner.nextInt());
  }

  private void triggerMenu1(int opcion) {
    this.selected = opcion;
    if (opcion > 1)
      this.printMenu1("La opción no exista vuelva a leer con calma");
    else if (opcion > -1) {
      this.printMenu2();
    } else {
      this.printMenu1("La opción no exista vuelva a leer con calma");
    }
  }

  private void printMenu2() {
    String tabla = this.selected == 0 ? "Departamento" : "Empleado";
    sout("===============================================");
    sout("MENU > " + tabla + " >Seleccione la operación");
    sout("0 => Insertar o actualizar");
    sout("1 => Eliminar");
    sout("9 => Atras");
    sout("===============================================");
    this.triggerMenu2(this.scanner.nextInt(), tabla);
  }

  private void printMenu2(String tabla, String alertMessage) {
    sout("===============================================");
    sout("!! " + alertMessage + " !!");
    sout("===============================================");
    sout("MENU > " + tabla + " >Seleccione la operación");
    sout("0 => Insertar o actualizar");
    sout("1 => Eliminar");
    sout("9 => Atras");
    sout("===============================================");
    this.triggerMenu2(this.scanner.nextInt(), tabla);
  }

  private void triggerMenu2(int opcion, String tabla) {
    Object model = tabla == "Departamento" ? new Departamento() : new Empleado();
    // 0 => insertar
    // 1 => delete
    // 9 => atras
    if (opcion == 0) {
      this.printInsertMenu(tabla, model);
    } else if (opcion == 1) {

    }
    if (opcion == 9)
      printMenu1();
  }

  private void printInsertMenu(String tabla, Object model) {
    sout("===============================================");
    sout("MENU DE INSERCIÓN O ACTUALIZACIÓN > " + tabla);
    sout("===============================================");
    if (tabla == "Departamento")
      this.insertMenuDepartamento((Departamento) model);
    else if (tabla == "Empleado")
      this.insertMenuEmpleado((Empleado) model);

  }

  private void insertMenuDepartamento(Departamento departamento) {
    sout("Digite el codigo del departamento");
    departamento.setIdDepartamento(this.scanner.nextInt());
    sout("===============================================");
    sout("Digite el nombre del departamento");
    departamento.setNombreDepartamento(this.scanner.next());
    sout("===============================================");
    sout("Estableciendo conexión con oracle 11g");
    Crud crud = new Crud(departamento);
    crud.insertOrUpdate();
    sout("Insersión satisfactoria");
    this.printMenu1();
  }

  private void insertMenuEmpleado(Empleado empleado) {
    sout("Digite el codigo del empleado");
    empleado.setIdEmpleado(this.scanner.nextInt());
    sout("===============================================");
    sout("Digite el nombre del departamento");
    empleado.setNombreEmpleado(this.scanner.next());
    sout("===============================================");
    sout("Digite el codigo o el nombre del departamento ");
    empleado.setNombreEmpleado(this.scanner.next());

    sout("Estableciendo conexión con oracle 11g");
    Crud crud = new Crud(departamento);
    crud.insertOrUpdate();
    sout("Insersión satisfactoria");
    this.printMenu1();
  }

  private void sout(String sentence) {
    System.out.println(sentence);
  }
}