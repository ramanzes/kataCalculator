
public class ClassesAndObjects {
    public static void main(String[] args) {

    Person person1 = new Person();
    person1.name = "Roman";
    person1.age = 42;
    person1.speak(true);
    person1.sayPrivet();
    System.out.println(person1.calculateYearsToRetirement());
    }
}

class Person{
    String name;
    int age;
    int calculateYearsToRetirement(){
        int years = 65 - age;
//        System.out.println("количество лет до пенсии: "+years);
        return years;
    }
    void speak(boolean v){
        for(int i=0; i<3; i++) {
            System.out.println("Меня зовут " + name + ", мне: " + age + " и во чё " + v);
        }
    }
    void sayPrivet(){
        System.out.println("Привет!");
    }
}