import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();


        // Default account
        bank.addAccount(
            new Accounts(
                "Nkosinathi Nkosi",
                "nkosi",
                "1234",
                1000
            )
        );


        int option;


        do {


            System.out.println("\n============================");
            System.out.println(" JAVA BANKING SYSTEM");
            System.out.println("============================");

            System.out.println("1. Login");
            System.out.println("2. Create New Account");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");

            option = input.nextInt();



            switch(option) {


                case 1:

                    input.nextLine();

                    System.out.print("Username: ");
                    String username = input.nextLine();


                    System.out.print("Password: ");
                    String password = input.nextLine();



                    Accounts account = bank.findAccount(username);



                    if(account != null &&
                       account.getPassword().equals(password)) {


                        System.out.println("Login successful!");


                        int choice;


                        do {

                            System.out.println("\n1. View Account");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Transactions");
                            System.out.println("5. Logout");

                            System.out.print("Choose: ");

                            choice = input.nextInt();



                            switch(choice) {


                                case 1:
                                    account.displayAccount();
                                    break;


                                case 2:
                                    System.out.print("Amount: R");
                                    account.deposit(input.nextDouble());
                                    break;


                                case 3:
                                    System.out.print("Amount: R");
                                    account.withdraw(input.nextDouble());
                                    break;


                                case 4:
                                    account.displayTransactions();
                                    break;


                                case 5:
                                    System.out.println("Logged out.");
                                    break;


                                default:
                                    System.out.println("Invalid option.");
                            }


                        } while(choice != 5);



                    } else {

                        System.out.println("Invalid login details.");

                    }

                    break;




                case 2:


                    input.nextLine();


                    System.out.print("Full name: ");
                    String name = input.nextLine();


                    System.out.print("Create username: ");
                    String newUsername = input.nextLine();



                    if(bank.usernameExists(newUsername)) {

                        System.out.println("Username already exists!");

                        break;
                    }



                    System.out.print("Create password: ");
                    String newPassword = input.nextLine();



                    System.out.print("Starting deposit: R");
                    double money = input.nextDouble();



                    Accounts newAccount = new Accounts(
                            name,
                            newUsername,
                            newPassword,
                            money
                    );



                    bank.addAccount(newAccount);


                    System.out.println("Account created successfully!");

                    break;




                case 3:

                    System.out.println("Thank you for using Java Banking System.");

                    break;



                default:

                    System.out.println("Invalid option.");

            }


        } while(option != 3);



        input.close();

    }
}