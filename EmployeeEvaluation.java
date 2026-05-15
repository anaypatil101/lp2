import java.util.Scanner;

public class EmployeeEvaluation {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("EMPLOYEE PERFORMANCE EVALUATION SYSTEM");
        System.out.println("========================================");

        System.out.print("Enter the name of employee: ");
        String employeeName = sc.nextLine();

        int totalScore = 0;

        String[] questions = {
            "\n1. How punctual is the employee?\n(A: Always  B: Mostly  C: Sometimes  D: Rarely)",
            "2. Work quality?\n(A: Excellent  B: Good  C: Average  D: Poor)",
            "3. Team collaboration?\n(A: Very Good  B: Good  C: Average  D: Weak)",
            "4. Communication skills?\n(A: Excellent  B: Good  C: Average  D: Poor)",
            "5. Task completion rate?\n(A: Always  B: Mostly  C: Sometimes  D: Rarely)",
            "6. Problem solving ability?\n(A: Strong  B: Good  C: Average  D: Weak)",
            "7. Leadership skills?\n(A: Strong  B: Moderate  C: Low  D: None)",
            "8. Adaptability?\n(A: High  B: Good  C: Average  D: Low)",
            "9. Initiative taken?\n(A: Always  B: Often  C: Sometimes  D: Never)",
            "10. Attendance?\n(A: Excellent  B: Good  C: Average  D: Poor)",
            "11. Creativity?\n(A: High  B: Good  C: Average  D: Low)",
            "12. Discipline?\n(A: Very Good  B: Good  C: Average  D: Weak)",
            "13. Responsibility handling?\n(A: Excellent  B: Good  C: Average  D: Poor)",
            "14. Learning ability?\n(A: Fast  B: Good  C: Average  D: Slow)",
            "15. Overall contribution?\n(A: High  B: Good  C: Average  D: Low)"
        };

        System.out.println("Answer these questions: ");

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                System.out.println(questions[i]);
                System.out.print("Answer: ");
                String input = sc.nextLine().trim().toUpperCase();

                if (input.isEmpty()) {
                    System.out.println("Invalid option, please choose from A, B, C or D!");
                    continue;
                }

                char ans = input.charAt(0);

                if (ans == 'A') {
                    totalScore += 4;
                    break;
                } else if (ans == 'B') {
                    totalScore += 3;
                    break;
                } else if (ans == 'C') {
                    totalScore += 2;
                    break;
                } else if (ans == 'D') {
                    totalScore += 1;
                    break;
                } else {
                    System.out.println("Invalid option, please choose from A, B, C or D!");
                }
            }
            System.out.println();
        }

        System.out.println("Analyzing your results...");
        Thread.sleep(5000); // 5 seconds delay (replaces sleep(5))

        float percentage = (totalScore / 60.0f) * 100;

        System.out.println("========================================");
        System.out.println("          EVALUATION RESULT             ");
        System.out.println("========================================");
        System.out.println("Employee Name           : " + employeeName);
        System.out.println("Total Score             : " + totalScore + "/60");
        System.out.printf( "Percentage              : %.2f%%%n", percentage);
        System.out.println("----------------------------------------");

        if (percentage >= 85) {
            System.out.println("Grade                : A+");
            System.out.println("Performance Level    : EXCELLENT");
            System.out.println("Expert Advice        : Great employee. Should consider promotion or incentives.");
        } else if (percentage >= 70) {
            System.out.println("Grade                : A");
            System.out.println("Performance Level    : GOOD");
            System.out.println("Expert Advice        : Good employee. Provide advanced skill opportunities.");
        } else if (percentage >= 50) {
            System.out.println("Grade                : B+");
            System.out.println("Performance Level    : AVERAGE");
            System.out.println("Expert Advice        : Satisfactory employee. Needs improvement.");
        } else {
            System.out.println("Grade                : B");
            System.out.println("Performance Level    : POOR");
            System.out.println("Expert Advice        : Poor performer. Needs immediate improvement or put on PIP.");
        }

        sc.close();
    }
}