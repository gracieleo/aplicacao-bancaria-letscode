package br.com.company;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
public class Aplicacao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" *** Aplicação Bancária ***  ");
        ArrayList<Cliente> listaClientes = new ArrayList<>(0);
        ArrayList<Conta> listaContas = new ArrayList<>(0);
        int n = 1;
        do {
            System.out.println("Digite uma das opções para começar as operações ou digite 0 para sair.");
            System.out.println("1-Abrir conta");
            System.out.println("2-Operar Conta");
            n = teclado.nextInt();
            if (n == 1) {
                Cliente cliente = cadastrarCliente();
                listaClientes.add(cliente);
                Conta conta = abrirConta1(cliente, listaContas.size()+1);
                listaContas.add(conta);
                System.out.println("Conta cadastrada com o número: " + listaContas.size());
            }
            if (n == 2) {
                System.out.println("Digite o número da conta: ");
                int numeroConta = teclado.nextInt();
                for (Conta c : listaContas) {
                    if (numeroConta== c.getNumeroConta()) {
                        System.out.println("Digite a operação desejada: ");
                        System.out.println("1-Sacar\n2-Depositar\n3-Transferir\n4-Investir\n5-Consultar saldo");
                        int opcao = teclado.nextInt();
                        switch (opcao) {
                            case 1:
                                System.out.println("Digite um valor para sacar: ");
                                BigDecimal valor = teclado.nextBigDecimal();
                                if (c instanceof ContaCorrente) {
                                    ((ContaCorrente) c).sacar(valor);
                                }
                                if (c instanceof ContaInvestimento) {
                                    ((ContaInvestimento) c).sacar(valor);
                                }
                                if (c instanceof ContaPoupanca) {
                                    ((ContaPoupanca) c).sacar(valor);
                                }
                                break;
                            case 2:
                                System.out.println("Digite um valor para depositar: ");
                                BigDecimal valorDeposito = teclado.nextBigDecimal();
                                if (c instanceof ContaCorrente) {
                                    ((ContaCorrente) c).depositar(valorDeposito);
                                    ;
                                }
                                if (c instanceof ContaInvestimento) {
                                    ((ContaInvestimento) c).investir(valorDeposito);
                                }
                                if (c instanceof ContaPoupanca) {
                                    ((ContaPoupanca) c).depositar(valorDeposito);
                                }
                                break;
                            case 3:
                                if (c instanceof ContaCorrente) {
                                    System.out.println("Digite o número da conta para a qual deseja transferir:");
                                    int contaTransferencia = teclado.nextInt();
                                    System.out.println("Digite o valor a ser transferido: ");
                                    BigDecimal valorTransferencia = teclado.nextBigDecimal();
                                    ((ContaCorrente) c).transferir((ContaCorrente)listaContas.get(contaTransferencia-1), valorTransferencia);
                                } else
                                    {System.out.println("Conta não disponível para transferencia.");}
                                    break;
                                    case 4:
                                        System.out.println("Digite o número da conta para a qual deseja investir:");
                                        int contaInvestimento = teclado.nextInt();
                                        if (c instanceof ContaInvestimento) {
                                            System.out.println("Digite o valor a ser investido: ");
                                            BigDecimal valorTransferencia = teclado.nextBigDecimal();
                                            ((ContaInvestimento) c).investir( valorTransferencia);
                                        } else
                                        {System.out.println("Conta não disponível para investimento.");}
                                        break;
                                    case 5:
                                        if (c instanceof ContaCorrente) {
                                            System.out.println("A conta contém R$ "+((ContaCorrente) c).consultarSaldo());
                                        }
                                        if (c instanceof ContaInvestimento) {
                                            System.out.println("A conta contém R$ "+((ContaInvestimento) c).consultarSaldo());
                                        }
                                        if (c instanceof ContaPoupanca) {
                                            System.out.println("A conta contém R$ "+((ContaPoupanca) c).consultarSaldo());
                                        }
                                        break;
                                    default:
                                        System.out.println("Entrada inválida.");
                                }
                                break;
                        }else System.out.println("Conta não encontrada.");
                    }

                }
            } while (n != 0) ;

        }

        public static Conta abrirConta1 (Cliente cliente,int indice ){
                Scanner teclado = new Scanner(System.in);
                Conta conta = new Conta();
                if (cliente.getRendimento().equals(BigDecimal.ONE)) {
                    System.out.println("Selecione o tipo de conta a abrir: ");
                    System.out.println("1-Conta Corrente\n2-Conta Poupança\n3-Conta Investimento");
                    int opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            conta = new ContaCorrente(indice, cliente, BigDecimal.ZERO);
                            System.out.println("Conta Corrente cadastrada.");
                            break;
                        case 2:
                            conta = new ContaPoupanca(indice, cliente, BigDecimal.ZERO);
                            System.out.println("Conta Poupança cadastrada.");
                            break;
                        case 3:
                            conta = new ContaInvestimento(indice, cliente, BigDecimal.ZERO);
                            System.out.println("Conta Investimento cadastrada.");
                            break;
                        default:
                            System.out.println("Entrada inválida.");
                    }
                } else {
                    System.out.println("Selecione o tipo de conta a abrir: ");

                    System.out.println("1-Conta Corrente\n2-Conta Investimento\n");
                    int opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            conta = new ContaCorrente(indice, cliente, BigDecimal.ZERO);
                            System.out.println("Conta Corrente cadastrada.");
                            break;
                        case 2:
                            conta = new ContaInvestimento(indice, cliente, BigDecimal.ZERO);
                            System.out.println("Conta Investimento cadastrada.");
                            break;
                        default:
                            System.out.println("Entrada inválida.");
                    }
                }
                return conta;
            }
        private static Cliente cadastrarCliente () {
                Scanner teclado = new Scanner(System.in);
                System.out.println("Processo para abertura de conta inicializado.");
                System.out.print("Nome : ");
                String nome = teclado.nextLine();
                System.out.println("Digite 1 para Pessoa Fisica\nDigite 2 para Pessoa Juridica.\n");
                int m = teclado.nextInt();
                String cpf, cnpj;
                Cliente pessoa = new Cliente();
                if (m == 1) {
                    System.out.println("Digite o CPF do cadastrado:");
                    cpf = (String) teclado.next();
                    pessoa = new PessoaFisica(nome, cpf);
                }
                if (m == 2) {
                    System.out.println("Digite o CNPJ do cadastrado:");
                    cnpj = teclado.next();
                    pessoa = new PessoaJuridica(nome, cnpj);
                }
                return pessoa;
            }
}