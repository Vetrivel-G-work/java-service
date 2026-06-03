# Calculator App — Jenkins + SonarQube Demo

A simple Java Maven project to demonstrate a full CI/CD pipeline with:
- **Jenkins** (build, test, quality gate)
- **SonarQube** (static analysis + coverage)
- **Docker** (containerized build & run)
- **GitHub** (source control trigger)

---

## Project Structure

```
java-sonar-demo/
├── src/
│   ├── main/java/com/demo/calculator/
│   │   ├── Calculator.java       # Core logic
│   │   └── Main.java             # Entry point
│   └── test/java/com/demo/calculator/
│       └── CalculatorTest.java   # JUnit 5 tests (25+ cases)
├── Dockerfile                    # Multi-stage build
├── Jenkinsfile                   # Full CI/CD pipeline
├── pom.xml                       # Maven + JaCoCo + Sonar config
└── README.md
```

---

## Prerequisites

| Tool         | Version  |
|--------------|----------|
| Java         | 17+      |
| Maven        | 3.9+     |
| Docker       | 20+      |
| Jenkins      | 2.400+   |
| SonarQube    | 9.x / 10.x |

---

## Local Build & Test

```bash
# Run tests
mvn clean test

# Full build with coverage report
mvn clean verify

# Run the app
mvn clean package -DskipTests
java -jar target/calculator-app-1.0.0.jar
```

---

## Docker

```bash
# Build image
docker build -t calculator-app:latest .

# Run container
docker run --rm calculator-app:latest
```

---

## Jenkins Setup

### 1. Install Jenkins Plugins
- **SonarQube Scanner**
- **JaCoCo**
- **Pipeline**
- **Git**
- **Docker Pipeline** *(optional)*

### 2. Configure SonarQube Server in Jenkins
`Manage Jenkins → Configure System → SonarQube servers`
- Name: `SonarQube`
- URL: `http://<your-sonarqube-host>:9000`
- Token: Add credentials → Secret text → ID: `sonar-token`

### 3. Configure Global Tools
`Manage Jenkins → Global Tool Configuration`
- JDK: Name `JDK-17`, install automatically
- Maven: Name `Maven-3.9`, install automatically

### 4. Create Pipeline Job
- New Item → Pipeline
- Definition: **Pipeline script from SCM**
- SCM: **Git** → your GitHub repo URL
- Branch: `*/main`
- Script Path: `Jenkinsfile`

### 5. GitHub Webhook (auto-trigger)
In your GitHub repo → Settings → Webhooks → Add webhook:
- Payload URL: `http://<jenkins-host>/github-webhook/`
- Content type: `application/json`
- Events: **Just the push event**

---

## SonarQube Quality Gate

The pipeline will **fail automatically** if the project does not pass the SonarQube Quality Gate (configurable in your SonarQube project settings).

Default checks include:
- Code coverage ≥ 80%
- No new bugs
- No new vulnerabilities
- No new code smells (blocker/critical)

---

## Pipeline Stages

```
Checkout → Build → Unit Tests → Code Coverage → SonarQube Analysis
       → Quality Gate → Package → Docker Build
```
