/**
   The PolicyHolder class stores information about a person
   who is associated with an insurance policy.
*/
public class PolicyHolder
{
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   /**
      No-arg constructor that initializes all fields to default values.
   */
   public PolicyHolder()
   {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0.0;
      weight = 0.0;
   }

   /**
      Constructor that accepts arguments for all PolicyHolder fields.
      @param fName The policyholder's first name.
      @param lName The policyholder's last name.
      @param a The policyholder's age.
      @param sStatus The policyholder's smoking status.
      @param h The policyholder's height in inches.
      @param w The policyholder's weight in pounds.
   */
   public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w)
   {
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   /**
      Copy constructor that creates a new PolicyHolder from another PolicyHolder.
      @param holder The PolicyHolder object to copy.
   */
   public PolicyHolder(PolicyHolder holder)
   {
      firstName = holder.firstName;
      lastName = holder.lastName;
      age = holder.age;
      smokingStatus = holder.smokingStatus;
      height = holder.height;
      weight = holder.weight;
   }

   /**
      @return The policyholder's first name.
   */
   public String getFirstName()
   {
      return firstName;
   }

   /**
      @return The policyholder's last name.
   */
   public String getLastName()
   {
      return lastName;
   }

   /**
      @return The policyholder's age.
   */
   public int getAge()
   {
      return age;
   }

   /**
      @return The policyholder's smoking status.
   */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }

   /**
      @return The policyholder's height in inches.
   */
   public double getHeight()
   {
      return height;
   }

   /**
      @return The policyholder's weight in pounds.
   */
   public double getWeight()
   {
      return weight;
   }

   /**
      @param fName The policyholder's first name.
   */
   public void setFirstName(String fName)
   {
      firstName = fName;
   }

   /**
      @param lName The policyholder's last name.
   */
   public void setLastName(String lName)
   {
      lastName = lName;
   }

   /**
      @param a The policyholder's age.
   */
   public void setAge(int a)
   {
      age = a;
   }

   /**
      @param sStatus The policyholder's smoking status.
   */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }

   /**
      @param h The policyholder's height in inches.
   */
   public void setHeight(double h)
   {
      height = h;
   }

   /**
      @param w The policyholder's weight in pounds.
   */
   public void setWeight(double w)
   {
      weight = w;
   }

   /**
      Calculates and returns the policyholder's BMI.
      @return The BMI of the policyholder.
   */
   public double getBMI()
   {
      final double CONVERSION_FACTOR = 703.0;
      return (weight * CONVERSION_FACTOR) / (height * height);
   }

   /**
      Returns a string containing the policyholder's information.
      @return The policyholder's information.
   */
   public String toString()
   {
      return "Policyholder's First Name: " + firstName + "\n" +
             "Policyholder's Last Name: " + lastName + "\n" +
             "Policyholder's Age: " + age + "\n" +
             "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n" +
             "Policyholder's Height: " + String.format("%.1f", height) + " inches\n" +
             "Policyholder's Weight: " + String.format("%.1f", weight) + " pounds\n" +
             "Policyholder's BMI: " + String.format("%.2f", getBMI());
   }
}
