package org.example;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static String generateUTMLink(String caName) {
        String baseUrl = "https://www.industryacademiacommunity.com/";
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        return baseUrl + "?utm_source=CA&utm_medium=" + caName.replace(" ", "_") + "&utm_id=" + uniqueId;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String caName = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        String utmLink = generateUTMLink(caName);

        // Save to database
        DatabaseService.saveCA(caName, email, utmLink);

        // Send email
        EmailService.sendWelcomeEmail(email, caName, utmLink);

        // Dashboard
        System.out.println("\n--- CA Onboarding Dashboard ---");
        System.out.println("Name: " + caName);
        System.out.println("Email: " + email);
        System.out.println("Your UTM Link: " + utmLink);

        scanner.close();
    }
}
