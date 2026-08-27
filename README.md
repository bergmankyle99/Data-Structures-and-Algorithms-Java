<h1 align="center">
  📚 Data Structures & Algorithms — Java
</h1>
<p align="center">Thompson Rivers University — COMP 2230 (Data Structures)</p>
<p align="center">
  A collection of core data structures and applied algorithm projects implemented from scratch in Java.
</p>

<p align="center">
  Built with Java and NetBeans.
</p>

---

## 🚀 Overview

This repository is a collection of standalone Java projects built for **COMP 2230 — Data Structures** at Thompson Rivers University.

Each folder implements a data structure from first principles (no built-in Java collections doing the heavy lifting) and/or a driver program that puts it to use in an applied algorithm, simulation, or small game.

The goal of these projects was to build a solid foundation in:

- Core data structure design and implementation
- Generic programming in Java
- Algorithmic problem solving
- Recursion and traversal
- Graph and set-based algorithms

---

# ✨ Projects

## 🧱 Core Data Structures

| Project | Description |
|---|---|
| `ArrayBox` | Generic resizable array (à la `ArrayList`) built on a raw backing array, with automatic growth. |
| `StackBox` / `StackBox2` | Generic array-backed stack implementation (two iterations). |
| `QueueBox` | Generic array-backed queue implementation. |
| `LinkedPractice` | Generic singly linked list with a driver for hands-on pointer manipulation. |
| `LinkedListProject -No Sorting` | Ordered singly linked list — base version without sort support. |
| `LinkedListProject -Sorting` | Ordered singly linked list, extended to support sorted insertion. |
| `LinkedListProject3` | Third iteration of the ordered linked list assignment. |
| `BST` | Generic Binary Search Tree (`BinarySearchTree` + `BinarySearchTreeVertex`) with an insert/traversal driver. |
| `BinaryHeapMin` | Generic array-backed min-heap with add / remove-min operations. |
| `ReHash` | Custom generic hash table (`HashBox`) implementing chaining and rehashing on load. |
| `UnionFind` | Generic Union-Find / Disjoint Set data structure with a driver. |

---

## 🧩 Applied Algorithm Projects

| Project | Description |
|---|---|
| `UnionFindPart2` | Randomized grid `Maze` generator that uses Union-Find to identify connected regions, with ANSI-colored terminal output. |
| `ZooKeeper` | Interactive console app — generates a random zoo enclosure grid, uses Union-Find to group cells into connected regions, and lets the user assign animals to regions via a menu. |
| `SkysTheLimit` | Builds a **minimum spanning tree** over real-world city data (`worldcities.csv`) using a min-heap for edge selection and Union-Find for cycle detection (Kruskal's algorithm). |
| `FinalExam` | Final exam project — generates a randomized maze as a weighted graph and computes a minimum spanning tree over it using `BinaryHeapMin`, `UnionFind`, and `GraphEdge`. |
| `Solitare` | A playable Klondike Solitaire simulation (`Deck`, `Tableau`, `Foundations`, `Waste`) demonstrating stack-based game logic. |
| `DontCrossMe` | Recursive cross-product calculator for two integer arrays — recursion practice. |
| `FindNegatives` | Simple array traversal exercise that finds negative values in a randomly generated array. |
| `RandomPick` | Small utility for random selection from user input. |

---

# 🧠 Concepts Covered

- Generics in Java (`<E>`, `<K, V>`)
- Arrays, stacks, and queues built from scratch
- Singly linked lists (unsorted, sorted / ordered insertion)
- Binary search trees
- Binary heaps (min-heap) and priority-based structures
- Hash tables with chaining and rehashing
- Union-Find / Disjoint Set with region detection
- Graph algorithms — minimum spanning trees (Kruskal's algorithm)
- Recursion
- Applied simulations (maze generation, solitaire card game)

---

# 🛠 Technology Stack

## Language

### Java

Used for:

- All data structure implementations
- Driver programs and simulations
- Console-based user interaction

## IDE

### NetBeans

Project templates and file headers reflect a NetBeans development environment.

---

# 🏗 Project Structure

```
Data Structures and Algorithms - Java/
        |
        ├── Core Data Structures
        │        ├── ArrayBox
        │        ├── StackBox / StackBox2
        │        ├── QueueBox
        │        ├── LinkedPractice / LinkedListProject*
        │        ├── BST
        │        ├── BinaryHeapMin
        │        ├── ReHash
        │        └── UnionFind
        |
        └── Applied Algorithms
                 ├── UnionFindPart2
                 ├── ZooKeeper
                 ├── SkysTheLimit
                 ├── FinalExam
                 ├── Solitare
                 ├── DontCrossMe
                 ├── FindNegatives
                 └── RandomPick
```

---

# 💻 Running Locally

## Requirements

Install:

- JDK 8+
- (Optional) NetBeans IDE

---

## Clone Repository

```bash
git clone https://github.com/bergmankyle99/data-structures-and-algorithms-java.git

cd "Data Structures and Algorithms - Java"
```

---

## Run a Project

Each folder is self-contained. Compile and run a given project's driver directly:

```bash
cd ProjectName
javac *.java
java DriverClassName
```

Example:

```bash
cd ZooKeeper
javac *.java
java ZooKeeperDriver
```

> **Note:** `SkysTheLimit` reads from a local file (`worldcities.csv`). The original file path is hardcoded from development on Windows — update the path in the source before running.

---

# 🎯 Project Purpose

This repository documents foundational data structures work completed during a Computer Science degree, implementing classic structures and algorithms from scratch rather than relying on Java's built-in collections.

It demonstrates experience with:

- Data structure design and implementation
- Algorithmic thinking and problem solving
- Generic, reusable Java code
- Graph and set-based algorithms
- Applied simulations and small interactive programs

---

# 👤 Author

**Kyle Bergman**
