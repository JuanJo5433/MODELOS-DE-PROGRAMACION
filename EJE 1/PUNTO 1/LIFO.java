import java.util.Scanner;

// Clase que representa un nodo de la lista enlazada
class Nodo {
    int number; // Valor almacenado en el nodo
    Nodo next;  // Referencia al siguiente nodo

    public Nodo(int number) {
        this.number = number;
        this.next = null;
    }
}

// Implementación de una lista enlazada con comportamiento LIFO (Last In, First Out)
class LinkedListLifo {
    private Nodo head; // Referencia al primer nodo de la lista

    // Método para insertar un nodo al inicio de la lista
    public void insertFirst(int number) {
        Nodo newNodo = new Nodo(number);
        if (head == null) {
            head = newNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            newNodo.next = head; // El nuevo nodo apunta al nodo actual en la cabeza
            head = newNodo; // La cabeza ahora es el nuevo nodo
        }
    }

    // Método para mostrar todos los elementos de la lista enlazada
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

    // Método para contar la cantidad de números pares en la lista
    public int pairsList() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return 0;
        }
        int cantPairs = 0;
        Nodo current = head;
        while (current != null) {
            if (current.number % 2 == 0) {
                cantPairs++;
            }
            current = current.next;
        }
        return cantPairs;
    }

    // Método para calcular el promedio de los valores en la lista
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
        return sum / cantNumber; // Devuelve el promedio
    }

    // Método para obtener el último número de la lista (nodo más antiguo en LIFO)
    public int lastNumber() {
        if (head == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        Nodo current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.number; // Retorna el último número ingresado
    }

    // Método para permitir la entrada dinámica de datos por consola
    public void dinamicInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número (escribe 'exit()' para terminar):");
        while (true) {
            System.out.print("> ");
            String entrada = scanner.next(); // Captura la entrada como String
            if (entrada.equalsIgnoreCase("exit()")) {
                break; // Sale del bucle si el usuario escribe "exit()"
            }
            try {
                int number = Integer.parseInt(entrada); // Convertir a número
                System.out.println("Ingresaste: " + number);
                insertFirst(number); // Inserta el número al inicio (LIFO)
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, intenta de nuevo.");
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

public class LIFO {
    public static void main(String[] args) {
        LinkedListLifo list = new LinkedListLifo(); // Instancia de la lista enlazada LIFO
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
