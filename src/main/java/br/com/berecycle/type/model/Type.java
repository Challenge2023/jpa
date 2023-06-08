package br.com.berecycle.type.model;

public enum Type {
    DOADOR("Doador"),
    BENEFICIARIO("Beneficiário"),
    TRANSPORTADOR("Transportador");

    private String type;

    Type(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
