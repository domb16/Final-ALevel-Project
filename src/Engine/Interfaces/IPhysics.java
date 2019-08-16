package Engine.Interfaces;

import Ball.Ball;

public interface IPhysics {
    void move(Ball ballO);
    float horizontal();
    float vertical();
    float rotation();

}
