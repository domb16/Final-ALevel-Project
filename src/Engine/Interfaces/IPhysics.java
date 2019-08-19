package Engine.Interfaces;

import Shapes.Ball;

public interface IPhysics {
    void move(Ball ballO);
    float horizontal();
    float vertical();
    float rotation();

}
