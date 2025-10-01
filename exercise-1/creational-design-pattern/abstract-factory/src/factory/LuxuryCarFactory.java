
package factory;

import parts.Engine;
import parts.Seat;
import parts.Tire;
import parts.LuxuryEngine;
import parts.LuxurySeat;
import parts.LuxuryTire;

public class LuxuryCarFactory implements CarFactory {
    public Engine createEngine() { return new LuxuryEngine(); }
    public Seat createSeat() { return new LuxurySeat(); }
    public Tire createTire() { return new LuxuryTire(); }
}
