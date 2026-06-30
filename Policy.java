/**
   The Policy class stores information about an insurance policy.
   A Policy has a PolicyHolder.
*/
public class Policy
{
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;
   private static int numberOfPolicies = 0;

   /**
      No-arg constructor that initializes all fields to default values.
   */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      policyHolder = new PolicyHolder();
      numberOfPolicies++;
   }

   /**
      Constructor that accepts arguments for the Policy fields.
      A copy of the PolicyHolder object is stored to protect the data.
      @param pNumber The policy number.
      @param pName The policy provider's name.
      @param holder The PolicyHolder associated with the policy.
   */
   public Policy(String pNumber, String pName, PolicyHolder holder)
   {
      policyNumber = pNumber;
      providerName = pName;
      policyHolder = new PolicyHolder(holder);
      numberOfPolicies++;
   }

   /**
      @return The policy number.
   */
   public String getPolicyNumber()
   {
      return policyNumber;
   }

   /**
      @return The policy provider's name.
   */
   public String getProviderName()
   {
      return providerName;
   }

   /**
      Returns a copy of the PolicyHolder object to protect the data.
      @return A copy of the PolicyHolder associated with the policy.
   */
   public PolicyHolder getPolicyHolder()
   {
      return new PolicyHolder(policyHolder);
   }

   /**
      @return The number of Policy objects that have been created.
   */
   public static int getNumberOfPolicies()
   {
      return numberOfPolicies;
   }

   /**
      @param pNumber The policy number.
   */
   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }

   /**
      @param pName The policy provider's name.
   */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }

   /**
      Stores a copy of the PolicyHolder object to protect the data.
      @param holder The PolicyHolder associated with the policy.
   */
   public void setPolicyHolder(PolicyHolder holder)
   {
      policyHolder = new PolicyHolder(holder);
   }

   /**
      Calculates and returns the policy price.
      @return The price of the policy.
   */
   public double getPrice()
   {
      final double BASE_PRICE = 600.0;
      final double ADDITIONAL_FEE_AGE = 75.0;
      final double ADDITIONAL_FEE_SMOKING = 100.0;
      final double ADDITIONAL_FEE_PER_BMI = 20.0;

      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;

      double price = BASE_PRICE;

      if(policyHolder.getAge() > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;

      if(policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += ADDITIONAL_FEE_SMOKING;

      if(policyHolder.getBMI() > BMI_THRESHOLD)
         price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

      return price;
   }

   /**
      Returns a string containing the policy information.
      This method also includes the PolicyHolder information.
      @return The policy information.
   */
   public String toString()
   {
      return "Policy Number: " + policyNumber + "\n" +
             "Provider Name: " + providerName + "\n" +
             policyHolder + "\n" +
             "Policy Price: $" + String.format("%.2f", getPrice());
   }
}
