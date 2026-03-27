import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }

    public void menuPrincipal(){
        
        int opcao = -1;

        try (Scanner scanner =new Scanner(System.in)) {
            while (opcao != 0) {
                System.out.println("-------------------------------");
                System.out.println("Menu Principal");
                System.out.println("[1] Gerenciar Veiculos");
                System.out.println("[2] Consultar");
                System.out.println("[0] Sair");
                System.out.println("------------------------------");

                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("digite um número inteiro");
                }

                switch (opcao) {
                    case 1:
                        GerenciadorVeiculo gv = new GerenciadorVeiculo();
                        gv.menu();
                        break;
                    case 2:
                        //vendedor
                        break;
                    case 0:
                        System.out.println("saindo!!!");
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }
}
