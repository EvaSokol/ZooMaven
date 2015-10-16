package animals;

public class Wolf extends Animal implements Jump, Cloneable{

        public int JumpHeight = 3;

        public Wolf(String type, int age, int height, String color, String name, String sex) {
            super(type, age, height, color, name, sex);

        }

        @Override
        public void jump() {
            System.out.println("- I'm jumping for " + JumpHeight + " meters!");
        }

        public void voice() {
            System.out.println("- Arrrrgh!!!");
        }

        public void move(int steps) {
            System.out.println(color + " animals.Wolf has run " + steps + " steps.");
        }


        @Override
        protected Wolf clone() throws CloneNotSupportedException {
            super.clone();
            return new Wolf(this.type, this.age, this.height, this.color, this.name, this.sex);
        }

        @Override
        public void getAnimalDescription() {
            System.out.println("It's a wolf");
            super.getAnimalDescription();
            if (!sex.contains("female"))
                System.out.println("He can jump for " + JumpHeight + " meters");
            else
                System.out.println("She can jump for " + JumpHeight + " meters");
            System.out.println("--------------------------");
        }
    }

