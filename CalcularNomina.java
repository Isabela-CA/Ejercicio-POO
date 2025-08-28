import java.util.Scanner;

public class CalcularNomina {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese la cédula del empleado: ");
        String cedula = input.nextLine();

        System.out.print("Ingrese la edad del empleado: ");
        int edad = input.nextInt();
        input.nextLine(); 

        System.out.print("Ingrese el tipo de empleado (auxiliar, profesional, subgerente, gerente): ");
        String tipoEmpleado = input.nextLine();

        System.out.print("Ingrese las horas trabajadas en el mes (máximo 160): ");
        int horasTrabajadas = input.nextInt();

        // Creación del objeto Empleado
        Empleado empleado = new Empleado(nombre, cedula, edad, tipoEmpleado, horasTrabajadas);

        // Llamada al método para generar desglose
        empleado.generarDesgloseNomina();

        input.close();
    }
}