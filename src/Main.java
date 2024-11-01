import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();


}
class SolidIngredient implements Ingredient{
    private String _ingredientName;
    private double _quantity;
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
    private String _ingredientName;
    private double _quantityMl;
    public liquidIngredient(String x, double y){
        _ingredientName = x;
        _quantityMl = y;
    }
    public String getName(){
        return _ingredientName;
    }
    public double getQuantity(){
        return _quantityMl;
    }

}

class Recipe<T extends Ingredient>{
    //whatever you pass in, the data type of that has to implement the interface(Constraint)
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions){
        _name = name;
        _ingredients = new ArrayList<T>();
        _instructions = instructions;}

    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner s){
        System.out.println("Is this a solid (s) or a liquid (l)");
        char type = s.nextLine().charAt(0);
        System.out.println("Enter new ingredient name");
        String name = s.nextLine();
        System.out.println("Enter the quantity");
        double quantity = Double.parseDouble(s.nextLine());
        Ingredient ingredient = null;
        if(type == 's'){
            ingredient = new SolidIngredient(name,quantity);
        }if(type == 'l'){
            ingredient = new liquidIngredient(name,quantity);
        }
        recipe.addIngredient(ingredient);
    }
    public void print(){
        System.out.println("Name:" + _name);
        System.out.println("Instructions:" + _instructions);
        System.out.println("Ingredients:");
        for(T t:_ingredients){
            System.out.println(t.getName() + "-" + t.getQuantity());
        }

    }


}





public class Main {
    public static void main(String[] args) {
        System.out.println("1.Add Ingredient \n 2. List the ingredients for a recipe \n 3. Exit  ");
        Recipe<Ingredient> pie = new Recipe<>("Pie", "Bake");
        Recipe<Ingredient> x;
        Scanner s = new Scanner(System.in);
        s.nextInt();
        while(s.nextInt() != 3){
            if(s.nextInt() == 1){
                
            }
        }

    }
}
