package object;

public class Employee {
    private String name;
    private int age;
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        department.info();
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department.getName() +
                '}';
    }
}
