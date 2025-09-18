package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static class UTMData {
        public final String utmSource;
        public final String utmMedium;
        public final String utmCampaign;
        public final String utmId;
        public final String utmLink;

        public UTMData(String caName) {
            this.utmSource = caName.replace(" ", "_");
            this.utmMedium = "ambassador";

            LocalDate today = LocalDate.now();
            this.utmCampaign = "IAC_CA_" + today.getYear() + "_" + String.format("%02d", today.getMonthValue());

            this.utmId = UUID.randomUUID().toString().substring(0, 8);

            String baseUrl = "https://www.industryacademiacommunity.com/";
            this.utmLink = baseUrl
                    + "?utm_source=" + utmSource
                    + "&utm_medium=" + utmMedium
                    + "&utm_campaign=" + utmCampaign
                    + "&utm_id=" + utmId;
        }
    }

    private static void onboardCA(Scanner scanner) {
        System.out.print("Enter your full name: ");
        String caName = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        // Generate UTM data
        UTMData utm = new UTMData(caName);

        // Save to database
        DatabaseService.saveCA(caName, email, utm.utmSource, utm.utmMedium, utm.utmCampaign, utm.utmId, utm.utmLink);

        // Send email
        EmailService.sendWelcomeEmail(email, caName, utm.utmLink);

        // Dashboard for this CA
        System.out.println("\n--- CA Onboarding Summary ---");
        System.out.println("Name: " + caName);
        System.out.println("Email: " + email);
        System.out.println("UTM Source: " + utm.utmSource);
        System.out.println("UTM Medium: " + utm.utmMedium);
        System.out.println("UTM Campaign: " + utm.utmCampaign);
        System.out.println("UTM ID: " + utm.utmId);
        System.out.println("Your UTM Link: " + utm.utmLink);
    }

    private static void showDashboard() {
        List<String> records = DatabaseService.fetchAllCAs();
        if (records.isEmpty()) {
            System.out.println("\n📭 No CA registrations found.");
        } else {
            System.out.println("\n--- CA Onboarding Dashboard ---");
            for (String record : records) {
                System.out.println(record);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Onboard a new CA");
        System.out.println("2. View Dashboard");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            onboardCA(scanner);
        } else if (choice == 2) {
            showDashboard();
        } else {
            System.out.println("❌ Invalid choice. Exiting.");
        }

        scanner.close();
    }
}
