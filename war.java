import java.util.Scanner;

public class war {
    public int numOfKilled = 1400;
    public int numOfKidnap = 224;
    public String President = "itzhak herzog";
    public String PrimeMinister = "Binyamin Netanyahu";
    public String MinisterOfDefence = "Galant";

    public int getNumOfKilled() {
        return numOfKilled;
    }

    public int getNumOfKidnap() {
        return numOfKidnap;
    }

    public void setNumOfKidnap(int numOfKidnap) {
        this.numOfKidnap = numOfKidnap;
    }

    public void setNumOfKilled(int numOfKilled) {
        this.numOfKilled = numOfKilled;
    }

    public String getPresident() {
        return President;
    }

    public String getPrimeMinister() {
        return PrimeMinister;
    }

    public String getMinisterOfDefence() {
        return MinisterOfDefence;
    }

    public static void main(String[] args) {
        boolean flag=true;
        while (flag) {
            System.out.println("Hello and Welcome to my system. this system gives you information about Haravot Barzel war.");
            Scanner id = new Scanner(System.in);
            System.out.println("whats your name?");
            Scanner name = new Scanner(System.in);
            String Name = name.nextLine();
            System.out.println("hello " + Name + ". I hope you are OK ");
            System.out.println("please choose the information you want to get: ");
            System.out.println("1- information about the government. " +
                    "2-information about killed and kidnap.");

            Scanner ans = new Scanner(System.in);
            int ans1 = ans.nextInt();
            if (ans1 == 1) {
                System.out.println("1- who is the President today " +
                        "2- who is the Prime Minister today " +
                        "3- who is the Minister Of Defence today ");
                Scanner ans2 = new Scanner(System.in);
                int ans22 = ans2.nextInt();
                if (ans22 == 1) {
                    System.out.println("Itzhak Hertzog");
                }
                if (ans22 == 2) {
                    System.out.println("Binyamin Netanyahu");
                }
                if (ans22 == 3) {
                    System.out.println("Gallant");
                }
                System.out.println("to continue press 0.  To go out press any number");
                Scanner hi1 = new Scanner(System.in);
                int hi11 = hi1.nextInt();
                if (hi11 == 0) {
                    flag=true;
                }
                else {flag = false;}
            }
            if ((ans1 == 2)) {
                System.out.println("1- number of dead's " +
                        "2- number of kidnap");
                Scanner ans3 = new Scanner(System.in);
                int ans33 = ans3.nextInt();
                if (ans33 == 1) {
                    System.out.println(1400 + "dead's");
                }
                if (ans33 == 2) {
                    System.out.println(224 + "kidnap");
                }
                System.out.println("to continue press 0. Tרo go out press any number");
                Scanner hi1 = new Scanner(System.in);
                int hi11 = hi1.nextInt();
                if (hi11 == 0) {
                    flag=true;
                }
                else {flag = false;}

            }


        }
        System.out.println("I hope you and your family are ok. Have a Good news!! ");
    }
}

