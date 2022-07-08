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


        atorMaisJovem.ifPresent(c -> System.out.printf("\nO ator mais jovem a vencer o oscar foi: %s com %d anos!\nPelo filme %s que foi ao cinemas em %d! ",
                c.getName(), c.getAge(), c.getMovie(),c.getYear()));
        atrizMaisJovem.ifPresent(c -> System.out.printf("\nA atriz mais jovem a vencer o oscar foi: %s com %d anos!\nPelo filme %s que foi ao cinemas em %d!",
                c.getName(), c.getAge(), c.getMovie(), c.getYear()));

    }

    public void printAtorAtrizComMaisPremios(){
        var atorAtrizMaisPremiado = dadosOscars.stream()
                .collect(Collectors.groupingBy(i -> i.getName(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        atorAtrizMaisPremiado.ifPresent(i -> System.out.printf("Ator/Atriz Mais premiado foi %s com %d Oscars", i.getKey(), i.getValue() ));

        var atorMaisPremiado = dadosOscars.stream()
                .filter(d -> d.getSexo().equals(Gender.MALE))
                .collect(Collectors.groupingBy(i -> i.getName(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        atorMaisPremiado.ifPresent(i -> System.out.printf("\nO ator mais premiado foi %s com %d Oscars!", i.getKey(), i.getValue()));
    }

    public void atorAtrizMaisPremiado1824() {
        var atorAtrizMaisPremiadoEntre18e24 = dadosOscars.stream()
                .filter(i -> i.getAge() >=18 && i.getAge() <= 24)
                .collect(Collectors.groupingBy(s -> s.getName(), Collectors.counting()))
                .entrySet().stream()
//                .collect(Collectors.toMap(x -> {
//                   int qtdOscars =
//                }))
                //.max(Map.Entry.comparingByValue());
                .max(Map.Entry.comparingByValue());

        if (atorAtrizMaisPremiadoEntre18e24.stream().toArray().length == 1){
            atorAtrizMaisPremiadoEntre18e24.ifPresent(i -> System.out.printf("O ator(triz) jovem mais premiado foi %s com %d Oscars",
                    i.getKey(), i.getValue()));
            } else {
            System.out.print("Os atores jovens mais premiados foram:");
            atorAtrizMaisPremiadoEntre18e24.stream()
                    .forEach(i -> System.out.printf("\n%s com %d Oscars", i.getKey(), i.getValue()));
        }
    }
}
