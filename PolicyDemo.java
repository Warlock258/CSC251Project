import java.util.*;
import java.io.*;

public class PolicyDemo
{
   public static void main(String[] args) throws IOException
   {
      String policyNumber;
      String providerName;
      String firstName;
      String lastName;
      int age;
      String smokingStatus;
      double height;
      double weight;
      int numSmokers = 0;
      int numNonSmokers = 0;

      ArrayList<Policy> policyList = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);

      while(inputFile.hasNext())
      {
         policyNumber = inputFile.nextLine();
         providerName = inputFile.nextLine();
         firstName = inputFile.nextLine();
         lastName = inputFile.nextLine();
         age = inputFile.nextInt();
         inputFile.nextLine();
         smokingStatus = inputFile.nextLine();
         height = inputFile.nextDouble();
         weight = inputFile.nextDouble();

         if(inputFile.hasNext())
            inputFile.nextLine();
         if(inputFile.hasNext())
            inputFile.nextLine();

         PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
         Policy policy = new Policy(policyNumber, providerName, holder);

         policyList.add(policy);
      }

      inputFile.close();

      for(Policy policy : policyList)
      {
         System.out.println(policy);
         System.out.println();

         PolicyHolder holder = policy.getPolicyHolder();

         if(holder.getSmokingStatus().equalsIgnoreCase("smoker"))
            numSmokers++;
         else if(holder.getSmokingStatus().equalsIgnoreCase("non-smoker"))
            numNonSmokers++;
      }

      System.out.println("There were " + Policy.getNumberOfPolicies() + " Policy objects created.");
      System.out.println();
      System.out.println("The number of policies with a smoker is: " + numSmokers);
      System.out.println();
      System.out.println("The number of policies with a non-smoker is: " + numNonSmokers);
   }
}
