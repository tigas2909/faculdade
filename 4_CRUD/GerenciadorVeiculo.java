import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo{
    Scanner scanner;
    DaoVeiculo daoVeiculo;
    Veiculo v;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }
    public void menu(){
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("-------------------------------");
            System.out.println("Gerenciador de veiculos");
            System.out.println("[1] Cadatrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar todos");
            System.out.println("[0] Sair");
            System.out.println("------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("digite um número inteiro");
            }

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    System.out.println("digite o codigo do veiculo: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    this.consultar(codigo);
                    break;
                case 3:
                    this.alterar();
                    break;
                case 4:
                    System.out.println("digite o codigo do veiculo: ");
                    this.excluir(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    this.listarTudo();
                    break;
                case 0:
                    System.out.println("saindo!!!");
                default:
                    break;
            }
        }
    }

    private void cadastrar(){
        int codigo, ano;
        String Marca, modelo, chassi;

        //pegando os dados

        //pegando o codigo
        System.out.println("digite codigo do veiculo: ");
        codigo = Integer.parseInt(scanner.nextLine());

        //pegando a marca
        System.out.println("digite a marca do veiculo: ");
        Marca = scanner.nextLine();

        //pegando o modelo
        System.out.println("digite o modelo do veiculo: ");
        modelo = scanner.nextLine();
        
        //pegando o chassi
        System.out.println("digite o chassi do veiculo: ");
        chassi = scanner.nextLine();

        //pegando o ano
        System.out.println("digite o ano do veiculo: ");
        ano = Integer.parseInt(scanner.nextLine());

        v = new Veiculo();
        v.setAno(ano);
        v.setChassi(chassi);
        v.setCodigo(codigo);
        v.setMarca(Marca);
        v.setModelo(modelo);

        boolean result = daoVeiculo.inserir(v);
        if (result) {
            System.out.println("carro cadastrado com sucesso");
        }else{
            System.out.println("carro não foi cadastrado ... tente novamente");
        }
    }

    private void consultar(int codigo){
        ArrayList<Veiculo> veiculo = daoVeiculo.selectById(codigo);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("veiculos selecionado");
        for( Veiculo v : veiculo ){
            System.out.println("| codigo: "+ v.getCodigo() + " | Marca: " + v.getMarca() + " | Modelo: " + v.getModelo() + " | Chassi: " + v.getChassi() + " | Ano: " + v.getAno() + " |");
        }
    }

    private void listarTudo(){
        ArrayList<Veiculo> veiculo = daoVeiculo.select();

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("veiculos cadastrado");
        for( Veiculo v : veiculo ){
            System.out.println("| codigo: "+ v.getCodigo() + " | Marca: " + v.getMarca() + " | Modelo: " + v.getModelo() + " | Chassi: " + v.getChassi() + " | Ano: " + v.getAno() + " |");
        }
    }
    private  void excluir(int codigo){
        int resultado = daoVeiculo.delete(codigo);
        if(resultado == 1){
            System.out.println("item excluido com sucesso");
        }else{
            System.out.println("erro no excluir");
        }
    }

    private boolean teste(String teste){
        
    }
    private void alterar(){

    }

}