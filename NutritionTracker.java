import java.util.Scanner;

class NutritionTracker {
  // Private method to get a valid numerical input from the user
  private double getInputValue(String prompt) {
    Scanner scanner = new Scanner(System.in);
    double value = 0.0;
    boolean isValid = false;

    while(!isValid) {
      System.out.print(prompt);
      value = scanner.nextDouble();
      if (value <= 0) {
        System.out.println("Invalid input. Please enter a number greater than 0");
      }
      else{
        isValid = true;
      }
    }
    return value;
  }

  // Main method where the program execution starts
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    NutritionTracker tmp = new NutritionTracker();
    
    // Get the number of food items the user wants to input
    System.out.print("How many food items would you like to input? ");
    int foodItems = scanner.nextInt();

    double totalCalories = 0.0;

    // Loop to input and process multiple food items
    for(int i = 0; i < foodItems; i++){
      System.out.print("Enter the name of the food item: ");
      
      String name = scanner.next();

      // Prompt for and get input values for fat, carbs, protein, and servings
      double fat = tmp.getInputValue("Enter the amount of fat in " + name + " (grams): ");

      double carbs = tmp.getInputValue("Enter the amount of carbs in " + name + " (grams): ");

      double protein = tmp.getInputValue("Enter the amount of protein in " + name + " (grams): ");

      double servings = tmp.getInputValue("Enter the number of servings: ");

      // Create a FoodItem object with the provided nutritional values
      FoodItem foodItem = new FoodItem(name, fat, carbs, protein);

      // Print nutritional information for the food item
      foodItem.printInfo();

      // Calculate and display total calories and the dominant macronutrient
      double cal = foodItem.getCalories(servings);
      System.out.printf("\tTotal Calories for %.2f servings of %s: %.2f \n\tDominant Macronutrient: %s \n\n", servings, foodItem.getName(), cal, foodItem.getDominantMacronutrient());

      // Accumulate total calories
      totalCalories += cal;
    }

    // Display the total combined calories for all food items
    System.out.printf("Total combined calories for all food items: %.2f \nThank you for using the Nutrition Information System!", totalCalories);
    
   }
 }