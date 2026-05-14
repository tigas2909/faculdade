package model;

public enum Licenca {

    GRATUITO("Gratuito"),
    PAGO("Pago"),
    OPEN_SOURCE("Open Source");

    private final String valor;

    Licenca(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Licenca fromString(String texto) {
        for (Licenca licenca : Licenca.values()) {
            if (licenca.getValor().equalsIgnoreCase(texto)) {
                return licenca;
            }
        }
        throw new IllegalArgumentException("Licença inválida: " + texto);
    }
}