package mappers;

import model.DadosOscar;
import model.Gender;

import javax.naming.MalformedLinkException;
import java.time.LocalDate;
import java.util.function.Function;

public class DadosOscarMapper implements Function<String, DadosOscar> {


    public DadosOscar apply(String o){
        var dadosEmLinha = o.split(";");
        var index = Integer.parseInt(dadosEmLinha[0].trim());
        Integer year = Integer.parseInt(dadosEmLinha[1].trim());
        var age = Integer.parseInt(dadosEmLinha[2].trim());
        var name = dadosEmLinha[3].trim();
        var movie = dadosEmLinha[4].trim();

        return new DadosOscar(index, year, age, name, movie);
    }
}
