# CA Onboarding Automation (Java)

This project was developed as part of my internship at **Cloud Counselage**.  
It automates the Community Ambassador (CA) onboarding process for the **Industry Academia Community (IAC)**.

---

## Background
Community Ambassadors (CA) are the face of Industry Academia Community (IAC). They reach out to students to help them realise the opportunity to get job-ready in time.  
Each CA is provided with a unique UTM link that allows IAC to track their efforts in driving student engagement and participation.  

---

## Objective
The goal of this project is to **automate the CA onboarding workflow** by:
1. Generating a unique UTM link for each CA.
2. Sending a personalized welcome email with the UTM link.
3. Storing CA information (name, email, UTM link) in a database.
4. Providing an onboarding dashboard.
5. Enabling automated testing of workflows.

---

## ⚙Features
- **UTM Link Generation** → Creates a short, unique link for each CA using `UUID`.
- **Email Sending** → Sends real onboarding emails via SMTP (JavaMail API).
- **Database Persistence** → Stores CA records in **SQLite** for tracking.
- **Testing Suite** → Uses **JUnit** for workflow validation.
- **Command Line Interaction** → Simple CLI interface for CA input and onboarding dashboard.

---

## Tech Stack
- **Language:** Java (JDK 17+ recommended)  
- **Build Tool:** Maven  
- **Database:** SQLite (via JDBC driver)  
- **Email Service:** JavaMail API (SMTP)  
- **Testing Framework:** JUnit  

---

## How It Works
1. The CA enters their **name** and **email address**.  
2. The application generates a **unique UTM link**.  
3. The CA’s details and link are **stored in SQLite**.  
4. A **welcome email** is sent automatically to the CA.  
5. The onboarding **dashboard** confirms the details.  

---

## Testing
- Automated tests are written in **JUnit** to validate:
  - UTM link generation
  - Input validation
  - End-to-end onboarding workflow

## Environment Variables
The project uses environment variables (`.env`) for email credentials and configuration.  
Ensure that your `.env` file is created with the necessary SMTP settings before running the application.

---

## Future Enhancements
- Add GUI (JavaFX / Swing) for better user experience.  
- Build REST API with Spring Boot for integration with web apps.  
- Implement analytics dashboard for CA performance monitoring.  
