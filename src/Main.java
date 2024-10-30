import java.util.ArrayList;

interface Ingredient{
    public String getName();
    public double getQuantity();


}
class SolidIngredient implements Ingredient{
    String _ingredientName;
    double _quantity;
    public SolidIngredient(String x, double y){
        _ingredientName = x;
        _quantity = y;
    }
    public String getName(){
        return _ingredientName;
    }
    public double getQuantity(){
        return _quantity;
    }


}
class liquidIngredient implements Ingredient{
    String _ingredientName;
    double _quantity;
    public liquidIngredient(String x, double y){
        _ingredientName = x;
        _quantity = y;
    }
    public String getName(){
        return _ingredientName;
    }
    public double getQuantity(){
        return _quantity;
    }

}

class Recipe<T extends Ingredient>{
    private String name;
    private String instructions;
    private ArrayList<T> _ingredients;
    public Recipe(int size){_ingredients = new ArrayList<T>();}

    public void addIngredient(Ingredient t){
        _ingredients.add((T) t);
    }


}





public class Main {
    public static void main(String[] args) {

    }
}
