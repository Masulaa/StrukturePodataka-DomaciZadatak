# Minesweeper Simulation Project

## Overview

This project is an automated Minesweeper simulator implemented in Java using Object-Oriented Programming principles and custom data structures.

The application simulates a large number of Minesweeper matches played by automated bots, stores match telemetry inside a CSV file, and performs statistical analysis using Java Streams and the Collections Framework.

---

# Features

- Full Minesweeper game engine
- Random mine generation
- BFS-based cascade reveal algorithm
- Custom FIFO Queue implementation
- Custom Singly Linked List implementation
- Automated bot player
- Mass simulation of matches
- CSV telemetry generation
- Stream-based statistical analysis

---

# How to Run

## 1. Generate Match Dataset

Run:

```java
Main()
```

This generates:

```text
matches.csv
```

inside the project root directory.

---

## 2. Analyze Dataset

Run:

```java
TestMatchesAnalysis.main()
```

Example output:

```text
===== MATCH ANALYSIS REPORT =====

Average clicks in VICTORY: 4.33
Average clicks in DEFEAT: 4.10

Fastest match:
Match ID: 2, Time: 0ms

Match with highest Click Rate:
Match ID: 993

Total victories: 3
```

---

# Important Notes

- BFS reveal logic is fully iterative
- Recursion is not used
- Queue implementation is fully encapsulated
- Custom linked list is implemented manually
- CSV parsing supports multiple delimiters
- The bot behavior is intentionally random

---

