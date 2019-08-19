package Engine;

import Engine.Interfaces.ISpeed;
import javax.vecmath.Vector2d;

public class CollisionDetection extends Vector2d implements ISpeed {

    public CollisionDetection() { }

    private double Distance(Vector2d a, Vector2d b){
        return (a.x - b.x) * (a.x - b.x)  + (a.y - b.y) * (a.y - b.y);
    }
    public long goodMask; // 0xC840C04048404040 computed below
    {
        for (int i=0; i<64; ++i) goodMask |= Long.MIN_VALUE >>> (i*i);
    }

    private boolean isSquare(long x) {
        // This tests if the 6 least significant bits are right.
        // Moving the to be tested bit to the highest position saves us masking.
        if (goodMask << x >= 0) return false;
        final int numberOfTrailingZeros = Long.numberOfTrailingZeros(x);
        // Each square ends with an even number of zeros.
        if ((numberOfTrailingZeros & 1) != 0) return false;
        x >>= numberOfTrailingZeros;
        // Now x is either 0 or odd.
        // In binary each odd square ends with 001.
        // Postpone the sign test until now; handle zero in the branch.
        if ((x&7) != 1 | x <= 0) return x == 0;
        // Do it in the classical way.
        // The correctness is not trivial as the conversion from long to double is lossy!
        final long tst = (long) Math.sqrt(x);
        return tst * tst == x;
    }
//    private float SQRT(int num){
//        if(isSquare((long) num))
//            return
//    }

}

class AABB{
    public Vector2d max;
    public Vector2d min;
}

class Circle{
    public float radius;
    public Vector2d position;
}


