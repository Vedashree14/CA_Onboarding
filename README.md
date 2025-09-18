# CA Onboarding Automation (Java)

This project was developed as part of my internship at **Cloud Counselage**.  
It automates the Community Ambassador (CA) onboarding process for the **Industry Academia Community (IAC)** with UTM tracking, database persistence, and email automation.

---

## Background
Community Ambassadors (CAs) are the face of Industry Academia Community (IAC).  
They help students discover opportunities to become job-ready in time.  

To measure each ambassador’s contribution, every CA is provided with a unique UTM link.  
These links allow IAC to track traffic, engagement, and conversions driven by each ambassador.

---

## Objectives
This project automates the CA onboarding workflow by:
1. Generating a unique UTM link with:
   - `utm_source` → CA name  
   - `utm_medium` → ambassador  
   - `utm_campaign` → monthly auto-updated campaign (e.g., `IAC_CA_2025_09`)  
   - `utm_id` → unique UUID segment  
2. Sending a personalized welcome email with the UTM link.  
3. Storing CA details (name, email, UTM parameters, and link) in SQLite.  
4. Displaying an onboarding dashboard summary in the CLI.  
5. Running automated tests to validate workflows.  

---

## Features
- Dynamic UTM Generation → Every CA gets a unique link with monthly campaigns auto-updating.  
- Database Persistence → CA details stored in SQLite for future analytics.  
- Email Automation → Sends onboarding emails via SMTP (Jakarta Mail API).  
- Onboarding Dashboard → Displays CA details and generated UTM link in the terminal.  
- Testing Suite → JUnit tests validate UTM logic and onboarding flow.  

---

## Tech Stack
- Java (JDK 17+)  
- Maven  
- SQLite (via JDBC)  
- Jakarta Mail (SMTP with Gmail)  
- Dotenv (for `.env` secrets)  
- JUnit 5  

---

## How It Works
1. The CA enters their name and email address.  
2. The system generates a unique UTM link with monthly auto-updating campaign.  
3. The CA’s details are stored in SQLite.  
4. A welcome email (with UTM link) is sent automatically.  
5. A CLI dashboard summary confirms details.  

---

## Future Enhancements

- Add leaderboard dashboard to rank CAs by traffic/signups.
- Integrate with Google Analytics for real-time tracking.
- Build a Spring Boot REST API for integration with web apps.
- Add JavaFX GUI for user-friendly onboarding.
