package oracleconn;

import commons.Crud;
import models.Departamento;
import models.Empleado;

public class Main {
	public static void main(String[] args) {

		// Menu m = new Menu();
		// m.start();

		Departamento dep = new Departamento();
		dep.setIdDepartamento(505);

		Empleado emp = new Empleado();
		emp.setIdDepartamento(dep);
		emp.setNombreEmpleado("JUAN2");
		emp.setIdEmpleado(2);

		Crud crud = new Crud(emp);
		crud.insertOrUpdate();
	}

	/*
	 * public static void main(String[] args) { try { Connection conn =
	 * OraConn.connect(); Statement st = conn.createStatement();
	 * 
	 * ResultSet rs = st.executeQuery("SELECT * FROM CIUDAD");
	 * 
	 * while(rs.next()) {
	 * 
	 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2)); } }
	 * catch (Exception ex) { ex.printStackTrace(); } }
	 */
}
