package shejimoshi.a1Factory.facotry;

import shejimoshi.a1Factory.shape.Cicle;
import shejimoshi.a1Factory.shape.Rectangle;
import shejimoshi.a1Factory.shape.Shape;
import shejimoshi.a1Factory.shape.Square;

public class ShapeFactory {
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
