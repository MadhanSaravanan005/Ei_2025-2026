package factory;

import parts.Engine;
import parts.Seat;
import parts.Tire;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tire createTire();
}
