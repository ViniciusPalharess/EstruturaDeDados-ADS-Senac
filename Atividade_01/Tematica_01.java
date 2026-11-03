import java.util.Scanner;

public class Tematica_01 {

    static final int totalVetor = 10;
    static int[] vetor = new int[totalVetor];
    static int tamanho = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n-- Escolha uma das opções --");
            System.out.println("(1) - Inserir elementos em um vetor");
            System.out.println("(2) - Pesquisar um elemento no vetor");
            System.out.println("(3) - Excluir um elemento do vetor");
            System.out.println("(4) - Imprimir o vetor");
            System.out.println("(5) - Sair");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("(1) - Inserir na próxima posição livre do vetor");
                    System.out.println("(2) - Inserir na posição informada");

                    int opInserir = entrada.nextInt();

                    switch (opInserir) {
                        case 1:
                            inserirProximaPosicao(entrada);
                            break;
                        case 2:
                            inserirPosicaoInformada(entrada);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("(1) - Pesquisar pelo elemento informado");
                    System.out.println("(2) - Pesquisar pela posição do vetor");

                    int opPesquisar = entrada.nextInt();

                    switch (opPesquisar) {
                        case 1:
                            pesquisarPorElemento(entrada);
                            break;
                        case 2:
                            pesquisarPorPosicao(entrada);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("(1) - Excluir o elemento informado");
                    System.out.println("(2) - Excluir o elemento que está na posição informada");

                    int opExcluir = entrada.nextInt();

                    switch (opExcluir) {
                        case 1:
                            excluirPorElemento(entrada);
                            break;
                        case 2:
                            excluirPorPosicao(entrada);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    imprimirVetor();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        entrada.close();
    }

    static void inserirProximaPosicao(Scanner entrada) {
        if (tamanho == totalVetor) {
            System.out.println("O vetor está cheio! Não é possível inserir mais elementos.");
            return;
        }

        System.out.print("Digite o valor a ser inserido: ");
        int valor = entrada.nextInt();

        vetor[tamanho] = valor;
        tamanho++;

        System.out.println("Elemento inserido na posição " + (tamanho - 1) + ".");
    }

    static void inserirPosicaoInformada(Scanner entrada) {
        if (tamanho == totalVetor) {
            System.out.println("O vetor está cheio! Não é possível inserir mais elementos.");
            return;
        }

        System.out.print("Digite a posição onde deseja inserir (0 a " + tamanho + "): ");
        int posicao = entrada.nextInt();

        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição inválida.");
            return;
        }

        System.out.print("Digite o valor a ser inserido: ");
        int valor = entrada.nextInt();

        for (int i = tamanho; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }

        vetor[posicao] = valor;
        tamanho++;

        System.out.println("Elemento inserido na posição " + posicao + ".");
    }

    static void pesquisarPorElemento(Scanner entrada) {
        System.out.print("Digite o elemento que deseja pesquisar: ");
        int valor = entrada.nextInt();

        int posicaoEncontrada = -1;

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                posicaoEncontrada = i;
                break;
            }
        }

        if (posicaoEncontrada == -1) {
            System.out.println("Elemento não encontrado no vetor.");
        } else {
            System.out.println("Elemento encontrado na posição " + posicaoEncontrada + ".");
        }
    }

    static void pesquisarPorPosicao(Scanner entrada) {
        if (tamanho == 0) {
            System.out.println("O vetor está vazio.");
            return;
        }

        System.out.print("Digite a posição que deseja consultar (0 a " + (tamanho - 1) + "): ");
        int posicao = entrada.nextInt();

        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida.");
            return;
        }

        System.out.println("O elemento na posição " + posicao + " é: " + vetor[posicao]);
    }

    static void excluirPorElemento(Scanner entrada) {
        if (tamanho == 0) {
            System.out.println("O vetor está vazio.");
            return;
        }

        System.out.print("Digite o elemento que deseja excluir: ");
        int valor = entrada.nextInt();

        int posicaoEncontrada = -1;

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                posicaoEncontrada = i;
                break;
            }
        }

        if (posicaoEncontrada == -1) {
            System.out.println("Elemento não encontrado no vetor.");
            return;
        }

        deslocarEsquerda(posicaoEncontrada);
        System.out.println("Elemento removido com sucesso.");
    }

    static void excluirPorPosicao(Scanner entrada) {
        if (tamanho == 0) {
            System.out.println("O vetor está vazio.");
            return;
        }

        System.out.print("Digite a posição que deseja excluir (0 a " + (tamanho - 1) + "): ");
        int posicao = entrada.nextInt();

        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida.");
            return;
        }

        deslocarEsquerda(posicao);
        System.out.println("Elemento removido com sucesso.");
    }

    static void deslocarEsquerda(int posicao) {
        for (int i = posicao; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
    }

    static void imprimirVetor() {
        if (tamanho == 0) {
            System.out.println("O vetor está vazio.");
            return;
        }

        System.out.print("Vetor: [ ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("]");
    }
}