
package factory;
import parts.Engine;
import parts.Seat;
import parts.Tire;
import parts.EconomyEngine;
import parts.EconomySeat;
import parts.EconomyTire;

public class EconomyCarFactory implements CarFactory {
    public Engine createEngine() { return new EconomyEngine(); }
    public Seat createSeat() { return new EconomySeat(); }
    public Tire createTire() { return new EconomyTire(); }
}
