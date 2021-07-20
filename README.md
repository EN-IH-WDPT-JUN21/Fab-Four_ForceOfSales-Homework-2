# Fab-Four_ForceOfSales

Introduction

For this project, you will be building a CRM (Customer Relationship Management) system. CRMs are a tool that almost every sales team uses to track prospective and existing customers through the sales process.

Salesforce is the most popular CRM in the market currently. This short video explains what the Salesforce CRM provides at a high level.

The most important takeaway from the video is that our CRM should allow us to:

Track Leads (people whose contact info we have gathered but who may or may not be interested in our product)
Convert Leads into Opportunities (leads are converted into opportunities when they show interest in buying the product)
Associate an Opportunity with an Account.
Associate Contacts with an Opportunity.
Let’s walk through an actual use case:

LBL Trucking Company sells fleets of Trucks to large companies all over the world. They need new customers so they decide to offer a free webinar on the cost savings associated with their new hybrid trucks. Ever person who signs up for the webinar becomes a Lead in their CRM. The CRM stores the name, phone number, email address, and company name of each Lead.

Sara is a sales associate at LBL. After the webinar, she starts calling all the new Leads. The first 5 Leads are not interested. The sixth Lead is Mike from Emerson Produce Company. Mike says he is interested in learning more and would like to see their pricing.

Sara needs to convert Mike’s Lead to an Opportunity. Mike’s Lead id is 134. Sara types “Convert 134” into the CRM.

The CRM begins by creating a new Contact object with the contact information from Mike’s Lead object.

The CRM then prompts Sara for the product that Mike is interested in (Hybrid Truck, Flatbed Truck, or Box Truck) and the number of trucks that he is interested in buying. Sara inputs the information “Hybrid Truck” and “30”. The CRM creates a new Opportunity object with this information. It adds the new Mike Contact object as the decisionMaker for the Opportunity and sets the status to “OPEN”.

The CRM then prompts Sara for the industry, number of employees, city, and country of Mike’s company. Sara inputs the information “Produce”, “4000”, “Berlin”, “Germany”. The CRM takes the Company name from Mike’s Lead Object and creates a new Account Object with this information. It adds the Mike Contact to the contactList of the Account and the new Opportunity to the opportunityList of the Account.

Finally the System deletes the Mike Lead.

The next day Sara wants to look up the new Opportunity. The Opportunity id is 24. She types “lookup opportunity 24”. The CRM displays the opportunity information.

She wants to call Mike to check on the deal. Unfortunately, he says they have decided to buy from another truck company. Sara types “close-lost 24” and the CRM changes the status of opportunity 24 to “CLOSED-LOST”




Input and Output

For this assignment, you will need to use System.out.println() to print information to the user. You will also need to use the Scanner class to receive user input.

Run the code below. Notice that the console has a blinking cursor. Type your name into the console and press enter.

Copy
import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) {
 
    //Create a Scanner to collect user input
    Scanner myScanner =newScanner(System.in);
 
    // Get input from the user
    System.out.println("Please enter your name");
    String userInput = myScanner.nextLine();
 
    System.out.println("Welcome "+ userInput);
 
  }
}
Scanner always receives input as a String. If you want numeric input, you need to parse the input to a numeric value (Remember that this will throw an exception if the String cannot be parsed to a numeric value.

Copy
package com.company;
import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) {
 
    //Create a Scanner to collect user input
    Scanner myScanner =newScanner(System.in);
 
    // Get input from the user
    System.out.println("Please enter your age");
    String userInput = myScanner.nextLine();
 
    // Convert the user input to a number
    int userAge =Integer.parseInt(userInput);
 
    System.out.println("You are "+ userAge +" years old.");
  }
}
You can use the code below to create a system that is always waiting for a command or executing a command:

Copy
package com.company;
import java.util.Scanner;
 
public class Main {
 
  public static void main(String[] args) {
 
    //Create a Scanner to collect user input
    Scanner myScanner =newScanner(System.in);
 
    // Get input from the user
    while (true){
      System.out.println("Please enter your age");
      String userInput = myScanner.nextLine();
 
      //add some logic to here to determine what to do based on the userInput
    }
  }
}



Requirements

For this project you must accomplish all of the following:

Create a use case diagram and add it to your README.md.
Create a class diagram and add it to your README.md.
Create unit tests for every method other than basic getters, setters, and constructors (getters and setters with logic do require unit tests).
Handle all exceptions gracefully (incorrect input should not crash the program).
Leads can be added to the CRM by typing the command “New Lead” (case insensitive).
When a new Lead is created the user will be prompted for name, phoneNumber, email, and companyName. All fields must be supplied to create the new Lead.
The system should automatically create an id for the Lead. This may require some research and Googling to accomplish, but is relatively trivial. Your CRM should keep track of how many objects have been created and provide the current count as the id for each new object.
A list of all Leads’ id and name can be displayed by typing “Show Leads” (case insensitive).
An individual Lead’s details can be displayed by typing “Lookup Lead id” (case insensitive) where “id” is the actual id of the Lead to lookup.
A Lead can be converted to an Opportunity by typing “convert id” (case insensitive) where “id” is the actual id of the Lead to convert.
When a Lead is converted, a Contact will be created with the Lead contact info and a new id.
When a Lead is converted, the user will be prompted for the product and the number of trucks for this Opportunity. A new Opportunity should be created with the above information and with the new Contact as the decisionMaker for the Opportunity and a status of “OPEN”. To recap, Opportunity should have the following properties:
id - a unique identifier
product - an Enum with options HYBRID, FLATBED, or BOX
quantity - the number of trucks being considered for purchase
decisionMaker - a Contact
status - an Enum with options OPEN, CLOSED_WON, CLOSED_LOST (these are common sales terms indicating an ongoing potential sale, a sale, and an opportunity where a sale was not made and the sale is no longer a possibility)
When a Lead is converted, the user will be prompted for the industry, number of employees, city, and country of the organization. An Account represents the company that is looking to buy a truck. Each Account should have a List of Contacts and a List of Opportunities. To recap, the Account should have the following properties:
id - a unique identifier
industry - an Enum with options PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER
employeeCount - a number representing the number of employees in the company
city - a String
country - a String
contactList - a List of Contacts associated with this Account
opportunityList - a list of Opportunities associated with this Account
Leads are removed from the system once they have been successfully converted.
Opportunity status can be edited using the command “close-lost id” or “close-won id” where “id” is the id of the Opportunity that should be closed.
Note: For simplicity, Lead, Account, and Contact information cannot be updated once the object has been created.

Note: For simplicity, there is currently no way to associate multiple Contacts or Opportunities with a single Account. These should still be Lists as we will be adding more functionality to this application in the future.




Important Note

Everyone in the squad should contribute equally to the project in time and in lines of code written.

All code must be reviewed before it is merged into the master branch.

All squad members must participate in code review.

Code should not be merged into master if it lacks sufficient test coverage.

This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!
