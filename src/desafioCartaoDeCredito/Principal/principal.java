package desafioCartaoDeCredito.Principal;

import desafioCartaoDeCredito.modelo.Cartao;
import desafioCartaoDeCredito.modelo.Compra;

import java.util.Collections;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("=================");
        System.out.println("Seja bem vindo ao sistema de Compras!");
        System.out.println("=================");
        System.out.println("Qual seu nome?");
        String nomeCliente = leitor.nextLine();
        System.out.println("Digite o limite do seu cartão, " + nomeCliente + "!");
        double limite = leitor.nextDouble();
        Cartao cartao = new Cartao(limite);


        int sair =1;
        while(sair != 0){
            System.out.println("Digite a descrição da compra, " + nomeCliente + "!");
            String descricao = leitor.next();

            System.out.println("Digite o valor da compra, " + nomeCliente + "!");
            double valor = leitor.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitor.nextInt();
            }
            else{
                System.out.println("\nSaldo insuficiente!");
                sair = 0;
            }

            System.out.println("***********************");
            System.out.println("COMPRAS REALIZADAS:");
            Collections.sort(cartao.getCompras());
            for (Compra c : cartao.getCompras()) {
                System.out.println(c.getDescricao() + " - " +c.getValor());
            }
            System.out.println("***********************");

            System.out.println("\nSaldo do cartão: " +cartao.getSaldo());

        }
    }
}