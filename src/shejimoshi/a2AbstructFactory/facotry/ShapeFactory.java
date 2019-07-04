package shejimoshi.a2AbstructFactory.facotry;

import shejimoshi.a2AbstructFactory.color.Color;
import shejimoshi.a2AbstructFactory.shape.Cicle;
import shejimoshi.a2AbstructFactory.shape.Rectangle;
import shejimoshi.a2AbstructFactory.shape.Shape;
import shejimoshi.a2AbstructFactory.shape.Square;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    // 使用 getShape 方法获取形状类型对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Cicle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

}
