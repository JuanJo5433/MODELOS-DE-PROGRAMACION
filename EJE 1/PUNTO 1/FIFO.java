import java.util.Scanner;

// Clase que representa un nodo de la lista enlazada
class Nodo {
    int number; // Valor del nodo
    Nodo next; // Referencia al siguiente nodo en la lista

    public Nodo(int number) {
        this.number = number;
        this.next = null;
    }
}

// Clase que implementa una lista enlazada FIFO (First In, First Out)
class LinkedListFifo {
    private Nodo head; // Primer nodo de la lista

    // Metodo para insertar un nodo al final de la lista
    public void insertEnd(int number) {
        Nodo newNodo = new Nodo(number);
        if (head == null) {
            head = newNodo; // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        } else {
            Nodo current = head;
            while (current.next != null) { // Recorremos la lista hasta el último nodo
                current = current.next;
            }
            current.next = newNodo; // Agregamos el nuevo nodo al final
        }
    }

    // Metodo para mostrar la lista enlazada
    public void showList() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo current = head;
        while (current != null) {
            System.out.print(current.number + " --> ");
            current = current.next;
        }
        System.out.println("null"); // Indica el final de la lista
    }

    // Metodo para contar la cantidad de números pares en la lista
    public int pairsList() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return 0;
        }
        int cantPairs = 0;
        Nodo current = head;
        while (current != null) {
            if (current.number % 2 == 0) {
                cantPairs++; // Incrementamos si el número es par
            }
            current = current.next;
        }
        return cantPairs;
    }

    // Metodo para calcular el promedio de los valores en la lista
    public double promList() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return 0;
        }
        double sum = 0;
        int cantNumber = 0;
        Nodo current = head;
        while (current != null) {
            sum += current.number;
            cantNumber++;
            current = current.next;
        }
        return sum / cantNumber; // Retorna el promedio
    }

    // Metodo para obtener el último número de la lista
    public int lastNumber() {
        if (head == null) {
            throw new IllegalStateException("La lista está vacía, no hay último número.");
        }
        Nodo current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.number; // Retorna el último número de la lista
    }

    // Metodo para ingresar datos por teclado de manera dinámica
    public void dinamicInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un numero (escribe 'exit()' para terminar):");
        while (true) {
            System.out.print("> ");
            String entrada = scanner.next(); // Captura la entrada como String
            if (entrada.equalsIgnoreCase("exit()")) {
                break; // Salir del bucle si el usuario escribe "exit()"
            }
            try {
                int number = Integer.parseInt(entrada); // Convertir a número
                System.out.println("Ingresaste: " + number);
                System.out.println("Ingresa un numero (escribe 'exit()' para terminar):");

                this.insertEnd(number);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, intenta de nuevo.");
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }
}


// Clase principal que ejecuta el programa
public class FIFO {
    public static void main(String[] args) {
        LinkedListFifo list = new LinkedListFifo();
        list.dinamicInput(); // Permitir que el usuario ingrese datos

        System.out.println("\nLista enlazada:");
        list.showList();

        int cantPares = list.pairsList();
        System.out.println("Cantidad de números pares: " + cantPares);

        double prom = list.promList();
        System.out.println("El promedio es: " + prom);

        try {
            int lastNum = list.lastNumber();
            System.out.println("El último número de la lista es: " + lastNum);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
