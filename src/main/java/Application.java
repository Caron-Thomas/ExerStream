import mappers.DadosDengueMapper;
import mappers.DadosOscarMapper;
import model.DadosDengue;
import model.DadosOscar;
import model.DengueSummary;
import service.DengueService;
import service.OscarService;
import util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {

        var fileUtil = new FileUtil<DadosDengue>("dengue-dataset.csv");
        var dadosDengue = fileUtil.readFile(new DadosDengueMapper());
        var dengueService = new DengueService(dadosDengue);


        var fileUtilFemale = new FileUtil<DadosOscar>("oscar_age_female.csv");
        List<DadosOscar>  dadosOscarF = fileUtilFemale.readFile(new DadosOscarMapper());
        var dadosOscarFemale = new OscarService(dadosOscarF, "female");

        var fileUtilMale = new FileUtil<DadosOscar>("oscar_age_male.csv");
        List<DadosOscar> dadosOscarM = fileUtilMale.readFile(new DadosOscarMapper());
        var dadosOscarMale = new OscarService(dadosOscarM, "male");

        var dadosOscarTodos = new OscarService();
        dadosOscarTodos.addLists(dadosOscarFemale.getDadosOscars(), dadosOscarMale.getDadosOscars());


        dadosOscarTodos.printOscarSummary();
        //dadosOscarFemale.printOscarSummary();
        //dadosOscarMale.printOscarSummary();

        //dengueService.printAnoMaiorQtdCasos();
        //dengueService.printSumarioCasos();

        // exercicios
        // 1 - Importar dataset
        // 2 - Criar model que represente os dados
        // 3 - Transformar os dois arquivos em apenas 1 stream
        // 4 - Ator mais jovem a ser premiado
        // 5 - Ator com maior qtd de prêmios
    }
}
