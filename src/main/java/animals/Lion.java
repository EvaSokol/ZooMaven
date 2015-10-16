package animals;

public class Lion extends Animal implements Jump, Cloneable {
    public int JumpHeight = 3;

    public Lion(String type, int age, int height, String color, String name, String sex) {
        super(type, age, height, color, name, sex);

    }

    @Override
    public void jump() {
        System.out.println("- I'm jumping for " + JumpHeight + " meters!");
    }

    public void voice() {
        System.out.println("- Rrrrrrr!!!");
    }

    public void move(int steps) {
        System.out.println(color + " animals.Wolf has run " + steps + " steps.");
    }


    @Override
    protected Wolf clone() throws CloneNotSupportedException {
        return new Wolf(this.type, this.age, this.height, this.color, this.name, this.sex);
    }

    @Override
    public void getAnimalDescription() {
        System.out.println("It's a lion");
        super.getAnimalDescription();
        if (!sex.contains("female"))
            System.out.println("He can jump for " + JumpHeight + " meters");
        else
            System.out.println("She can jump for " + JumpHeight + " meters");
        System.out.println("--------------------------");
    }
}
