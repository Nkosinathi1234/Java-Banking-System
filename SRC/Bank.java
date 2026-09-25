import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class Bank {


    private ArrayList<Accounts> accounts;

    private final String fileName = "accounts.txt";


    public Bank() {

        accounts = new ArrayList<>();

        loadAccounts();

    }



    public void addAccount(Accounts account) {

        accounts.add(account);

        saveAccounts();

    }



    public Accounts findAccount(String username) {


        for(Accounts account : accounts) {


            if(account.getUsername().equals(username)) {

                return account;

            }

        }


        return null;

    }



    public boolean usernameExists(String username) {


        for(Accounts account : accounts) {


            if(account.getUsername().equals(username)) {

                return true;

            }

        }


        return false;

    }




    public void saveAccounts() {


        try {


            FileWriter writer = new FileWriter(fileName);



            for(Accounts account : accounts) {


                writer.write(account.saveFormat() + "\n");


            }


            writer.close();



        } catch(IOException e) {


            System.out.println("Error saving accounts.");

        }

    }





    public void loadAccounts() {


        try {


            File file = new File(fileName);


            if(!file.exists()) {

                return;

            }



            Scanner scanner = new Scanner(file);



            while(scanner.hasNextLine()) {


                String line = scanner.nextLine();


                String[] data = line.split(",");



                Accounts account = new Accounts(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );



                accounts.add(account);

            }



            scanner.close();



        } catch(Exception e) {


            System.out.println("Error loading accounts.");

        }

    }

}