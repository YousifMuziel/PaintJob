import java.util.Scanner;
import java.text.DecimalFormat;

public class PaintJob {
    public int numCans;
    public float coatCost, paintNeeded;
    private String projectName;
    private float height, width, length, area, budget, canPrice;
    private static final float LITER_COVERS_SQUARE_FEET = 100.0f;

    // Default constructor to initialize attributes to zeros and nulls
    public PaintJob() {
        numCans = 0;
        coatCost = paintNeeded = 0.0f;
        projectName = null;
        height = width = length = area = budget = canPrice = 0.0f;
    }

    // Overloaded constructor to set project name, height, width, and length based on user input
    public PaintJob(String projectName, float height, float width, float length) {
        this.projectName = projectName;
        this.height = height;
        this.width = width;
        this.length = length;
        this.area = 2.0f * ((height * width) + (height * length));
    }

    // Setter and getter methods for projectName, budget, and canPrice
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getBudget() {
        return budget;
    }

    public void setCanPrice(float canPrice) {
        this.canPrice = canPrice;
    }

    public float getCanPrice() {
        return canPrice;
    }

    // Method to calculate the price of a coat of paint based on the number of coats and can price
    public float calculateCoatPrice(int numOfCoats) {
        float totalPaintNeeded = paintNeeded * numOfCoats;
        int numCansForCoat = (int) Math.ceil(totalPaintNeeded / 3.7f);
        return numCansForCoat * canPrice;
    }

    // Method to calculate the amount of paint needed and the number of paint cans required
    public void calculatePaint() {
        paintNeeded = area / LITER_COVERS_SQUARE_FEET;
        numCans = (int) Math.ceil(paintNeeded / 3.7f);
    }

    // Method to display the output for 1, 2, and 3 coats of paint
    public void displayOutput() {
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("******************************");
        System.out.println("Project name: " + projectName);
        System.out.println("Wall area: " + area + " ft^2");
        System.out.println("******************************");

        float totalPaintNeeded = 0.0f;
        int totalNumCans = 0;

        // Calculate and display the cost of each coat of paint
        for (int i = 1; i <= 3; i++) {
            coatCost = calculateCoatPrice(i);
            float moneyLeft = budget - coatCost;

            float paintNeededForCoat = area * i / LITER_COVERS_SQUARE_FEET;
            int numCansForCoat = (int) Math.ceil(paintNeededForCoat / 3.7f);

            totalPaintNeeded += paintNeededForCoat;
            totalNumCans += numCansForCoat;

            System.out.println("Amount of paint needed: " + df.format(paintNeededForCoat) + " L");
            System.out.println("Number of paint cans needed: " + numCansForCoat + " cans");
            System.out.println("The price of " + i + " coat(s) of paint: " + coatCost + " $");
            System.out.println("The amount of money left from the budget after a " + i + " coat(s): " + df.format(moneyLeft) + " $");
            System.out.println("******************************");
        }
    }
}

