# Java Exercises

A comprehensive collection of intuitive, hands-on exercises written in Java to enhance programming skills and master core Java concepts.

---

## 📚 Overview

This repository contains practical exercises designed to help developers strengthen their Java proficiency. Each exercise focuses on real-world scenarios and covers essential programming paradigms including object-oriented design, file I/O, multithreading, and design patterns.

Perfect for:
- **Beginners** looking to solidify fundamental Java concepts
- **Intermediate developers** seeking to refine their skills
- **Learners** preparing for technical interviews
- **Everyone** interested in clean code and best practices

---

## 🎯 Exercises

### 1. **E-Commerce System** 📦
**Location:** `ECommerce_Exercise/`

A fully functional e-commerce application demonstrating core OOP principles and design patterns.

**Key Features:**
- Order management system with product tracking
- Dynamic discount system (percentage, fixed, or no discount)
- Tax calculation on orders
- Inventory management with stock validation
- Revenue tracking across multiple orders
- Interactive CLI menu interface

**Concepts Covered:**
- Encapsulation & Abstraction
- Polymorphism (Discount Strategy Pattern)
- Collections (HashMap)
- Interface implementation

**Files:**
- `Main.java` - Interactive menu system
- `Order.java` - Order handling with tax calculations
- `Product.java` - Product representation with inventory
- `OrderManager.java` - Order persistence and analytics
- `Discounts/` - Abstract discount strategies

---

### 2. **Text Analyzer** 📝
**Location:** `Text_Analyzer_Exercise/`

A sophisticated file analysis tool that processes text documents and provides comprehensive statistics.

**Key Features:**
- Load and parse `.txt` files dynamically
- Word counting and frequency analysis
- Sentence segmentation and counting
- Paragraph detection
- Average word length calculation
- Estimated reading time
- Comprehensive summary reports

**Concepts Covered:**
- File I/O operations (FileReader, BufferedReader)
- String manipulation & parsing
- Data structures (Arrays, Collections)
- Algorithm design
- User input validation

**Files:**
- `Main.java` - Interactive CLI interface
- `FileLoader.java` - File reading utilities
- `TextAnalyzer.java` - Core analysis logic

---

### 3. **Alarm Clock** ⏰
**Location:** `Alarm_Clock_Exercise/`

A multithreaded alarm clock implementation with audio playback capabilities.

**Key Features:**
- Set alarms for specific times
- Real-time clock display with countdown
- Audio playback with loop functionality
- Thread-safe alarm triggering
- User-friendly interrupt controls

**Concepts Covered:**
- Multithreading (Thread, Runnable)
- Java sound API (AudioInputStream, Clip)
- Time handling (LocalTime)
- Exception handling
- Thread synchronization

**Files:**
- `AlarmClock.java` - Core alarm logic with audio playback
- `Main.java` - User interface and setup

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- A terminal or IDE (Eclipse, IntelliJ, VS Code)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/danielfagundes07/java-exercises.git
   cd java-exercises
   ```

2. **Compile the project:**
   ```bash
   javac -d out --source-path . $(find . -name "*.java")
   ```

3. **Run an exercise:**
   ```bash
   java -cp out exercises.ECommerce_Exercise.Main
   java -cp out exercises.Text_Analyzer_Exercise.Main
   java -cp out exercises.Alarm_Clock_Exercise.Main
   ```

---

## 📖 Learning Path

**Beginner Level:**
1. Start with the **E-Commerce System** to understand OOP fundamentals
2. Explore design patterns with the discount strategy implementation

**Intermediate Level:**
1. Move to the **Text Analyzer** for file I/O and algorithm practice
2. Work with collections and string manipulation

**Advanced Level:**
1. Study the **Alarm Clock** for multithreading concepts
2. Understand resource management and thread safety

---

## 💡 Key Concepts Demonstrated

| Concept | Exercise | Details |
|---------|----------|---------|
| **OOP & Polymorphism** | E-Commerce | Discount strategy pattern |
| **File I/O** | Text Analyzer | Reading and parsing files |
| **Collections** | E-Commerce, Text Analyzer | HashMap, Arrays |
| **Multithreading** | Alarm Clock | Thread management, synchronization |
| **Exception Handling** | All Exercises | Try-catch, custom error messages |
| **Design Patterns** | E-Commerce | Strategy Pattern |

---

## 📝 Usage Examples

### Running E-Commerce
```
WELCOME TO E-COMMERCE

*************************

     1. Create new order
     2. Add product to order
     3. Apply discount
     4. Finalize order
     5. View all orders
     6. View total revenue
     7. Exit
     Type your choice: 
```

### Running Text Analyzer
```
Please type your current file path (or Q to quit): sample.txt

1 - Count Words
2 - Count Sentences
3 - Count Paragraphs
4 - Summary
5 - Quit
```

### Running Alarm Clock
```
Set your alarm time (HH:MM:SS): 14:30:00
Provide audio file path: alarm.wav
00:00:15  [Countdown running...]
```

---

## 🎓 What You'll Learn

- ✅ Object-Oriented Programming principles
- ✅ Design patterns (Strategy Pattern, etc.)
- ✅ File I/O and data processing
- ✅ Multithreading and concurrency
- ✅ Exception handling and error management
- ✅ Clean code practices
- ✅ Effective use of Java APIs
- ✅ Problem-solving methodologies

---

## 📂 Project Structure

```
java-exercises/
├── ECommerce_Exercise/
│   ├── Main.java
│   ├── Order.java
│   ├── Product.java
│   ├── OrderManager.java
│   ├── Taxable.java
│   └── Discounts/
│       ├── Discount.java
│       ├── PercentageDiscount.java
│       ├── FixedDiscount.java
│       └── NoDiscount.java
├── Text_Analyzer_Exercise/
│   ├── Main.java
│   ├── FileLoader.java
│   └── TextAnalyzer.java
├── Alarm_Clock_Exercise/
│   ├── Main.java
│   └── AlarmClock.java
└── README.md
```

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Suggest improvements or optimizations
- Report bugs or issues
- Add new exercises
- Enhance documentation

Please fork the repository and submit a pull request with your changes.

---

## 📜 License

This project is open source and available for educational purposes.

---

## 🙋 Support & Questions

If you have questions or encounter issues:
1. Check the code comments for inline documentation
2. Review the exercise descriptions above
3. Open an issue on GitHub

---

## ✨ Happy Learning!

These exercises are designed to be your stepping stones to Java mastery. Start small, understand each concept, and progressively build your skills. Good luck! 🎉