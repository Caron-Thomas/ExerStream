package model;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino");

    private String descricao;

    Gender(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
