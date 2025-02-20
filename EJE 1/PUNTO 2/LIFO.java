// Clase que representa un nodo de la lista enlazada
class Nodo {
    int code; // Codigo almacenado en el node
    String name; // Nombre almacenado en el node
    int phone; // Telefono alamcenado en el node
    int age; // Edad alamacenada en el node
    Nodo next; // Referencia al siguiente nodo

    public Nodo(int code, String name, int phone, int age) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.next = null;
    }
}

class LinkedListLifo {

    private Nodo head;

    // Metodo para insertar nodo al principio de la lista

    public void insertStart(int code, String name, int phone, int age) {
        Nodo newNodo = new Nodo(code, name, phone, age);
        if (head == null) {
            head = newNodo; // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        }else{
            newNodo.next = head;
            head = newNodo;
        }

    }

    public void showList(){
        if(head == null){
            System.out.println("La lista está vacía");
            return;
        }
        Nodo current = head;

        while (current != null) {
            System.out.println(String.format("( %d, %s, %d, %d ) -->", current.code, current.name, current.phone, current.age));
            current = current.next;
        }  
        System.out.println("null");


    } 
    public void deleteFirstElement (){
         if(head == null){
            System.out.println("La lista está vacía");
            return;
        }
        head = head.next;
        
    }

    public void cantElements(){
        if(head == null){
            System.out.println("La lista está vacía");
            return;
        }
        Nodo current = head;
        int cant = 0;
        while (current != null) {
            cant++;
            current = current.next;
        }
        System.out.println("La cantidad de elementos en la lista: " + cant);
    }
}
public class LIFO {
    public static void main(String[] args) {
        LinkedListLifo list = new LinkedListLifo();
        list.insertStart(123, "juan", 12222, 21);
        list.insertStart(3423, "jose", 343, 33);

        list.showList();
        list.cantElements();

        list.deleteFirstElement();
        list.showList();
        list.cantElements();

    }
}
