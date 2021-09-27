package br.com.company;

import java.math.BigDecimal;

public class PessoaFisica extends Cliente {
    private String cpf;
    private final BigDecimal taxaTransferencia = BigDecimal.valueOf(1);
    private final BigDecimal rendimento = BigDecimal.valueOf(1);

    PessoaFisica() {
    }

    PessoaFisica(String nome, String CPF) {
        super(nome);
        this.cpf = CPF;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public BigDecimal getTaxaTransferencia() {
        return taxaTransferencia;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }
}
