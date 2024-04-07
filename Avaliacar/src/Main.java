import java.util.Scanner;
import java.util.Random;

public class Main {

    // Método para sortear a porta premiada (entre 1, 2 ou 3)
    public static int portaPremiada() {
        Random random = new Random();
        int sortear = random.nextInt(3) + 1;
        return sortear;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();

        // Mensagem de boas-vindas
        System.out.println("Bem-vindo ao Jogo Monty Hall!");
        System.out.println("Escolha uma porta (1, 2 ou 3):");
        int portaEscolhida = scn.nextInt();

        // Verifica se a escolha da porta é válida
        if (portaEscolhida < 1 || portaEscolhida > 3) {
            System.out.println("Opção inválida. Escolha uma porta válida.");
        } else {
            // Encontra uma porta vazia para ser aberta pelo apresentador
            int portaVazia = -1;
            do {
                portaVazia = random.nextInt(3) + 1;
            } while (portaVazia == portaPremiada() || portaVazia == portaEscolhida);

            // Apresenta a porta aberta pelo apresentador
            System.out.println("O apresentador abriu a porta número " + portaVazia);

            // Pergunta ao jogador se deseja trocar de porta
            System.out.println("Deseja trocar de porta?");
            System.out.println("1 - SIM");
            System.out.println("2 - NÃO");
            int opcao = scn.nextInt();

            // Armazena a porta escolhida originalmente pelo jogador
            int portaEscolhidaOriginal = portaEscolhida;

            // Verifica a escolha do jogador (trocar ou manter)
            if (opcao == 1) {
                // Troca de porta
                do {
                    portaEscolhida = random.nextInt(3) + 1;
                } while (portaEscolhida == portaVazia || portaEscolhida == portaEscolhidaOriginal);

                // Verifica se a nova porta escolhida é a premiada
                if (portaEscolhida == portaPremiada()) {
                    System.out.println("Parabéns, você ganhou o prêmio!");
                } else {
                    System.out.println("Infelizmente, você não ganhou o prêmio.");
                }
            } else if (opcao == 2) {
                // Mantém a escolha original
                if (portaEscolhida == portaPremiada()) {
                    System.out.println("Parabéns, você ganhou o prêmio!");
                } else {
                    System.out.println("Infelizmente, você não ganhou o prêmio.");
                }
            } else {
                System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }
}
