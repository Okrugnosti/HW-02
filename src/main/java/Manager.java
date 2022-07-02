import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Persona {
    //список работников в подчинении
    ArrayList<Persona> list_employee = new ArrayList<Persona>();

    public Manager(String name, LocalDate birthday, LocalDate date_of_employment) {
        super(name, birthday, date_of_employment);
    }

    public void setList_employee(Persona persona) {
        this.list_employee.add(persona);
    }

    @Override
    public String getParam() {
        String param;
        param = this.getClass() +
                " Name: " + this.name +
                " Birthday: " + this.birthday.toString() +
                " Date_of_employment: " + this.date_of_employment.toString() +
                " My_Employee: ";

        for (Persona object : list_employee) {

            param += object.getName() + " ";
        }
        return param;
    }

}
