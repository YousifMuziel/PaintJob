import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the project's title: ");
        String projectTitle = scanner.nextLine();

        System.out.print("Enter your budget: ");
        float budget = scanner.nextFloat();

        System.out.print("Enter wall height (feet): ");
        float height = scanner.nextFloat();

        System.out.print("Enter wall width (feet): ");
        float width = scanner.nextFloat();

        System.out.print("Enter wall length (feet): ");
        float length = scanner.nextFloat();

        System.out.print("Enter the price of a can of paint: ");
        float canPrice = scanner.nextFloat();

        // Create an instance of the PaintJob class and set the attributes based on user input
        PaintJob paintJob = new PaintJob(projectTitle, height, width, length);
        paintJob.setBudget(budget);
        paintJob.setCanPrice(canPrice);

        // Calculate the amount of paint needed and display the output
        paintJob.calculatePaint();
        paintJob.displayOutput();

        scanner.close();
    }
}
