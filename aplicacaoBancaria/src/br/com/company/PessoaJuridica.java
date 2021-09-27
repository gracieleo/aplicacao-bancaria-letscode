package br.com.company;

import java.math.BigDecimal;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private final BigDecimal taxaTransferencia = BigDecimal.valueOf(1.005);
    private final BigDecimal rendimento = BigDecimal.valueOf(1.02);


    PessoaJuridica() {
    }

    PessoaJuridica(String nome, String CNPJ) {
        super(nome);
        cnpj = CNPJ;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String CNPJ) {
        this.cnpj = CNPJ;
    }

    public BigDecimal getTaxaTransferencia() {
        return taxaTransferencia;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }
}


