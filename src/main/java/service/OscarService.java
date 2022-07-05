package service;

import model.DadosOscar;
import model.Gender;

import java.util.*;

public class OscarService {

    private List<DadosOscar> dadosOscars = new ArrayList<>();
    private List<DadosOscar> dadosTotais = new ArrayList<>();

    public OscarService() {
    }

    public OscarService(List<DadosOscar> dadosOscar, String gender) {
        dadosOscars.addAll(dadosOscar);

    }

    public void addLists(List<DadosOscar> a, List<DadosOscar> b){
        dadosTotais.addAll(a);
        dadosTotais.addAll(b);
    }

    public void printOscarSummary(){
        dadosTotais.stream()
                //.forEach(System.out::println);
                .forEach(i -> System.out.printf("Ano: %d nome: %-23s Sexo: %s idade: %d Filme: %s\n",
                        i.getYear(), i.getName(), i.getSexo().getDescricao(), i.getAge(), i.getMovie()));
    }

    public void setGender(List<DadosOscar> dados, String gender) {
        for (DadosOscar d: dados) {
            d.setSexo(gender.equals("female") ? Gender.FEMALE : Gender.MALE);
        }
    }
}
