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


<img width="1107" height="315" alt="Screenshot 2025-09-19 at 02 46 52" src="https://github.com/user-attachments/assets/152de7f8-295a-4467-a633-ccfd3e288971" />
<img width="1639" height="673" alt="Screenshot 2025-09-19 at 02 47 32" src="https://github.com/user-attachments/assets/ecd2a97c-95b1-4b2a-be07-29fbf8417d86" />
<img width="1023" height="260" alt="Screenshot 2025-09-19 at 02 48 00" src="https://github.com/user-attachments/assets/471fbdad-8f7e-4e65-abc8-bfe9210eae03" />
<img width="1659" height="933" alt="Screenshot 2025-09-19 at 02 48 11" src="https://github.com/user-attachments/assets/2f150f4f-ef4c-4ee2-b73f-7120bd7705c0" />


