package shejimoshi.a2AbstructFactory.facotry;

import shejimoshi.a2AbstructFactory.color.Color;
import shejimoshi.a2AbstructFactory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
