package model;

public class Software {
    private int idSoftware;
    private String nome;
    private String versao;
    private String desenvolvedor;
    private String sistemaOperacional;
    private Licenca licenca;
    private String descricao;
    private String categoria;

    public Software() {
    }

    public Software(int idSoftware, String nome, String versao,
                      String desenvolvedor, String sistemaOperacional,
                      Licenca licenca, String descricao,
                      String categoria) {

        this.idSoftware = idSoftware;
        this.nome = nome;
        this.versao = versao;
        this.desenvolvedor = desenvolvedor;
        this.sistemaOperacional = sistemaOperacional;
        this.licenca = licenca;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public int getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(int idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getLicenca() {
        return licenca.getValor();
    }

    public void setLicenca(Licenca licenca) {
        this.licenca = licenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        
        this.categoria = categoria;
    }
}
