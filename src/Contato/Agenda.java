package Contato;

import java.util.Scanner;

public class Agenda extends Contato {
    private Scanner sc = null;
    public void insertContact() {
        try {
            sc = new Scanner(System.in);
            System.out.println("CADASTRANDO USUARIOS");
            System.out.println("-------------------------------");
            System.out.print("Nome do contato para cadastro: ");
            String name = sc.nextLine();
            this.setNome(name);
            System.out.print("Numero da pessoa cadastrada: ");
            int number = sc.nextInt();
            this.setNumero(number);
            System.out.println("-------------------------------");
            insertContactFiles();
            System.out.println("Usuario "+ name + " cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closed();
        }
    }

    public void choices() {
        byte choice;
        sc = new Scanner(System.in);
        System.out.println("OLA SEJA BEM VINDO A SUA AGENDA");
        System.out.println("ESCOLHA UMA DAS OPCOES ABAIXO");
        System.out.println("O -> Sair, 1 -> listar contatos, 2 -> cadastrar contatos");
        choice = sc.nextByte();
        switch (choice) {
            case 1 : getAllContact();
            break;
            case 2 : insertContact();
            break;
            case 0 : sc.close();
            break;
            default:
                System.out.println("INFORME UMA OPCAO VALIDA");
        }

    }
    private void closed() {
        sc.close();
    }
}
