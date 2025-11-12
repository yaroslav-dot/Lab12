interface Tool {
    void use();
}

class Hammer implements Tool {
    @Override
    public void use() {
        System.out.println("Забиваю гвоздь");
    }
}

class Screwdriver implements Tool {
    @Override
    public void use() {
        System.out.println("Закручиваю винт");
    }
}

public class Main {
    public static void main(String[] args) {
        Tool hammer = new Hammer();
        Tool screwdriver = new Screwdriver();
        
        hammer.use();
        screwdriver.use();
    }
}