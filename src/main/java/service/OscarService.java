package service;

import model.DadosOscar;
import model.Gender;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OscarService {

    private List<DadosOscar> dadosOscars;
    private String gender;

    public OscarService(List<DadosOscar> dadosOscar, String gender) {
       this.dadosOscars = dadosOscar;
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

    public OscarService() {
    }

    public void printOscarSummary(){
        dadosOscars.stream()
                //.forEach(System.out::println);
                .forEach(i -> System.out.printf("Ano: %d nome: %-23s Sexo: %s idade: %d Filme: %s\n",
                        i.getYear(), i.getName(), i.getSexo().getDescricao(), i.getAge(), i.getMovie()));
    }

    public OscarService addLists(List<DadosOscar> a, List<DadosOscar> b){
        dadosOscars.stream()
                .toList()
                .addAll(b);

                return  dadosOscars;
    }
}
