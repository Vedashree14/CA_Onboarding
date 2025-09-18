# CA Onboarding 

A simple **Community Ambassador (CA) onboarding system** that:  
- Generates **unique UTM links** for each ambassador.  
- Saves ambassador details into a **SQLite database**.  
- Sends a **welcome email** with the UTM link.  
- Displays a **summary dashboard** in the terminal.  

---

## Features
- **UTM Link Generator**  
  - Auto-creates `utm_source`, `utm_medium`, `utm_campaign`, and `utm_id`.  
  - Campaign auto-updates **monthly** (e.g., `IAC_CA_2025_09`).  

- **Database Integration**  
  - Uses **SQLite** to persist CA details.  
  - Schema includes name, email, UTM parameters, and generated link.  

- **Email Service**  
  - Sends a personalized **welcome email** with the UTM link.  
  - Uses **Jakarta Mail** + Gmail SMTP.  

- **Unit Tests**  
  - JUnit tests included for UTM generation logic.  

---

## Project Structure
src/main/java/org/example/
├── DatabaseService.java # SQLite DB handler
├── EmailService.java # Sends onboarding emails
├── Main.java # CLI for onboarding ambassadors
src/test/java/
└── CATestCases.java # Unit tests for UTM generation

## Tech Stack
- Java 17+  
- SQLite (via JDBC)  
- Jakarta Mail  
- JUnit 5 (for testing)

## Future Enhancements

- Add a leaderboard dashboard to rank ambassadors by traffic/signups.
- Integrate with Google Analytics for real-time performance tracking.
- Build a web-based admin panel.
