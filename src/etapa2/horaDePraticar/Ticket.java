package etapa2.horaDePraticar;

public class Ticket {
    private static int contadorTicket = 0;
    private int idTicket;
    private double valorTicket;
    private boolean pago;

    public Ticket(){
        this.idTicket = ++contadorTicket;
        this.valorTicket = 10;
        this.pago = false;
    }
    public int getId(){ return idTicket; }
    public double getValor(){ return valorTicket; }
    public boolean estaPago(){ return pago; }
    public void pagarTicket(){ this.pago = true; }
}