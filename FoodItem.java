import java.util.Scanner;

class FoodItem {
  // Private instance variables to store nutritional information for a food item
  private String name;
  private double fat;
  private double carbs;
  private double protein;
  // To store the dominant macronutrient
  private String dm;

  // Constructor to initialize a FoodItem with its name, fat, carbs, and protein content
  public FoodItem(String name, double fat, double carbs, double protein) {
    this.name = name;
    this.fat = fat;
    this.carbs = carbs;
    this.protein = protein;
  }

  // Method to calculate the total calories for a given number of servings
  public double getCalories(double numServings) {
    final double CALORIES_PER_GRAM_FAT = 9.0;
    final double CALORIES_PER_GRAM_CARBS = 4.0;
    final double CALORIES_PER_GRAM_PROTEIN = 4.0;
    
    // Calculate the total calories for each macronutrient
    double totalFat = CALORIES_PER_GRAM_FAT * fat;
    double totalCarbs = CALORIES_PER_GRAM_CARBS * carbs;
    double totalProtein = CALORIES_PER_GRAM_PROTEIN * protein;
    
    // Determine the dominant macronutrient
    if (totalFat > totalCarbs && totalFat > totalProtein) {
      dm = "Fat";
    }
    else if (totalCarbs > totalFat && totalCarbs > totalProtein) {
      dm = "Carbohydrates";
    }
    else{
      dm = "Protein";
    }
    // Calculate and return the total calories for the specified number of servings
    return (totalFat + totalCarbs + totalProtein) * numServings;
  }

  // Method to get the dominant macronutrient
  public String getDominantMacronutrient() {
    return dm;
  } 

  // Method to print the nutritional information of a food item
  public void printInfo() {
    System.out.printf("Nutritional information per serving of %s: \n\tFat: %.2f g\n\tCarbohydrates: %.2f g\n\tProtein: %.2f g\n", name, fat, carbs, protein);
  }

  // Getter and setter methods for the private instance variables
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setFat(double fat) {
    this.fat = fat;
  }

  public double getFat() {
    return fat;
  }

  public void setCarbs(double carbs) {
    this.carbs = carbs;
  }

  public double getCarbs() {
    return carbs;
  }

  public void setProtein(double protein) {
    this.protein = protein;
  }

  public double getProtein() {
    return protein;
  }
  
}