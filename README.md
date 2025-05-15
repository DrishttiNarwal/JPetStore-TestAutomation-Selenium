# JPetStore-TestAutomation-Selenium

A Maven-based Selenium automation framework for functional testing of the JPetStore demo e-commerce website. This project automates key user workflows including login, product selection, cart operations, and full payment checkout using a data-driven approach powered by TestNG.

## 🚀 Features

- End-to-end test coverage: Login → Product Selection → Cart → Checkout → Sign-out
- Data-Driven Testing using TestNG `@DataProvider`
- Selenium WebDriver automation with Chrome browser
- Dynamic waits for stable execution
- Structured test reports and test-output logs

## 🧰 Tech Stack

| Category        | Tools Used                     |
|----------------|----------------------------------|
| Language        | Java                            |
| Automation Tool | Selenium WebDriver              |
| Testing         | TestNG                          |
| Build Tool      | Maven                           |
| Dependency Mgmt | WebDriverManager                |
| IDE             | VS Code / Eclipse               |
| Target URL      | [JPetStore Demo](https://jpetstore.aspectran.com/account/signonForm) |

## 📂 Project Structure

```
JPetStore-TestAutomation-Selenium/
├── src/
│   ├── main/java/
│   │   └── MavenTestNG/       # Main app logic (if any)
│   ├── test/java/
│       └── MavenTestNG/       # Test scripts
│           ├── App.java
│           ├── DdLogin1.java
│           ├── NewTest1.java
│           └── STT_Final_Demo.java
├── test-output/               # Test reports
├── pom.xml                    # Maven dependencies and build config
├── .classpath / .project      # Eclipse project files
├── README.md                  # Project documentation
```

## ✅ Test Cases Covered

1. **Valid Login & Successful Checkout**  
   Automates the full user journey: login, add product to cart, enter payment info, and place order.

2. **Invalid Login Scenarios**  
   Validates incorrect credentials, empty fields, and special character inputs with proper error handling.

## 🧪 How to Run

### 🛠️ Option 1: Run Using Eclipse

#### 1. Prerequisites
- Eclipse IDE with Maven and TestNG support
- JDK 8 or above
- Chrome browser

#### 2. Import the Project
1. Open Eclipse.
2. Go to **File > Import > Maven > Existing Maven Projects**.
3. Select the cloned project folder.
4. Click **Finish** to import.

#### 3. Add TestNG Library (if needed)
- Right-click the project → **Build Path > Add Libraries > TestNG** → Apply & Close.

#### 4. Run the Test
- Expand `src/test/java` → Right-click on `STT_Final_Demo.java` (or your test class) → **Run As > TestNG Test**.
- View results in the **Console** and **test-output/** folder.

---

### 💻 Option 2: Run Using VS Code

#### 1. Prerequisites
- VS Code with Java, Maven, and TestNG extensions
- JDK 8 or above
- Chrome browser

#### 2. Open the Project
- Open the project folder in VS Code.

#### 3. Install Extensions (if not installed)
- Java Extension Pack (by Microsoft)
- TestNG for Java
- Maven for Java

#### 4. Run Test Using Terminal
```bash
mvn clean install
mvn test
```

Or, right-click on the test class file (e.g., `STT_Final_Demo.java`) and select **Run TestNG Test** if the extension supports it.

---

### 📁 Output
- Test reports will be available in the `test-output/` directory.
- Console logs and pass/fail results are visible in the output terminal.


## 📌 Author
**Drishtti Narwal**  
B.Tech AI & ML  
Symbiosis Institute of Technology, Pune

---

> This project was built for academic purposes and demonstrates real-world skills in test automation using Selenium and Java.
