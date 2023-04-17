import java.util.Scanner;

public class DaysInAMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] monthFullNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        String[] month3Letters = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        boolean isValidMonth = false;
        boolean isValidYear = false;
        int month = 0;
        int year = 0;
        
        while (!isValidMonth) {
            System.out.print("Enter the month (in full name, abbreviation, in 3 letters, or in number): ");
            String monthInput = scanner.nextLine();
            for (int i = 0; i <= 11; i++) {
                if (monthInput.equals(monthFullNames[i]) || monthInput.equals(monthAbbreviations[i]) 
                    || monthInput.equals(month3Letters[i]) || monthInput.equals(monthNumbers[i])) 
                {
                    month = i;
                    isValidMonth = true;
                }
            }
            if (!isValidMonth) {
                System.out.println("Invalid month! Please try again.");
            }
        }
        
        while (!isValidYear) {
            System.out.print("Enter the year (in non-negative number): ");
            String yearInput = scanner.nextLine();
            try {
                year = Integer.parseInt(yearInput);
                if (year < 0) {
                    System.out.println("Year must be a non-negative number. Please try again.");
                } else {
                    isValidYear = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Please try again.");
            }
        }
        
        int days = monthDays[month];
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) days += 1;
        
        System.out.println(monthFullNames[month] + " " + year + " has " + days + " days.\n");
        
        System.exit(0);
    }
}

