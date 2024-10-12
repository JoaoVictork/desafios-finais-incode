package etapa2.horaDePraticar;

import java.util.ArrayList;

public class Estacionamento {
    private int vagas;
    private ArrayList<Ticket> tickets;
    private double saldo;

    public Estacionamento(int vagas){
        this.vagas = vagas;
        this.saldo = 0;
        this.tickets = new ArrayList<>();
    }

    public Ticket emitirTicket(){
        if(tickets.size() < vagas){
            Ticket novoTicket =  new Ticket();
            tickets.add(novoTicket);
            return novoTicket;
        }
        else{
            System.out.println("Não há vagas disponíveis.");
            return null;
        }
    }

    public double pagarTicket(Ticket ticketParaPagar){
        if(ticketParaPagar != null && !ticketParaPagar.estaPago()){
            ticketParaPagar.pagarTicket();
            saldo += ticketParaPagar.getValor();
            System.out.println("Ticket pago com sucesso.\n");
            System.out.printf("Valor do ticket: R$ %.1f\n",ticketParaPagar.getValor());
            System.out.printf("Saldo atual: R$ %.2f\n",saldo);
            return saldo;
        }
        else {
            System.out.println("Ticket já pago ou inexistente.");
            return 0;
        }
    }

    public double consultarSaldo(){
        return saldo;
    }

    public Ticket buscarTicket(int id){
        for (Ticket ticketId : tickets){
            if (ticketId.getId() == id){
                return ticketId;
            }
        }
        return null;
    }

    public void verificar(int ticket){
        for (Ticket verificador : tickets){
            if (verificador.estaPago()){
                System.out.println("O ticket está pago.\n");
            }
            else {
                System.out.println("o ticket está pendente ou não existe.");
            }
        }
    }
}