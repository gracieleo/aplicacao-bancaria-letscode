package br.com.company;

import java.math.BigDecimal;

public class Conta {
    private int numeroConta;
    private Cliente cliente;
    public Conta(){
    }

    public Conta(int numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    }

