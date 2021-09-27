package br.com.company;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{
    private BigDecimal saldo;

    public ContaCorrente(int numeroConta,Cliente cliente,BigDecimal saldo) {
        super(numeroConta,cliente);
        this.saldo = saldo;
    }
    public BigDecimal sacar(BigDecimal valor){
        if(consultarSaldo().compareTo(valor)==-1){
            System.out.println("Valor insuficiente.");
            return BigDecimal.ZERO;
        }
        else {
            this.saldo = saldo.subtract(valor);
            System.out.println("Retirado: " + valor.toString());
            return valor;
        }
    }
    public void transferir(ContaCorrente conta,BigDecimal valor){
        if(consultarSaldo().compareTo(valor.multiply(getCliente().getTaxaTransferencia())) < 0){
            System.out.println("Valor insuficiente.");
        }
        else {
            this.saldo = saldo.subtract(valor.multiply(BigDecimal.valueOf(1.005)));
            conta.depositar(valor);
            System.out.println("Transferido: " + valor.toString());
        }
    }

    public void depositar(BigDecimal valor) {
        this.saldo = saldo.add(valor);
        System.out.println("Depositado: "+valor.toString());
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
