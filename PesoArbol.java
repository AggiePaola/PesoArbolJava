import java.util.LinkedList;
import java.util.Queue;

class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class PesoArbol {
    Nodo raiz;
    public int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = calcularAltura(nodo.izquierda);
        int alturaDerecha = calcularAltura(nodo.derecha);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public void crearArbolPredefinido() {
        // Crear el árbol manualmente
        // Nivel 1
        this.raiz = new Nodo(1);
        // Nivel 2
        this.raiz.izquierda = new Nodo(2);
        this.raiz.derecha = new Nodo(3);
        // Nivel 3
        this.raiz.izquierda.izquierda = new Nodo(4);
        this.raiz.izquierda.derecha = new Nodo(5);
        this.raiz.derecha.izquierda = new Nodo(6);
        this.raiz.derecha.derecha = new Nodo(7);
        // Nivel 4
        this.raiz.izquierda.izquierda.izquierda = new Nodo(8);
        this.raiz.izquierda.izquierda.derecha = new Nodo(9);
        this.raiz.izquierda.derecha.izquierda = new Nodo(10);
        this.raiz.izquierda.derecha.derecha = new Nodo(11);
        this.raiz.derecha.izquierda.izquierda = new Nodo(12);
        this.raiz.derecha.izquierda.derecha = new Nodo(13);
        // Nivel 5
        this.raiz.derecha.izquierda.derecha.izquierda = new Nodo(14);
        this.raiz.derecha.izquierda.derecha.derecha = new Nodo(15);
        this.raiz.izquierda.izquierda.izquierda.izquierda = new Nodo(16);
        this.raiz.izquierda.izquierda.izquierda.derecha = new Nodo(17);
        // Nivel 6
        this.raiz.izquierda.izquierda.izquierda.izquierda.izquierda = new Nodo(18);
        this.raiz.izquierda.izquierda.izquierda.izquierda.derecha = new Nodo(19);
        // Nivel 7
        this.raiz.izquierda.izquierda.izquierda.izquierda.izquierda.izquierda = new Nodo(20);
    }

    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);
        int altura = calcularAltura(raiz);
        int nivel = 0;
        while (!queue.isEmpty() && nivel <= altura) {
            int tamaño = queue.size();
            int espacios = (int) Math.pow(2, altura - nivel) - 1;
            int espacioEntreNodos = (espacios + 1) / 2;

            System.out.print(" ".repeat(espacioEntreNodos));

            for (int i = 0; i < tamaño; i++) {
                Nodo nodo = queue.poll();
                if (nodo != null) {
                    System.out.print(nodo.valor);
                    queue.add(nodo.izquierda);
                    queue.add(nodo.derecha);
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }
                System.out.print((" ").repeat(espacioEntreNodos)); // Imprimir espacios entre nodos
            }
            nivel++;
            System.out.println();
        }
    }

    public int contarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0; //no hay nodo
        }
        // Contar el nodo actual más los nodos de las ramas izquierda y derecha
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    public int calcularPeso(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        //sumar nodo actual
        int pesoIzquierda = calcularPeso(nodo.izquierda);
        int pesoDerecha = calcularPeso(nodo.derecha);

        return nodo.valor + pesoIzquierda + pesoDerecha;
    }



    public static void main(String[] args) {
        PesoArbol arbol = new PesoArbol();
        // Crear el árbol predefinido
        arbol.crearArbolPredefinido();
        // Imprimir el árbol visualmente
        arbol.imprimirArbol();
        // Calcular y mostrar la altura del árbol
        int altura = arbol.calcularAltura(arbol.raiz);
        System.out.println("La altura del árbol es: " + altura);
        // #nodos
        int numeroNodos = arbol.contarNodos(arbol.raiz);
        System.out.println("El número de nodos en el árbol es: " + numeroNodos);
        //peso
        int peso = arbol.calcularPeso(arbol.raiz);
        System.out.println("El peso del árbol es: " + peso);
    }
}
