package etapa2.horaDePraticar;

import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaEstacionamento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vagas = 0;

        while(true){
            try {
                System.out.println("Digite o número de vagas \n");
                vagas = scan.nextInt();
                scan.nextLine();
                if (vagas <= 0){
                    System.out.println("Por favor, digite a quantidade de vagas corretamente.");
                }
                else {
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Por favor digite um número inteiro válido");
                scan.nextLine();
            }
        }

        Estacionamento maquina = new Estacionamento(vagas);
        while(true){
            try{
                System.out.print("""
                        1- emitir ticket
                        2- pagar ticket
                        3- consultar saldo
                        4- ver tickets
                        5- sair
                        Digite uma opção: 
                        """);
                int opcao = scan.nextInt();
                try {
                    switch (opcao){
                        case 1:
                            Ticket ticket = maquina.emitirTicket();
                            if (ticket != null){
                                System.out.println("Ticket emitido com sucesso!");
                            }
                            break;

                        case 2:
                            System.out.print("Digite o id do ticket:");
                            int id = scan.nextInt();
                            Ticket ticketPagar = maquina.buscarTicket(id);
                            if (ticketPagar != null){
                                maquina.pagarTicket(ticketPagar);
                            }
                            else {
                                System.out.println("Ticket não encontrado");
                            }
                            break;

                        case 3:
                            System.out.println("Saldo: R$" + maquina.consultarSaldo());
                            break;

                        case 4:
                            System.out.print("Id do ticket a ser consultado: ");
                            id = scan.nextInt();
                            maquina.verificar(id);
                            break;

                        case 5:
                            System.out.println("Saindo...");
                            System.exit(0);
                            scan.close();
                            break;
                        default:

                            System.out.println("Opção inválida");

                    }
                } catch (ConcurrentModificationException e) {
                    System.out.print(" \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
    }
}