class Car {
    private int gas;

    public Car() {
        gas = 10;
    }

    public void displayGas() {
        System.out.println("Gas remaining: " + gas + "/10");
    }

    public boolean isGameOver() {
        return gas <= 0;
    }

    public void gameover() {
        System.out.println("Game over! The car has run out of gas.");
    }

    protected int getGas() {
        return gas;
    }

    protected void setGas(int gas) {
        this.gas = gas;
    }
}

class Driver extends Car {
    public boolean drive() {
        if (getGas() > 0) {
            System.out.println("You drive the car.");
            setGas(getGas() - 1);
        } else {
            System.out.println("The car has run out of gas.");
        }
        displayGas();
        return !isGameOver();
    }

    public boolean useBoosters() {
        if (getGas() >= 3) {
            System.out.println("You use boosters.");
            setGas(getGas() - 3);
        } else {
            System.out.println("Not enough gas to use boosters.");
        }
        displayGas();
        return !isGameOver();
    }

    public boolean refuel() {
        if (getGas() < 8) {
            System.out.println("You refuel the car.");
            setGas(getGas() + 2);
        } else {
            System.out.println("The car already has enough gas.");
        }
        displayGas();
        return !isGameOver();
    }
}

public class RacingGame {
    public static void main(String[] args) {
        Driver driver = new Driver();

        while (driver.drive() && driver.useBoosters() && driver.refuel()) {
            // Continue looping until one of the methods returns false (car runs out of gas)
        }
        driver.gameover();
    }
}
