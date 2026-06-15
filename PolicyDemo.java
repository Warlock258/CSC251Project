import java.util.*;
import java.io.*;

public class PolicyDemo
{
   public static void main(String[] args)
   {
      try
      {
         File file = new File("PolicyInformation.txt");
         Scanner inputFile = new Scanner(file);

         ArrayList<Policy> policies = new ArrayList<Policy>();
         ArrayList<String> fileData = new ArrayList<String>();

         while(inputFile.hasNextLine())
         {
            String line = inputFile.nextLine().trim();

            if(!line.equals(""))
            {
               fileData.add(line);
            }
         }

         inputFile.close();

         for(int index = 0; index < fileData.size(); index += 8)
         {
            String policyNumber = fileData.get(index);
            String providerName = fileData.get(index + 1);
            String firstName = fileData.get(index + 2);
            String lastName = fileData.get(index + 3);
            int age = Integer.parseInt(fileData.get(index + 4));
            String smokingStatus = fileData.get(index + 5);
            double height = Double.parseDouble(fileData.get(index + 6));
            double weight = Double.parseDouble(fileData.get(index + 7));

            Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
            policies.add(policy);
         }

         int smokerCount = 0;
         int nonSmokerCount = 0;

         for(int index = 0; index < policies.size(); index++)
         {
            Policy policy = policies.get(index);

            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println();
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println();
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println();
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println();
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println();
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println();
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println();
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.println();
            System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
            System.out.println();
            System.out.printf("Policy Price: $%.2f\n", policy.getPrice());
            System.out.println();
            System.out.println();

            if(policy.getSmokingStatus().equalsIgnoreCase("smoker"))
            {
               smokerCount++;
            }
            else if(policy.getSmokingStatus().equalsIgnoreCase("non-smoker"))
            {
               nonSmokerCount++;
            }
         }

         System.out.println("The number of policies with a smoker is: " + smokerCount);
         System.out.println();
         System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
      }
      catch(IOException ex)
      {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
   }
}
