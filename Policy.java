public class Policy
{
   private String policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   /**
      No-argument constructor that creates a Policy object
      with default values.
   */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }

   /**
      Constructor that creates a Policy object with specified values.
      @param pNumber The policy number.
      @param pName The provider name.
      @param fName The policyholder's first name.
      @param lName The policyholder's last name.
      @param a The policyholder's age.
      @param sStatus The policyholder's smoking status.
      @param h The policyholder's height in inches.
      @param w The policyholder's weight in pounds.
   */
   public Policy(String pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   /**
      Sets the policy number.
      @param pNumber The policy number.
   */
   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }

   /**
      Sets the provider name.
      @param pName The provider name.
   */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }

   /**
      Sets the policyholder's first name.
      @param fName The policyholder's first name.
   */
   public void setFirstName(String fName)
   {
      firstName = fName;
   }

   /**
      Sets the policyholder's last name.
      @param lName The policyholder's last name.
   */
   public void setLastName(String lName)
   {
      lastName = lName;
   }

   /**
      Sets the policyholder's age.
      @param a The policyholder's age.
   */
   public void setAge(int a)
   {
      age = a;
   }

   /**
      Sets the policyholder's smoking status.
      @param sStatus The policyholder's smoking status.
   */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }

   /**
      Sets the policyholder's height.
      @param h The policyholder's height in inches.
   */
   public void setHeight(double h)
   {
      height = h;
   }

   /**
      Sets the policyholder's weight.
      @param w The policyholder's weight in pounds.
   */
   public void setWeight(double w)
   {
      weight = w;
   }

   /**
      Gets the policy number.
      @return The policy number.
   */
   public String getPolicyNumber()
   {
      return policyNumber;
   }

   /**
      Gets the provider name.
      @return The provider name.
   */
   public String getProviderName()
   {
      return providerName;
   }

   /**
      Gets the policyholder's first name.
      @return The policyholder's first name.
   */
   public String getFirstName()
   {
      return firstName;
   }

   /**
      Gets the policyholder's last name.
      @return The policyholder's last name.
   */
   public String getLastName()
   {
      return lastName;
   }

   /**
      Gets the policyholder's age.
      @return The policyholder's age.
   */
   public int getAge()
   {
      return age;
   }

   /**
      Gets the policyholder's smoking status.
      @return The policyholder's smoking status.
   */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }

   /**
      Gets the policyholder's height.
      @return The policyholder's height in inches.
   */
   public double getHeight()
   {
      return height;
   }

   /**
      Gets the policyholder's weight.
      @return The policyholder's weight in pounds.
   */
   public double getWeight()
   {
      return weight;
   }

   /**
      Calculates the policyholder's BMI.
      @return The policyholder's BMI.
   */
   public double getBMI()
   {
      final double CONVFACTOR = 703;

      return (weight * CONVFACTOR) / (height * height);
   }

   /**
      Calculates the price of the insurance policy.
      @return The price of the insurance policy.
   */
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;

      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;

      double price = BASE_PRICE;

      if(age > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;

      if(smokingStatus.equalsIgnoreCase("smoker"))
         price += ADDITIONAL_FEE_SMOKING;

      if(getBMI() > BMI_THRESHOLD)
         price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

      return price;
   }
}
