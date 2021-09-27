package br.com.company;

import java.math.BigDecimal;

public class Cliente {
    private String nome;
    private final BigDecimal taxaTransferencia = BigDecimal.valueOf(1);
    private final BigDecimal rendimento = BigDecimal.valueOf(1);
    Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getTaxaTransferencia() {
        return taxaTransferencia;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }
}
