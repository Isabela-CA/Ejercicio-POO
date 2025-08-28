
import java.text.DecimalFormat;

public class Empleado {

    // Atributos
    private String nombre;
    private String cedula;
    private int edad;
    private String tipoEmpleado;
    private int horasTrabajadas;

    // Constructor
    public Empleado(String nombre, String cedula, int edad, String tipoEmpleado, int horasTrabajadas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.tipoEmpleado = tipoEmpleado.toLowerCase();
        this.horasTrabajadas = horasTrabajadas;
    }

    // Método: Obtener valor por hora
    public double getValorPorHora() {
        switch (tipoEmpleado) {
            case "auxiliar":
                return 12187.50;
            case "profesional":
                return 26595.74;
            case "subgerente":
                return 58024.17;
            case "gerente":
                return 93750.00;
            default:
                return 0.0;
        }
    }

    // Método: Calcular salario bruto
    public double calcularSalarioBruto() {
        return getValorPorHora() * horasTrabajadas;
    }

    // Método: Calcular auxilio de transporte
    public double calcularAuxilioTransporte() {
        double salarioBruto = calcularSalarioBruto();
        if (salarioBruto < 2600000) {
            return 300000.00;
        } else {
            return 0.0;
        }
    }

    // Método: Calcular bonificación por edad
    public double calcularBonificacionEdad() {
        if (edad > 50) {
            return 100000.00;
        } else {
            return 0.0;
        }
    }

    // Método: Calcular descuento de salud
    public double calcularDescuentoSalud() {
        return calcularSalarioBruto() * 0.04;
    }

    // Método: Calcular descuento de pensión
    public double calcularDescuentoPension() {
        return calcularSalarioBruto() * 0.04;
    }

    // Método: Calcular salario neto
    public double calcularSalarioNeto() {
        double salarioBruto = calcularSalarioBruto();
        double auxilioTransporte = calcularAuxilioTransporte();
        double bonificacion = calcularBonificacionEdad();
        double descuentoSalud = calcularDescuentoSalud();
        double descuentoPension = calcularDescuentoPension();

        return salarioBruto + auxilioTransporte + bonificacion - descuentoSalud - descuentoPension;
    }

    // Método: Generar desglose de nómina
    public void generarDesgloseNomina() {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        double salarioBruto = calcularSalarioBruto();
        double auxilioTransporte = calcularAuxilioTransporte();
        double bonificacion = calcularBonificacionEdad();
        double descuentoSalud = calcularDescuentoSalud();
        double descuentoPension = calcularDescuentoPension();
        double salarioNeto = calcularSalarioNeto();

        System.out.println("\n--- Desglose de Nómina ---");
        System.out.println("Empleado: " + this.nombre);
        System.out.println("Cédula: " + this.cedula);
        System.out.println("Edad: " + this.edad + " años");
        System.out.println("Tipo de Empleado: " + this.tipoEmpleado);
        System.out.println("Horas trabajadas: " + this.horasTrabajadas);
        System.out.println("\n--- Cálculos ---");
        System.out.println("Valor por hora: $" + df.format(getValorPorHora()));
        System.out.println("Salario Bruto: $" + df.format(salarioBruto));
        System.out.println("Auxilio de Transporte: $" + df.format(auxilioTransporte));
        System.out.println("Bonificación por Edad: $" + df.format(bonificacion));
        System.out.println("Descuento por Salud (4%): $" + df.format(descuentoSalud));
        System.out.println("Descuento por Pensión (4%): $" + df.format(descuentoPension));
        System.out.println("\n--------------------");
        System.out.println("Salario Neto Final: $" + df.format(salarioNeto));
        System.out.println("--------------------\n");
    }
}