package kata6.model;

public class Person {
    private final Integer Id;
    private final String name;
    private final Character gender;
    private final String birthDate;
    private final Float weight;
    private final String mail;
    
    public Person(int Id,String name,Character gender,String birthDate,
                    Float weight, String mail){
        this.Id=Id;
        this.gender=gender;
        this.birthDate=birthDate;
        this.weight=weight;
        this.mail=mail;
        this.name=name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Float getWeight() {
        return weight;
    }

    public String getMail() {
        return mail;
    }
    
}

