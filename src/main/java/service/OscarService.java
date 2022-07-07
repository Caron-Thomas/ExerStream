package service;

import model.DadosOscar;
import model.Gender;

import java.util.*;
import java.util.stream.Collectors;

public class OscarService {

    private List<DadosOscar> dadosOscars = new ArrayList<>();

    public OscarService() {
    }

    public OscarService(List<DadosOscar> dadosOscar, String gender) {
        this.dadosOscars = (dadosOscar);
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
        this.dadosOscars.stream()
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

    public void printAtorAtrizMaisJovem() {

        var atorAtrizMaisJovem = dadosOscars.stream()
                .collect(Collectors.groupingBy(d ->
                                    d.getAge(),
                                    Collectors.groupingBy(DadosOscar::getName)))
                .entrySet().stream()
                .min(Map.Entry.comparingByKey());


        atorAtrizMaisJovem.ifPresent(c -> System.out.printf("O ator mais jovem a vencer o oscar foi: %s\n",
                c.getValue(), c.getKey()));

    }

    public void printAtorAtrizMaisJovem1() {

        var atorAtrizMaisJovem1 = dadosOscars.stream()
                   .min(Comparator.comparing(c -> c.getAge()));

        atorAtrizMaisJovem1.ifPresent(c -> System.out.printf("O ator mais jovem a vencer o oscar foi: %s \n",
               c.getName()));

    }

    public void printAtorAtrizMaisJovem2() {

        var atorMaisJovem = dadosOscars.stream()
                .filter(e -> e.getSexo().equals(Gender.MALE))
                .min(Comparator.comparing(i -> i.getAge()));

        var atrizMaisJovem = dadosOscars.stream()
                .filter(e -> e.getSexo().equals(Gender.FEMALE))
                .min(Comparator.comparing(i -> i.getAge()));


        atorMaisJovem.ifPresent(c -> System.out.printf("O ator mais jovem a vencer o oscar foi: %s com %d anos!\nPelo filme %s que foi ao cinemas em %d! ",
                c.getName(), c.getAge(), c.getMovie(),c.getYear()));
        atrizMaisJovem.ifPresent(c -> System.out.printf("\nA atriz mais jovem a vencer o oscar foi: %s com %d anos!\nPelo filme %s que foi ao cinemas em %d!",
                c.getName(), c.getAge(), c.getMovie(), c.getYear()));

    }
}
