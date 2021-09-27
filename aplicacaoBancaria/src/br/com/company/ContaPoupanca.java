package br.com.company;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    private BigDecimal carteiraPoupanca;

    public ContaPoupanca(int numeroConta, Cliente cliente,BigDecimal valor) {
        super(numeroConta, cliente);
        this.carteiraPoupanca = valor;
    }

    public void depositar(BigDecimal valor){
        this.carteiraPoupanca = carteiraPoupanca.add(valor);
        System.out.println("Valor total aplicado a carteira : R$ "+valor.toString());
    }
    public BigDecimal sacar(BigDecimal valor) {
        if (consultarSaldo().compareTo(valor) == -1) {
            System.out.println("Valor insuficiente.");
            return BigDecimal.ZERO;
        } else {
            this.carteiraPoupanca = carteiraPoupanca.subtract(valor);
            System.out.println("Retirado: " + valor.toString());
            return valor;
        }
    }
    public BigDecimal consultarSaldo() {
        return carteiraPoupanca;
    }
    public void setCarteiraPoupanca(BigDecimal carteiraPoupanca) {
        this.carteiraPoupanca = carteiraPoupanca;
    }

}
