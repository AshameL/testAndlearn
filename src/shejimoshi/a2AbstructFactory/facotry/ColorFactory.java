package shejimoshi.a2AbstructFactory.facotry;

import shejimoshi.a2AbstructFactory.color.Blue;
import shejimoshi.a2AbstructFactory.color.Color;
import shejimoshi.a2AbstructFactory.color.Green;
import shejimoshi.a2AbstructFactory.color.Red;
import shejimoshi.a2AbstructFactory.shape.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}