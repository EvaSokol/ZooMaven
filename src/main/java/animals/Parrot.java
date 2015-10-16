package animals;

public class Parrot extends Animal implements Jump, Fly {

    public int FlyLength = 4;
    public int JumpHeight = 3;

    public Parrot(String type, int age, int height, String color, String name, String sex) {
        super(type, age, height, color, name, sex);
    }

    @Override
    public void fly() {
        System.out.println("- I can fly " + FlyLength + " hours!");
    }

    @Override
    public void jump() {
        System.out.println("- I'm jumping for " + JumpHeight + " santimeters!");
    }

    public void move(int steps) {
        System.out.println(color + " animals.Parrot has jumped " + steps + " steps.");
    }

    public void voice() {
        System.out.println("Durrrak!!!");
    }

    @Override
    public void getAnimalDescription() {
        System.out.println("It's a parrot");
        super.getAnimalDescription();
        if (!sex.contains("female")) {
            System.out.println("He can jump for " + JumpHeight + "meters");
            System.out.println("and fly for " + FlyLength + " hours");
        }
        else {
            System.out.println("She can jump for " + JumpHeight + "meters");
            System.out.println("and fly for " + FlyLength + " hours");
        }
        System.out.println("--------------------------");
    }
}
