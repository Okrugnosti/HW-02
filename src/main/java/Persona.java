import java.time.*;

/*
1)	Работник:
ФИО
Дата рождения
Дата принятия на работу

2) Менеджер
ФИО
Дата рождения
Дата принятия на работу
Список работников в подчинении данного менеджера

3) Другие (руководство, секретари и т.д.)
ФИО
Дата рождения
Дата принятия на работу
Текстовое описание сотрудника
 */

public abstract class Persona {
    String name;
    LocalDate birthday;
    LocalDate date_of_employment;

    public Persona(String name, LocalDate birthday, LocalDate date_of_employment) {
        this.name = name;
        this.birthday = birthday;
        this.date_of_employment = date_of_employment;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDate_of_employment() {
        return date_of_employment;
    }

    public String getParam() {

        String param;
        param = this.getClass() +
                " Name: " + this.name +
                " Birthday: " + this.birthday.toString() +
                " Date_of_employment: " + this.date_of_employment.toString();

        return param;
    }
}
