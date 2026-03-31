public class Vendedor {
    private int codigo;
    private String nome;
    private String email;
    private int vendas;
    private VendedorEnum status;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getVendas() {
        return vendas;
    }
    public void setVendas(int vendas) {
        this.vendas = vendas;
    }
    public VendedorEnum getStatus() {
        return status;
    }
    public void setStatus(VendedorEnum status) {
        this.status = status;
    }

    
}
