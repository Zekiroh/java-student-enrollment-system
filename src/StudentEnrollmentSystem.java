import java.util.Scanner;

public class StudentEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int educationChoice = 0;
        int programChoice = 0;
        String programName = "";
        String studentNumber = "";
        String paymentMessage = "";

        System.out.println("========== Student Enrollment System ==========");
        System.out.println("[Step 1] Profile");
        System.out.print("Enter full name: ");
        name = scanner.nextLine();

        System.out.println("\n[Step 2] Education");
        System.out.println("  [1] College");
        System.out.println("  [2] Senior Highschool");
        System.out.println("  [3] Junior Highschool");
        System.out.println("  [4] Kinder and Grade School");
        educationChoice = selectOption(scanner, 1, 4);

        if (educationChoice == 1) {
            System.out.println("\n[Step 3] Program");
            System.out.println("  College of Accounts and Business");
            System.out.println("          [1] Bachelor of Science in Accountancy");
            System.out.println("          [2] Bachelor of Science in Business Administration major in Financial Management and Business Analytics");
            System.out.println("          [3] Bachelor of Science in Business Administration major in Marketing Management and Multimedia Design");
            System.out.println("          [4] Bachelor of Science in Business Administration major in Operations and Service Management");
            System.out.println("  College of Computer Studies");
            System.out.println("          [5] Bachelor of Science in Information Technology with specialization in Animation and Game Development");
            System.out.println("          [6] Bachelor of Science in Information Technology with specialization in Web and Mobile Applications");
            programChoice = selectOption(scanner, 1, 6);
            programName = getCollegeProgramAcronym(programChoice);
        } else if (educationChoice == 2) {
            System.out.println("\n[Step 3] Strand");
            System.out.println("  Accountancy, Business and Management");
            System.out.println("          [1] ABM");
            System.out.println("          [2] ABM Specialization - Accountancy");
            System.out.println("          [3] ABM Specialization - Business Administration");
            System.out.println("  Science, Technology, Engineering and Mathematics");
            System.out.println("          [4] STEM");
            System.out.println("          [5] STEM Specialization - Information Technology");
            System.out.println("          [6] STEM Specialization - Engineering");
            System.out.println("          [7] STEM Specialization - Health Allied");
            System.out.println("          [8] GAS - General Academic Strand");
            System.out.println("          [9] HUMSS - Humanities and Social Sciences");
            System.out.println("          [10] Sports Track");
            programChoice = selectOption(scanner, 1, 10);
            programName = getSeniorHighSchoolAcronym(programChoice);
        } else if (educationChoice == 3) {
            System.out.println("\n[Step 3] Level");
            System.out.println("      [1] Grade 7");
            System.out.println("      [2] Grade 8");
            System.out.println("      [3] Grade 9");
            System.out.println("      [4] Grade 10");
            programChoice = selectOption(scanner, 1, 4);
            programName = getJuniorHighSchoolGradeLevel(programChoice);
        } else if (educationChoice == 4) {
            System.out.println("\n[Step 3] Level");
            System.out.println("      [1] Pre School");
            System.out.println("      [2] Kindergarten");
            System.out.println("      [3] Grade 1");
            System.out.println("      [4] Grade 2");
            System.out.println("      [5] Grade 3");
            System.out.println("      [6] Grade 4");
            System.out.println("      [7] Grade 5");
            System.out.println("      [8] Grade 6");
            programChoice = selectOption(scanner, 1, 8);
            programName = getKinderGradeSchoolLevel(programChoice);
        } else {
            System.out.println("Invalid education choice.");
            return;
        }

        // Generate a student number
        studentNumber = "2023" + generateRandomNumber(10000, 99999);

        System.out.println("\n[Step 4] Schedule");
        System.out.println("  [1] Blended learning - Online and Face-to-Face");
        System.out.println("  [2] Traditional learning - Face-To-Face");
        int scheduleChoice = selectOption(scanner, 1, 2);
        String scheduleType = (scheduleChoice == 1) ? "Blended" : "Traditional";

        System.out.println("\n[Step 5] Payment");
        double paymentAmount = getPaymentAmount(educationChoice);
        System.out.println("You need to pay: $" + paymentAmount);
        System.out.print("Enter payment (in dollars): $ ");
        double payment = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        if (payment >= paymentAmount) {
            paymentMessage = "\nYou are now enrolled to FEU Diliman!";
        } else {
            paymentMessage = "\nPayment is insufficient. Enrollment failed.";
        }

        System.out.println("\n\n=================== Status ===================");
        System.out.println("Name: " + name);
        System.out.println("Student Number: " + studentNumber);
        if (educationChoice == 2) {
            System.out.println("Strand: " + programName);
        } else if (educationChoice == 3 || educationChoice == 4) {
            System.out.println("Level: " + programName);
        } else {
            System.out.println("Program: " + programName);
        }
        System.out.println("Schedule: " + scheduleType);
        System.out.println(paymentMessage);
    }

    // Helper function to select an option with a range
    private static int selectOption(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            if (choice >= min && choice <= max) {
                break;
            } else {
                System.out.println("Please, try again.");
            }
        }
        return choice;
    }


    private static String getCollegeProgramAcronym(int choice) {
        switch (choice) {
            case 1:
                return "BSA";
            case 2:
                return "BSBA - FMBA";
            case 3:
                return "BSBA - M3D";
            case 4:
                return "BSBA - OSM";
            case 5:
                return "BSIT - AGD";
            case 6:
                return "BSIT - WMA";
            default:
                return "";
        }
    }

    private static String getSeniorHighSchoolAcronym(int choice) {
        switch (choice) {
            case 1:
                return "ABM";
            case 2:
                return "ABM - Accountancy";
            case 3:
                return "ABM - Business Admin";
            case 4:
                return "STEM";
            case 5:
                return "STEM - IT";
            case 6:
                return "STEM - Engineering";
            case 7:
                return "STEM - Health Allied";
            case 8:
                return "GAS";
            case 9:
                return "HUMSS";
            case 10:
                return "Sports Track";
            default:
                return "";
        }
    }

    private static String getJuniorHighSchoolGradeLevel(int choice) {
        switch (choice) {
            case 1:
                return "Grade 7";
            case 2:
                return "Grade 8";
            case 3:
                return "Grade 9";
            case 4:
                return "Grade 10";
            default:
                return "";
        }
    }

    private static String getKinderGradeSchoolLevel(int choice) {
        switch (choice) {
            case 1:
                return "Pre-School";
            case 2:
                return "Kindergarten";
            case 3:
                return "Grade 1";
            case 4:
                return "Grade 2";
            case 5:
                return "Grade 3";
            case 6:
                return "Grade 4";
            case 7:
                return "Grade 5";
            case 8:
                return "Grade 6";
            default:
                return "";
        }
    }

    private static double getPaymentAmount(int educationChoice) {
        switch (educationChoice) {
            case 1:
                return 1313.91;  // College
            case 2:
                return 1040.55;  // Senior Highschool
            case 3:
                return 793.64;  // Junior Highschool
            case 4:
                return 546.73;  // Kinder and Grade School
            default:
                return 0.0;
        }
    }

    // Generate a random number between min (inclusive) and max (exclusive)
    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}