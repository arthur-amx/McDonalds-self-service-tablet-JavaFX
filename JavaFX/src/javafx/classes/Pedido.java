package javafx.classes;

import java.util.ArrayList;

public class Pedido {

    public ArrayList<Produto> produtos = new ArrayList<>();
    private double valor;
    private Usuario cliente;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

}
