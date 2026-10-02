import java.util.Scanner;

public class Tematica_02 {

    static final int totalFila = 10;
    static String[] fila = new String[totalFila];
    static int inicio = 0;
    static int fim = 0;
    static int tamanho = 0;
    static int numeroPedido = 1;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n-- Escolha uma das opções --");
            System.out.println("(1) - Adicionar novo pedido");
            System.out.println("(2) - Processar pedido mais antigo");
            System.out.println("(3) - Exibir pedidos na fila");
            System.out.println("(4) - Sair");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    enqueue(entrada);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    exibirFila();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        entrada.close();
    }

    static void enqueue(Scanner entrada) {
        if (tamanho == totalFila) {
            System.out.println("A fila está cheia! Não é possível adicionar mais pedidos.");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String cliente = entrada.nextLine();

        System.out.print("Digite a descrição do pedido: ");
        String descricao = entrada.nextLine();

        fila[fim] = "Pedido #" + numeroPedido + " - " + cliente + " - " + descricao;
        fim = (fim + 1) % totalFila;
        tamanho++;

        System.out.println("Pedido #" + numeroPedido + " adicionado à fila.");
        numeroPedido++;
    }

    static void dequeue() {
        if (tamanho == 0) {
            System.out.println("A fila está vazia! Não há pedidos para processar.");
            return;
        }

        String pedido = fila[inicio];
        fila[inicio] = null;
        inicio = (inicio + 1) % totalFila;
        tamanho--;

        System.out.println("Pedido processado: " + pedido);
    }

    static void exibirFila() {
        if (tamanho == 0) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("Pedidos na fila:");
        for (int i = 0; i < tamanho; i++) {
            int posicao = (inicio + i) % totalFila;
            System.out.println((i + 1) + "º - " + fila[posicao]);
        }
    }
}