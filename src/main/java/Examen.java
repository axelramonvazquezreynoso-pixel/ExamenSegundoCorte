import java.util.Scanner;

public class Examen {
    static String[] nombres = new String[50];
    static double[] calificaciones = new double[50];
    static int cantidad = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENU DE CALIFICACIONES ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes y resultados");
            System.out.println("3. Ver estadisticas");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 


            switch (opcion) {
                case 1:
                    registrar(sc);
                    break;
                case 2:
                    mostrarResultados();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }

    public static void registrar(Scanner sc) {
        System.out.print("Nombre del alumno: ");
        nombres[cantidad] = sc.nextLine();

        System.out.print("Calificacion (0 a 10): ");
        calificaciones[cantidad] = sc.nextDouble();
        sc.nextLine();

        cantidad++;
        System.out.println("-> Alumno guardado con exito.");
    }

    public static void mostrarResultados() {
        if (cantidad == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE ALUMNOS ---");
        for (int i = 0; i < cantidad; i++) {
            String estado = obtenerEstado(calificaciones[i]);
            System.out.println((i + 1) + ". " + nombres[i] + " - Nota: " + calificaciones[i] + " (" + estado + ")");
        }
    }

    public static String obtenerEstado(double nota) {
        if (nota >= 6.0) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public static void mostrarEstadisticas() {
        if (cantidad == 0) {
            System.out.println("No hay datos para estadisticas.");
            return;
        }

        double promedio = calcularPromedio();
        double mayor = calificaciones[0];
        double menor = calificaciones[0];
        int aprobados = 0;

        for (int i = 0; i < cantidad; i++) {
            if (calificaciones[i] > mayor) {
                mayor = calificaciones[i];
            }
            if (calificaciones[i] < menor) {
                menor = calificaciones[i];
            }
            if (calificaciones[i] >= 6.0) {
                aprobados++;
            }
        }

        System.out.println("\n--- ESTADISTICAS DEL GRUPO ---");
        System.out.println("Total de alumnos: " + cantidad);
        System.out.println("Promedio general: " + promedio);
        System.out.println("Calificacion mas alta: " + mayor);
        System.out.println("Calificacion mas baja: " + menor);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + (cantidad - aprobados));
    }

    public static double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];
        }
        return suma / cantidad;
    }
}