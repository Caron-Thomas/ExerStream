package model;

public class DadosOscar {
    private Integer index;
    private Integer year;
    private Integer age;
    private String name;
    private String movie;
    private Gender sexo;

    public DadosOscar(int index, Integer year, int age, String name, String movie) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
         }

    public DadosOscar(int index, Integer year, int age, String name, String movie, Gender sexo) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.sexo = sexo;
    }

    public DadosOscar() {
    }

    public void setSexo(Gender sexo) {
        this.sexo = sexo;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public Gender getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return age + " anos / " +
            "em " + year+" ";
    }
}
