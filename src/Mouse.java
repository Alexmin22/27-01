public class Mouse {
    double lenghth;
    String name;
    int age;

    public Mouse(double lenghth, String name, int age) {
        this.lenghth = lenghth;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "lenghth=" + lenghth +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
