package br.com.company;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    private BigDecimal carteiraInvestimento;

    public ContaInvestimento(int numeroConta, Cliente cliente, BigDecimal valor) {
        super(numeroConta, cliente);
        this.carteiraInvestimento = valor;
    }
    public void investir(BigDecimal valor){
        this.carteiraInvestimento = carteiraInvestimento.add(valor);
        System.out.println("Investido um total de R$ "+valor.toString());
    }
    public BigDecimal sacar(BigDecimal valor) {
        if (consultarSaldo().compareTo(valor) == -1) {
            System.out.println("Valor insuficiente.");
            return BigDecimal.ZERO;
        } else {
            this.carteiraInvestimento = carteiraInvestimento.subtract(valor);
            System.out.println("Retirado: " + valor.toString());
            return valor;
        }
    }

        public BigDecimal consultarSaldo() {
            return carteiraInvestimento;
        }
        public void setCarteiraInvestiemnto(BigDecimal carteiraInvestimento){
            this.carteiraInvestimento = carteiraInvestimento;
        }

        @Override
        public Cliente getCliente () {
            return super.getCliente();
        }

}

