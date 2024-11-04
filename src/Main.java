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
        _instructions = instructions;
    }

    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void print(){
        System.out.println("Name:" + _name);
        System.out.println("Instructions:" + _instructions);
        System.out.println("Ingredients:");
        for(T t:_ingredients){
            System.out.println("Name:" + t.getName() + "-" + "Quantity:" + t.getQuantity());
        }

    }


}





public class Main {
    public static void main(String[] args) {
        System.out.println("1.Add Ingredient \n 2. List the ingredients for a recipe \n 3. Exit  ");
        Recipe<Ingredient> pie = new Recipe<>("Pie", "Bake");
        Scanner s = new Scanner(System.in);
        String x = s.next();
        while(!x.equals("3")){
            if(x.equals("1")){
                addIngredient(pie,s);
            }
            if(x.equals("2")){
                pie.print();
            }
            x = s.next();
        }

    }
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner s){
        System.out.println("Is this a solid (s) or a liquid (l)");
        String inputType = s.nextLine();
        // Check if inputType is empty
//        if (inputType.isEmpty()) {
//            System.out.println("Input cannot be empty. Please enter 's' for solid or 'l' for liquid.");
//            return;
//        }
        char type = s.nextLine().charAt(0);
        System.out.println("Enter new ingredient name");
        String name = s.nextLine();
        System.out.println("Enter the quantity");
        double quantity = Double.parseDouble(s.nextLine());
        if(type == 's'){
            recipe.addIngredient(new SolidIngredient(name,quantity));
        }else if(type == 'l'){
            recipe.addIngredient(new liquidIngredient(name,quantity));
        }
    }
}
