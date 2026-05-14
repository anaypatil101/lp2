# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

This is a SPPU 6th Semester LP2 (Laboratory Practice 2) practical exam repository. It contains two categories of practicals:
1. **Java AI/Algorithm implementations** — run locally via JDK
2. **Salesforce Apex** — deployed and executed in a Salesforce Developer org

---

## Java Practicals

### Compile and Run

```bash
# Compile
javac NQueens.java
javac Greedy.java
javac FamilyTree.java

# Run
java NQueens
java Greedy
java FamilyTree
```

No build tool (Maven/Gradle) is used — plain `javac`/`java` commands suffice.

### What Each File Does

| File | Algorithm | Technique |
|------|-----------|-----------|
| `NQueens.java` | N-Queens | Backtracking (row-by-row placement) |
| `Greedy.java` | Selection Sort + Prim's MST + Dijkstra | Greedy algorithms; adjacency matrix graph |
| `FamilyTree.java` | BFS + DFS on a family graph | Graph traversal using `HashMap<String, List<String>>` |

- `Greedy.java` has a single hardcoded 9-node graph in `main()`; only `prims()` is called by default — call `dijkstra()` separately if needed.
- `FamilyTree.java` uses `visited` and `que` as instance fields, so a fresh `FamilyTree` object is needed before each traversal.

---

## Chatbot Practical

**Location:** `chatbot/`

Open `chatbot/index.html` directly in a browser — no server required.

- Rule-based restaurant chatbot; responses are a keyword-to-string map in `script.js`.
- Supports Enter key and button click to send messages.
- To add new topics, add entries to the `responses` object in `script.js`.

---

## Salesforce Practicals

**Location:** `salesforce/`

All Apex code must be deployed to a Salesforce Developer org. Each subfolder has a specific custom object that must exist in the org before running.

### Folder Structure

| Folder | Custom Object | Type |
|--------|---------------|------|
| `employee_vfp/` | `Employee__c` | Anonymous Apex (+ menu variant) |
| `bank_account/` | `BankAccount__c` | Anonymous Apex (+ menu variant) |
| `product_inventory/` | `Product_Inventory__c` | Visualforce page + Controller |
| `student/` | `Student__c` | Visualforce page + Controller (full CRUD incl. edit) |

### Execution Patterns

**Anonymous Apex (employee_vfp, bank_account):**
Each folder has two class variants:
- `EmployeeManagement.apxc` / `BankAccountSystem.apxc` — direct static method calls
- `EmployeeManagement_m.apxc` / `BankAccountSystem_m.apxc` — menu-driven via `menu(Integer choice)`

Run snippets from `run.txt` in Salesforce Developer Console → Execute Anonymous.

**Visualforce pages (product_inventory, student):**
- Deploy both `.apxc` (controller) and `.vfp` (page) to the org.
- Access via: `https://<your-org>.salesforce.com/apex/ProductPage` or `StudentPage`.
- The `StudentController` supports edit/update (loads record into form via `editStudent()`); `ProductController` only supports insert/delete.

### Required Custom Object Fields

`Employee__c` / `BankAccount__c`: `Emp_ID__c` (Number), `Emp_Name__c`, `Email__c`, `Birth_Date__c` (Date), `Department__c`

`Product_Inventory__c`: `Product_Name__c`, `Serial_No__c`, `Manufacture_Date__c`, `Expiry_Date__c`

`Student__c`: `RollNo__c`, `Class__c`, `Mobile_No__c`
