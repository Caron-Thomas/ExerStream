package service;

import model.DadosOscar;
import model.Gender;

import java.util.*;

public class OscarService {

    private List<DadosOscar> dadosOscars = new ArrayList<>();

    public OscarService() {
    }

    public OscarService(List<DadosOscar> dadosOscar, String gender) {
        dadosOscars.addAll(dadosOscar);
        if(gender == "female"){
           for (DadosOscar d: dadosOscars) {
                d.setSexo(Gender.FEMALE);
            }
        } else if (gender == "male"){
            for (DadosOscar d: dadosOscar) {
                d.setSexo(Gender.MALE);
            }
        }
    }

    public void printOscarSummary(){
        dadosOscars.stream()
                //.forEach(System.out::println);
                .forEach(i -> System.out.printf("Ano: %d nome: %-23s Sexo: %s idade: %d Filme: %s\n",
                        i.getYear(), i.getName(), i.getSexo().getDescricao(), i.getAge(), i.getMovie()));
    }

    public void addLists(List<DadosOscar> a, List<DadosOscar> b){
        this.dadosOscars.addAll(a);
        this.dadosOscars.addAll(b);
    }

    public List<DadosOscar> getDadosOscars() {
        return dadosOscars;
    }
}
