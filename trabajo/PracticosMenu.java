import java.util.Scanner;

public class PracticosMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1-Practico 2.1");
            System.out.println("2 - Práctico 2.2");
            System.out.println("3 - Practico 3");
            System.out.println("4 - Salir");
            System.out.print("Elija una opción: ");
            int op = leerEntero();

            switch (op) {
                case 1:
                    menuPractico21();
                    break;
                case 2:
                    menuPractico22();
                    break;
                case 3:
                    menuPractico3();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Error: ingrese un número entero válido: ");
            }
        }
    }

    static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Error: ingrese un número decimal válido: ");
            }
        }
    }

    static void menuPractico21() {
        while (true) {
            System.out.println("\n--- Práctico 2.1 - Ejercicios ---");
            System.out.println("1 - Persona (Mayor de edad)");
            System.out.println("2 - Dado (lanzar)");
            System.out.println("3 - Semáforo (acción)");
            System.out.println("4 - Propina (calcular total con propina)");
            System.out.println("5 - Menú del día");
            System.out.println("6 - Par o impar");
            System.out.println("7 - Volver al menú principal");
            System.out.print("Elija un ejercicio: ");
            int op = leerEntero();

            switch (op) {
                case 1:
                    ejercicioPersona();
                    break;
                case 2:
                    ejercicioDado();
                    break;
                case 3:
                    ejercicioSemaforo();
                    break;
                case 4:
                    ejercicioPropina();
                    break;
                case 5:
                    ejercicioMenuDelDia();
                    break;
                case 6:
                    ejercicioParImpar();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static void ejercicioPersona() {
        Persona p = new Persona("Juan", 20);
        System.out.println("Nombre: " + p.nombre);
        System.out.println("Edad: " + p.edad);
        System.out.println("¿Es mayor de edad? " + (p.esMayorDeEdad() ? "Sí" : "No"));
    }

    static class Persona {
        String nombre;
        int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public boolean esMayorDeEdad() {
            return edad >= 18;
        }
    }

    static void ejercicioDado() {
        Dado dado = new Dado();
        System.out.println("Lanzando dado... Salió: " + dado.lanzar());
    }

    static class Dado {
        int lanzar() {
            return (int) (Math.random() * 6) + 1;
        }
    }

    static void ejercicioSemaforo() {
        System.out.print("Ingrese color del semáforo (rojo, amarillo, verde): ");
        String color = sc.nextLine().toLowerCase();
        Semaforo s = new Semaforo(color);
        System.out.println("Acción: " + s.accion());
    }

    static class Semaforo {
        String color;

        Semaforo(String color) {
            this.color = color;
        }

        String accion() {
            switch (color) {
                case "verde":
                    return "Avanzar";
                case "amarillo":
                    return "Esperar";
                case "rojo":
                    return "Detenerse";
                default:
                    return "Color desconocido";
            }
        }
    }

    static void ejercicioPropina() {
        System.out.print("Ingrese total de venta: ");
        double totalVenta = leerDouble();
        System.out.print("Ingrese porcentaje de propina: ");
        double porcentajePropina = leerDouble();
        Cuenta c = new Cuenta(totalVenta, porcentajePropina);
        System.out.println("Total a pagar con propina: $" + c.calcularTotalConPropina());
    }

    static class Cuenta {
        double totalVenta, porcentajePropina;

        Cuenta(double totalVenta, double porcentajePropina) {
            this.totalVenta = totalVenta;
            this.porcentajePropina = porcentajePropina;
        }

        double calcularTotalConPropina() {
            return totalVenta + (totalVenta * porcentajePropina / 100.0);
        }
    }

    static class MenuDelDia {
        public String obtenerMenu(String dia) {
            switch (dia.toLowerCase()) {
                case "lunes":
                    return "Milanesas con puré";
                case "martes":
                    return "Pasta con tuco";
                case "miércoles":
                    return "Empanadas y ensalada";
                case "jueves":
                    return "Pollo al horno con papas";
                case "viernes":
                    return "Pescado con arroz";
                case "sábado":
                    return "Pizza casera";
                case "domingo":
                    return "Asado";
                default:
                    return "Día inválido";
            }
        }
    }

    static void ejercicioMenuDelDia() {
        System.out.print("Ingrese un día de la semana: ");
        String dia = sc.nextLine();
        MenuDelDia menu = new MenuDelDia();
        System.out.println("Menú para " + dia + ": " + menu.obtenerMenu(dia));
    }

    static void ejercicioParImpar() {
        System.out.print("Ingrese un número: ");
        int num = leerEntero();
        Numero n = new Numero(num);
        System.out.println("El número " + num + (n.esPar() ? " es par" : " es impar"));
    }

    static class Numero {
        int valor;

        Numero(int valor) {
            this.valor = valor;
        }

        boolean esPar() {
            return valor % 2 == 0;
        }
    }

    // ------------------- MENÚ PRÁCTICO 2.2 -------------------
    static void menuPractico22() {
        while (true) {
            System.out.println("\n--- Práctico 2.2 - Ejercicios ---");
            System.out.println("1 - Conversor de temperatura");
            System.out.println("2 - Planificador de cosecha");
            System.out.println("3 - Cazando fantasmas");
            System.out.println("4 - Contraseña segura");
            System.out.println("5 - Simulador de energía");
            System.out.println("6 - Verificación de rango competitivo");
            System.out.println("7 - Volver al menú principal");
            System.out.print("Elija un ejercicio: ");
            int op = leerEntero();
            switch (op) {
                case 1:
                    ejercicioConversorTemperatura();
                    break;
                case 2:
                    ejercicioPlanificadorCosecha();
                    break;
                case 3:
                    ejercicioCazandoFantasmas();
                    break;
                case 4:
                    ejercicioContrasenaSegura();
                    break;
                case 5:
                    ejercicioSimuladorEnergia();
                    break;
                case 6:
                    ejercicioVerificacionRango();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static void ejercicioConversorTemperatura() {
        System.out.print("Ingrese temperatura en Celsius: ");
        double c = leerDouble();
        Conversor conv = new Conversor();
        double f = conv.celsiusAFahrenheit(c);
        System.out.println(c + " grados Celsius son " + f + " grados Fahrenheit.");
    }

    static class Conversor {
        double celsiusAFahrenheit(double celsius) {
            return celsius * 9 / 5 + 32;
        }
    }

    static void ejercicioPlanificadorCosecha() {
        System.out.print("Ingrese cultivo: ");
        String cultivo = sc.nextLine().toLowerCase();
        System.out.print("Ingrese estación (primavera, verano, otoño, invierno): ");
        String estacion = sc.nextLine().toLowerCase();
        Planificador p = new Planificador(cultivo, estacion);
        System.out.println("¿Se puede plantar? " + (p.puedePlantar() ? "Sí" : "No"));
    }

    static class Planificador {
        String cultivo;
        String estacion;

        Planificador(String cultivo, String estacion) {
            this.cultivo = cultivo;
            this.estacion = estacion;
        }

        boolean puedePlantar() {
            // Simplificado: ejmplo de reglas
            if (cultivo.equals("maiz") && (estacion.equals("primavera") || estacion.equals("verano")))
                return true;
            if (cultivo.equals("trigo") && (estacion.equals("otoño") || estacion.equals("invierno")))
                return true;
            return false;
        }
    }

    static void ejercicioCazandoFantasmas() {
        System.out.print("Ingrese temperatura (°C): ");
        double temp = leerDouble();
        System.out.print("Ingrese nivel de escritura (alta, media, baja): ");
        String escritura = sc.nextLine().toLowerCase();
        FantasmaDetector f = new FantasmaDetector(temp, escritura);
        System.out.println("Tipo de fantasma detectado: " + f.determinarFantasma());
    }

    static class FantasmaDetector {
        double temperatura;
        String escritura;

        FantasmaDetector(double temperatura, String escritura) {
            this.temperatura = temperatura;
            this.escritura = escritura;
        }

        String determinarFantasma() {

            if (temperatura < 10 && escritura.equals("alta"))
                return "Fantasma de hielo";
            if (temperatura > 20 && escritura.equals("baja"))
                return "Fantasma fuego";
            return "Fantasma desconocido";
        }
    }

    static void ejercicioContrasenaSegura() {
        System.out.print("Ingrese contraseña: ");
        String contrasena = sc.nextLine();
        ValidadorContrasena val = new ValidadorContrasena();
        boolean segura = val.esSegura(contrasena);
        System.out.println("La contraseña es " + (segura ? "segura" : "insegura"));
    }

    static class ValidadorContrasena {
        boolean esSegura(String pass) {
            if (pass.length() < 8)
                return false;
            if (!pass.matches(".*\\d.*"))
                return false;
            if (!pass.matches(".*[A-Z].*"))
                return false;
            return true;
        }
    }

    static void ejercicioSimuladorEnergia() {
        RedEnergetica red = new RedEnergetica(1000, 800);
        System.out.println("Generación: " + red.calcularGeneracion() + " kW");
        System.out.println("Consumo: " + red.calcularConsumo() + " kW");
        System.out.println("Estado red: " + red.estadoRed());
    }

    static class RedEnergetica {
        int generadores;
        int maquinas;

        RedEnergetica(int generadores, int maquinas) {
            this.generadores = generadores;
            this.maquinas = maquinas;
        }

        int calcularGeneracion() {
            return generadores * 100;
        }

        int calcularConsumo() {
            return maquinas * 80;
        }

        String estadoRed() {
            int generacion = calcularGeneracion();
            int consumo = calcularConsumo();
            if (generacion > consumo)
                return "Exceso de energía";
            if (generacion == consumo)
                return "Energía balanceada";
            return "Déficit de energía";
        }
    }

    static void ejercicioVerificacionRango() {
        System.out.print("Ingrese puntuación: ");
        int puntuacion = leerEntero();
        RangoCompetitivo r = new RangoCompetitivo();
        System.out.println("Rango: " + r.determinarRango(puntuacion));
    }

    static class RangoCompetitivo {
        String determinarRango(int puntuacion) {
            if (puntuacion >= 90)
                return "Oro";
            if (puntuacion >= 70)
                return "Plata";
            if (puntuacion >= 50)
                return "Bronce";
            return "Sin rango";
        }
    }

    // ------------------- MENÚ PRÁCTICO 3 -------------------
    static void menuPractico3() {
        while (true) {
            System.out.println("\n--- Práctico 3 - Ejercicios ---");
            System.out.println("1 - Animales Zoológicos");
            System.out.println("2 - Biblioteca Digital");
            System.out.println("3 - Figuras Geométricas");
            System.out.println("4 - Jerarquía de Animales");
            System.out.println("5 - Procesador de Pago");
            System.out.println("6 - Sistema de Empleados");
            System.out.println("7 - Vehículos Eléctricos");
            System.out.println("8 - Volver al menú principal");
            System.out.print("Elija un ejercicio: ");
            int op = leerEntero();
            switch (op) {
                case 1:
                    ejercicioAnimalesZoologicos();
                    break;
                case 2:
                    ejercicioBibliotecaDigital();
                    break;
                case 3:
                    ejercicioFigurasGeometricas();
                    break;
                case 4:
                    ejercicioJerarquiaAnimales();
                    break;
                case 5:
                    ejercicioProcesadorPago();
                    break;
                case 6:
                    ejercicioSistemaEmpleados();
                    break;
                case 7:
                    ejercicioVehiculosElectricos();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static void ejercicioAnimalesZoologicos() {
        AnimalZologico[] animales = new AnimalZologico[3];
        animales[0] = new Leon("Alex");
        animales[1] = new Elefante("Simon");
        animales[2] = new Kowalski("Kowalski");

        for (AnimalZologico a : animales) {
            a.Alimentar();
        }
    }

    static class AnimalZologico {
        String nombre;

        AnimalZologico(String nombre) {
            this.nombre = nombre;
        }

        public void Alimentar() {
            System.out.println("Alimentando al animal");
        }
    }

    static class Leon extends AnimalZologico {
        Leon(String nombre) {
            super(nombre);
        }

        @Override
        public void Alimentar() {
            System.out.println("Alimentando a " + nombre);
        }
    }

    static class Elefante extends AnimalZologico {
        Elefante(String nombre) {
            super(nombre);
        }

        @Override
        public void Alimentar() {
            System.out.println("Alimentando a " + nombre);
        }
    }

    static class Kowalski extends AnimalZologico {
        Kowalski(String nombre) {
            super(nombre);
        }

        @Override
        public void Alimentar() {
            System.out.println("Alimentando a " + nombre);
        }
    }

    static void ejercicioBibliotecaDigital() {
        Publicacion[] publicaciones = new Publicacion[2];
        publicaciones[0] = new Libro("The name of the wind.", 2007);
        publicaciones[1] = new Revista("National Geographic", 2021);

        for (Publicacion p : publicaciones) {
            p.mostrarInformacion();
        }
    }

    static class Publicacion {
        String titulo;
        int anio;

        Publicacion(String titulo, int anio) {
            this.titulo = titulo;
            this.anio = anio;
        }

        public void mostrarInformacion() {
            System.out.println("El título es " + titulo);
            System.out.println("El año es " + anio);
        }
    }

    static class Libro extends Publicacion {
        Libro(String titulo, int anio) {
            super(titulo, anio);
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("El título del libro es " + titulo + " y el año es " + anio);
        }
    }

    static class Revista extends Publicacion {
        Revista(String titulo, int anio) {
            super(titulo, anio);
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("El título de la revista es " + titulo + " y el año es " + anio);
        }
    }

    static void ejercicioFigurasGeometricas() {
        Figura[] figuras = new Figura[3];
        figuras[0] = new Cuadrado(4);
        figuras[1] = new Circulo(3);
        figuras[2] = new Triangulo(5, 2);

        for (Figura f : figuras) {
            System.out.println("Área: " + f.calcularArea());
        }
    }

    static class Figura {
        public double calcularArea() {
            return 0;
        }
    }

    static class Cuadrado extends Figura {
        double lado;

        Cuadrado(double lado) {
            this.lado = lado;
        }

        @Override
        public double calcularArea() {
            return lado * lado;
        }
    }

    static class Circulo extends Figura {
        double radio;

        Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }
    }

    static class Triangulo extends Figura {
        double base, altura;

        Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return (base * altura) / 2;
        }
    }

    static class Animal {
        String nombre;
        int edad;

        Animal(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public void hacerSonido() {
            System.out.println("El animal hace un sonido");
        }
    }

    static class Perro extends Animal {
        public Perro(String nombre, int edad) {
            super(nombre, edad);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: Guau!");
        }
    }

    static class Gato extends Animal {
        public Gato(String nombre, int edad) {
            super(nombre, edad);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: Miau");
        }
    }

    static class Oveja extends Animal {
        public Oveja(String nombre, int edad) {
            super(nombre, edad);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: Bee");
        }
    }

    static void ejercicioJerarquiaAnimales() {
        Animal[] animales = new Animal[3];

        animales[0] = new Perro("Firulais", 3);
        animales[1] = new Gato("Gato con botas", 1);
        animales[2] = new Oveja("Nemo", 4);

        for (Animal animal : animales) {
            animal.hacerSonido();
        }
    }

    static void ejercicioProcesadorPago() {
        ProcesadorPago pago = new ProcesadorPago(1000, 15); // totalVenta=1000, porcentajeDescuento=15%
        double totalFinal = pago.calcularTotalConDescuento();
        System.out.println("Total con descuento aplicado: $" + totalFinal);
    }

    static class ProcesadorPago {
        double totalVenta;
        double porcentajeDescuento;

        ProcesadorPago(double totalVenta, double porcentajeDescuento) {
            this.totalVenta = totalVenta;
            this.porcentajeDescuento = porcentajeDescuento;
        }

        public double calcularTotalConDescuento() {
            return totalVenta - (totalVenta * porcentajeDescuento / 100);
        }
    }

    static void ejercicioSistemaEmpleados() {
        Empleado[] empleados = new Empleado[3];

        empleados[0] = new Jornalero("Dain", 1000, 6);
        empleados[1] = new Mensual("Nemo", 30000);
        empleados[2] = new Jornalero("Lina", 1200, 5);

        for (Empleado emp : empleados) {
            System.out.println(emp.nombre + " gana $" + emp.calcularSalario());
        }
    }

    static class Empleado {
        String nombre;

        public Empleado(String nombre) {
            this.nombre = nombre;
        }

        public double calcularSalario() {
            return 0;
        }
    }

    static class Jornalero extends Empleado {
        double pagoPorDias;
        int diasTrabajados;

        Jornalero(String nombre, double pagoPorDias, int diasTrabajados) {
            super(nombre);
            this.pagoPorDias = pagoPorDias;
            this.diasTrabajados = diasTrabajados;
        }

        @Override
        public double calcularSalario() {
            return pagoPorDias * diasTrabajados;
        }
    }

    static class Mensual extends Empleado {
        double salarioMensual;

        Mensual(String nombre, double salarioMensual) {
            super(nombre);
            this.salarioMensual = salarioMensual;
        }

        @Override
        public double calcularSalario() {
            return salarioMensual;
        }
    }

    static class Vehiculo {
        String marca;
        String modelo;

        public Vehiculo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        public void recargarBateria() {
            System.out.println("recargando bateria ");
        }
    }

    static class AutoElectrico extends Vehiculo {
        public AutoElectrico(String marca, String modelo) {
            super(marca, modelo);
        }

        @Override
        public void recargarBateria() {
            System.out.println("Recargando bateria de auto electrico : " + marca + " " + modelo);
        }
    }

    static class MotoElectrica extends Vehiculo {
        public MotoElectrica(String marca, String modelo) {
            super(marca, modelo);
        }

        @Override
        public void recargarBateria() {
            System.out.println("Recargando bateria de la moto electrica: " + marca + " " + modelo);
        }
    }

    static void ejercicioVehiculosElectricos() {
        Vehiculo[] vehiculos = new Vehiculo[2];

        vehiculos[0] = new AutoElectrico("Tesla", "Model Y");
        vehiculos[1] = new MotoElectrica("Yumbo", "SSi");

        for (Vehiculo v : vehiculos) {
            v.recargarBateria();
        }
    }
}
