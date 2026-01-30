🚀 REST API Automation Framework

Java | TestNG | Rest Assured | Maven

📌 Overview

This repository contains a scalable, enterprise-ready REST API automation framework built using Java, TestNG, and Rest Assured.

The framework is designed for:

Functional API testing

Data-driven testing

API chaining

Authentication validation

Mock API testing

Reporting & logging

CI/CD execution

It follows real-world industry best practices and is suitable for medium to large automation projects.

🧱 Tech Stack

Java

TestNG

Rest Assured

Maven

Extent Reports

Apache Commons CSV

Jackson (JSON parsing)

WireMock (Mock APIs)

📂 Project Structure
src
 └── test
     ├── java
     │   ├── base
     │   │   ├── BaseTest.java
     │   │   └── BaseExtentTest.java
     │   │
     │   ├── auth
     │   │   └── AuthFactory.java
     │   │
     │   ├── client
     │   │   └── PostmanEchoClient.java
     │   │
     │   ├── listeners
     │   │   └── ExtentTestListener.java
     │   │
     │   ├── utils
     │   │   ├── ConfigReader.java
     │   │   ├── JsonUtils.java
     │   │   ├── CsvUtils.java
     │   │   ├── TestDataProvider.java
     │   │   ├── RetryUtils.java
     │   │   └── ExtentLogger.java
     │   │
     │   └── tests
     │       ├── ApiChainingTest.java
     │       ├── DataDrivenApiTest.java
     │       ├── MockApiTest.java
     │       └── ExtentReportTestCases.java
     │
     └── resources
         ├── config
         │   ├── qa.properties
         │   ├── stage.properties
         │   └── prod.properties
         │
         ├── testdata
         │   ├── users.csv
         │   └── users.json
         │
         └── schemas
             └── get-schema.json

🌍 Environment Management

Environment-specific configurations are externalized using property files.

Example (qa.properties)
base.uri=https://postman-echo.com
base.path=
timeout.ms=3000
retry.count=3

Run tests with environment
mvn clean test -Denv=qa
mvn clean test -Denv=stage
mvn clean test -Denv=prod

🔐 Authentication Support

Authentication is centralized using AuthFactory.

Supported types

Basic Authentication

Bearer Token

OAuth 2.0 (Client Credentials)

This avoids duplication and keeps tests clean.

🔗 API Chaining

The framework supports API chaining, where data from one API is reused in subsequent APIs.

Example flow
POST → extract ID → GET → DELETE → GET (404)


Used for validating real end-to-end API workflows.

📊 Data-Driven Testing
Supported formats

✅ CSV (recommended)

✅ JSON

Why CSV?

Lightweight

Human-readable

Git-friendly

Easy merge & diff

CI/CD friendly

Strategy for “multiple sheets”

One CSV per logical entity (users, orders, payments)

Folder-based data organization

Parallel team-friendly approach

🧪 Mock API Testing

Mock APIs are supported using WireMock.

Use cases

Backend not ready

Stable and predictable responses

Error and edge-case simulation (4xx / 5xx)

CI-safe execution

🔁 Retry Mechanism

Retry logic is centralized in RetryUtils.

Features

Configurable retry count

Delay between retries

Used only for unstable or async APIs

Keeps retry logic out of tests

📈 Reporting
✅ Extent Reports (Integrated)

TestNG listener-based integration

Thread-safe logging

PASS / FAIL / INFO logs

Centralized logging via ExtentLogger

📄 Report output:

test-output/ExtentReport.html

🧾 Schema Validation

JSON Schema validation is supported to ensure API contract integrity.

Benefits

Detects breaking API changes

Reduces brittle assertions

Improves long-term test stability

🧠 Best Practices Followed

No hardcoded URLs or credentials

Config-driven execution

Clean separation of concerns

Reusable utilities

Git-friendly test data

CI/CD ready

▶️ How to Run Tests
Command line
mvn clean test

Eclipse

Right-click project → Run As → Maven test

Or use Run Configurations with -Denv=qa

🌐 Sample APIs Used

Postman Echo public APIs

OAuth playground APIs

Mock APIs via WireMock

🎯 Future Enhancements

Allure report integration

Database validation layer

Parallel execution

CI pipeline integration

API contract testing (OpenAPI)
