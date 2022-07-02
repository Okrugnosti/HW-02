import java.time.LocalDate;

public class Other_Employee extends Persona {
    String description;

    public Other_Employee(String name, LocalDate birthday, LocalDate date_of_employment) {
        super(name, birthday, date_of_employment);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getParam() {
        String param;
        param = this.getClass() +
                " Name: " + this.name +
                " Birthday: " + this.birthday.toString() +
                " Date_of_employment: " + this.date_of_employment.toString() +
        " Description: " + description;

        return param;
    }
}
