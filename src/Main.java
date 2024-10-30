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
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions, int size){_name = name;
        _ingredients = new ArrayList<T>();
        _instructions = instructions;}

    public void addIngredient(Ingredient t){
        _ingredients.add((T) t);
    }
    public void print(){
        if ( _name!= null){
            System.out.println("Name:" + _name.getClass().getName());
        }
    }


}





public class Main {
    public static void main(String[] args) {

    }
}
