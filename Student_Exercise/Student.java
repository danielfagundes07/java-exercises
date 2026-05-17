

package exercises.Student_Exercise;

public class Student {
    private String name;
    private int age;
    private Double grade;
    Student(String name, int age, Double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
            
        }
    

    public String getName(){
       return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Double getGrade() {
        return this.grade;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGrade(Double grade){
        this.grade = grade;
    }
    
    @Override
    public String toString() {
        return getName() + getAge() + getGrade();
    }
}
