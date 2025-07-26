//default package

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;//date api




class BankAccount{
    LocalDate today = LocalDate.now();
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String name;
    int dob1,dob2,dob3;
    long id;
    int passcode;
    int balance;
    long phone_no;
    

    public BankAccount(long id) {
        this.id = id;
        this.passcode = rand.nextInt(9000)+1000;//only 4 digit integers allowed here

    }
    void menu(){
        System.out.println("Welcome to our mobile banking app!!\n\n");
        System.out.println("Your options:\n1.Register if you are new (press 1)\n2.Sign in if you are already registered(press 2)");
        System.out.println("3.Exit(press any other key)\n");
        int choice = sc.nextInt();
        switch(choice){
            case 1:{
                register();
                break;
            }
            case 2:{
                authorize();
                break;
            }
            default:{
                System.exit(1);
            }
        }
    }
    boolean eligibleAge(){
        int p_year = today.getYear();
        int p_month = today.getMonthValue();
        int p_day = today.getDayOfMonth();
        if(p_year-dob1>=18 && p_year-dob1<=120 && dob2>0 && dob2<13 && dob3>0 && dob3<32){
        if(p_year - dob1 > 18  || p_month>=dob2||(p_month==dob2 && p_day>=dob3))
        return true;
        

    }
   
        return false;
    
}
 
   
    void register(){
        System.out.println("id : "+ id);
        System.out.println("Registration begins\nPlease fill up the accurate details\n");
        sc.nextLine();
        System.out.print("Name : ");
        this.name = sc.nextLine();

         sc.nextLine();
        System.out.print("Phone number : ");
        this.phone_no=sc.nextLong();
        
        
        System.out.println("Date of birth (in AD):\n\n");
        System.out.print("Year : ");
        this.dob1=sc.nextInt();
        System.out.print("Month : ");
        this.dob2 = sc.nextInt();
        System.out.print("Day(i want numbers not sunday monday tuesday) : ");
        this.dob3=sc.nextInt();

        
           
        sc.nextLine();

        if(eligibleAge()){

        System.out.println("Registration successful!!!! Your passcode is "+" "+this.passcode);
        System.out.println("\nPress 1 to return to homepage, and any other key to exit : ");
        int entered = sc.nextInt();
        if(entered==1)
        menu();
        else
      System.exit(0);

        
        
    }
    else{
        System.out.println("You have either entered wrong date of birth or you are under 18, which makes you ineligible to register");
        System.out.println("Please try again :)\n\n");
        menu();
    }
}

    void authorize(){
        System.out.print("Enter id : ");
        long id = sc.nextLong();
        System.out.print("Enter phone number : ");
        long phone_no=sc.nextLong();
        System.out.print("Enter password : ");
        int passcode = sc.nextInt();
         
        if(id==this.id&&passcode==this.passcode&&phone_no==this.phone_no){
            transaction();
        }


        else{
            System.out.println("Incorrect login information!!");
        System.out.println("If you are new here, please register your account!!\n\nPress 'R' to register, and any other button to exit : ");
        String choiceString = sc.next();
        char choice = choiceString.charAt(0);
        if(choice == 'r'||choice == 'R'){
            register();
        }
        else{
            System.out.println("Exiting program...");
        System.exit(0); 
        }

            
        }

    
    }
    public void transaction(){
        System.out.println("Login successful, Here are your options :");
        System.out.print("1.Withdraw(press 1)\n2.Deposit(press 2)\n3.Exit(press any other key)\n - ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:{
                withdraw();
                break;
            }
            case 2:{
                deposit();
                break;
            }
            default:{
                System.exit(0);
            }
        }


    }
    

   
    public void deposit(){
       
       
        System.out.println("\n\nDeposition process begins...\n");
        System.out.print("Amount : ");
        int depo = sc.nextInt();
        this.balance = depo + this.balance;
        System.out.println("\n\nDear " +name+ ", you have successfully deposited NPR "+depo+". Your new balance is Rs "+this.balance);

        menu();
    
    
    }

    public void withdraw(){

       

        System.out.println("\n\nWithdrawing process begins...\n");
        System.out.print("Amount : ");
        int wd=sc.nextInt();
       
    if(wd<=balance){
         this.balance = this.balance - wd;
         System.out.println("\n\nDear " +name+ ", you have successfully withdrawn NPR "+wd+". Your new balance is Rs "+this.balance);

    }
    else{
        System.out.println("Insufficient balance, you have only NPR "+this.balance);

    }
    System.out.println("\nPress 1 to return to homepage, and any other key to exit : ");
        int entered = sc.nextInt();
        if(entered==1)
        menu();
        else
      System.exit(0);


    }
}


public class BankingSystem {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        Random r = new Random();

        int id =r.nextInt(90000000)+10000000;
        BankAccount b1 = new BankAccount(id++);
        b1.menu();


    } 


    
}
