abstract class Tool {
    protected String name; 

    public Tool(String name) {
        this.name = name;
    }
    public Tool(){}

    public abstract void use();
}




class Hammer extends Tool {
    @Override
    public void use() {
        System.out.println("Молоток: забивает гвозди.");

    }
}

class Screwdriver extends Tool {
    @Override
    public void use() {
        System.out.println("Отвёртка: закручивает винты.");
    }
}

public class Main {
    public static void main(String[] args) {
        Tool[] tools = { new Hammer(), new Screwdriver() };
        for (Tool tool : tools) {
            tool.use();
        }
        


        
}

    }

