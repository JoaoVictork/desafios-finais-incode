package horaDePraticar2;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Módulo");
            System.out.println("6. Sair");
            System.out.print("Opção: ");

            if (scan.hasNextInt()) {
                int opcao = scan.nextInt();

                if (opcao == 6) {
                    System.out.println("Encerrando programa...");
                    scan.close();
                    System.exit(0);
                    break;
                }

                System.out.print("Digite o primeiro número: ");
                int num1 = scan.nextInt();
                System.out.print("Digite o segundo número: ");
                int num2 = scan.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Resultado: " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + (num1 * num2));
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("Erro: Divisão por zero não permitida.");
                        } else {
                            System.out.println("Resultado: " + (num1 / num2));
                        }
                        break;
                    case 5:
                        if (num2 == 0) {
                            System.out.println("Erro: Módulo por zero não permitido.");
                        } else {
                            System.out.println("Resultado: " + (num1 % num2));
                        }
                        break;

                }
            } else {
                System.out.println("Opção inválida. Escolha uma das opções disponíveis.");
                scan.next();
            }
        }
        scan.close();
    }
}