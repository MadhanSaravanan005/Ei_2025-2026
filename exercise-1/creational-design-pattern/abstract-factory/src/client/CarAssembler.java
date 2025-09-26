
package client;
import factory.CarFactory;

public class CarAssembler {
    private CarFactory factory;

    public CarAssembler(CarFactory factory) {
        this.factory = factory;
    }

    public void assembleCar() {
        System.out.println("Car Assembled with: "
            + factory.createEngine().getDescription() + ", "
            + factory.createSeat().getMaterial() + ", "
            + factory.createTire().getType());
    }
}
