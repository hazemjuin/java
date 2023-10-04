class Mammal {
    protected int energyLevel;

    public Mammal() {
        this.energyLevel = 100;
    }

    public int displayEnergy() {
        System.out.println("Energy Level: " + this.energyLevel);
        return this.energyLevel;
    }
}

class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("Gorilla has thrown something!");
        this.energyLevel -= 5;
    }

    public void eatBananas() {
        System.out.println("Gorilla is satisfied after eating bananas!");
        this.energyLevel += 10;
    }

    public void climb() {
        System.out.println("Gorilla has climbed a tree!");
        this.energyLevel -= 10;
    }
}

class GorillaTest {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.climb();
        gorilla.displayEnergy();
    }
}

class Bat extends Mammal {
    public Bat() {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("Bat is taking off!");
        this.energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("Bat has eaten a human! Yum!");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("The town is on fire! Bat is attacking!");
        this.energyLevel -= 100;
    }
}

class BatTest {
    public static void main(String[] args) {
        Bat bat = new Bat();
        bat.attackTown();
        bat.attackTown();
        bat.attackTown();
        bat.eatHumans();
        bat.eatHumans();
        bat.fly();
        bat.fly();
        bat.displayEnergy();
    }
}
