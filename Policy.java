import java.util.Scanner;

public class Policy {

    // Public fields / attributes
    public String policyNumber;
    public String providerName;
    public String firstName;
    public String lastName;
    public int age;
    public String smokingStatus;
    public double height; // in inches
    public double weight; // in pounds

    /*
     * No-arg constructor
     * Sets default values for all fields.
     */
    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /*
     * Constructor that accepts all values needed
     * to fully initialize a Policy object.
     */
    public Policy(String pPolicyNumber, String pProviderName, String pFirstName,
                  String pLastName, int pAge, String pSmokingStatus,
                  double pHeight, double pWeight) {

        policyNumber = pPolicyNumber;
        providerName = pProviderName;
        firstName = pFirstName;
        lastName = pLastName;
        age = pAge;
        smokingStatus = pSmokingStatus;
        height = pHeight;
        weight = pWeight;
    }

    // Setters / Mutator Methods

    public void setPolicyNumber(String pPolicyNumber) {
        policyNumber = pPolicyNumber;
    }

    public void setProviderName(String pProviderName) {
        providerName = pProviderName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public void setAge(int pAge) {
        age = pAge;
    }

    public void setSmokingStatus(String pSmokingStatus) {
        smokingStatus = pSmokingStatus;
    }

    public void setHeight(double pHeight) {
        height = pHeight;
    }

    public void setWeight(double pWeight) {
        weight = pWeight;
    }

    // Getters / Accessor Methods

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    /*
     * Calculates and returns the BMI of the policyholder.
     * BMI = (weight * 703) / (height * height)
     */
    public double calculateBMI() {
        if (height == 0) {
            return 0.0;
        }

        return (weight * 703) / (height * height);
    }

    /*
     * Calculates and returns the price of the insurance policy.
     */
    public double calculatePolicyPrice() {
        double price = 600.00;
        double bmi = calculateBMI();

        if (age > 50) {
            price = price + 75.00;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price = price + 100.00;
        }

        if (bmi > 35) {
            price = price + ((bmi - 35) * 20);
        }

        return price;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Policy Number: ");
        String inputPolicyNumber = scanner.nextLine();

        System.out.print("Enter Provider Name: ");
        String inputProviderName = scanner.nextLine();

        System.out.print("Enter Policyholder's First Name: ");
        String inputFirstName = scanner.nextLine();

        System.out.print("Enter Policyholder's Last Name: ");
        String inputLastName = scanner.nextLine();

        System.out.print("Enter Policyholder's Age: ");
        int inputAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Smoking Status (smoker or non-smoker): ");
        String inputSmokingStatus = scanner.nextLine();

        System.out.print("Enter Policyholder's Height in inches: ");
        double inputHeight = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Policyholder's Weight in pounds: ");
        double inputWeight = Double.parseDouble(scanner.nextLine());

        Policy policy1 = new Policy(
                inputPolicyNumber,
                inputProviderName,
                inputFirstName,
                inputLastName,
                inputAge,
                inputSmokingStatus,
                inputHeight,
                inputWeight
        );

        System.out.println();
        System.out.println("Policy Information");
        System.out.println("------------------");
        System.out.println("Policy Number: " + policy1.getPolicyNumber());
        System.out.println("Provider Name: " + policy1.getProviderName());
        System.out.println("Policyholder First Name: " + policy1.getFirstName());
        System.out.println("Policyholder Last Name: " + policy1.getLastName());
        System.out.println("Policyholder Age: " + policy1.getAge());
        System.out.println("Smoking Status: " + policy1.getSmokingStatus());
        System.out.println("Height: " + policy1.getHeight() + " inches");
        System.out.println("Weight: " + policy1.getWeight() + " pounds");

        System.out.printf("BMI: %.2f%n", policy1.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy1.calculatePolicyPrice());

        scanner.close();
    }
}