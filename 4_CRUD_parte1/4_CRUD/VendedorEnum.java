public enum VendedorEnum {
    ATIVO("ativo"),
    INATIVO("inativo");

    private String valor;

    VendedorEnum(String valor) {
        this.valor = valor;
    }
    
    public static VendedorEnum fromValor(String valor) {
    for (VendedorEnum status : VendedorEnum.values()) {
        if (status.getValor().equalsIgnoreCase(valor)) {
            return status;
        }
    }
    throw new IllegalArgumentException("Valor inválido para VendedorEnum: " + valor);
}

    public String getValor() {
        return valor;
    }
}