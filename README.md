# 🗒️ Task 4: Java File I/O – Notes App

## 📘 Objective
Develop a **Notes Management Console Application** using **Java File I/O** concepts.  
This application allows users to **add, view, and clear notes** saved in a text file — demonstrating practical use of `FileWriter`, `FileReader`, and `BufferedReader`.

---

## 🛠️ Tools & Technologies

| Tool                       | Purpose |
|----------------------------|----------|
| **Java 14+**               | Programming language |
| **Apache Maven**           | Project management and build automation |
| **IntelliJ IDEA**          | IDE for development |
| **Terminal / CMD**         | To compile and run the application |

---

## 🚀 Features

✅ Add new notes (appends to file)  
✅ View all saved notes  
✅ Clear all notes (empties the file)  
✅ Input validation (prevents blank notes and invalid menu choices)  
✅ Graceful error handling for missing files and invalid inputs

---

## ⚙️ How It Works

### 1. **Add a New Note**
- User inputs a note.
- The note is appended to `notes.txt` using `FileWriter` in append mode.

### 2. **View All Notes**
- Uses `BufferedReader` and `FileReader` to read each line from the file.
- Displays notes line-by-line in a formatted output.
- Shows `(No notes found)` if the file is empty or missing.

### 3. **Clear Notes**
- Opens `notes.txt` using `FileWriter` (overwrite mode) to erase all content.

### 4. **Exit**
- Cleanly closes resources and terminates the program.

---

## 🧠 Key Concepts Demonstrated

- Java File I/O (`FileWriter`, `FileReader`, `BufferedReader`)
- Try-with-resources for automatic file closure
- Exception handling (`IOException`, `FileNotFoundException`)
- Input validation using loops and exception control
- Simple text-based user interface (console menu)

---

## 🖥️ Sample Output
```shell
----------------------- Personal Notes App --------------------------

Menu:
1. Add a new note
2. View all notes
3. Clear all notes
4. Exit
Enter your choice: 2
(No notes found — file not created yet)

Press Enter to continue...


Menu:
1. Add a new note
2. View all notes
3. Clear all notes
4. Exit
Enter your choice: 1
Enter your note (press Enter when done):
> Hello
Success: Note added successfully!

Press Enter to continue...


Menu:
1. Add a new note
2. View all notes
3. Clear all notes
4. Exit
Enter your choice: 3
🗑️ All notes cleared successfully!

Press Enter to continue...

Menu:
1. Add a new note
2. View all notes
3. Clear all notes
4. Exit
Enter your choice: 4

Shutting down! Thank you for using this app!

```

---

## 🏁 How to Run the Project

### ▶️ **Step 1: Clone or Open Project**
Open the Maven Quickstart project folder in **VS Code** or **IntelliJ IDEA**.

### ▶️ **Step 2: Compile the Project**
Run the following command in the project root:
```bash
mvn compile
```

### ▶️ Step 3: Run the Application
Execute:
```bash
mvn exec:java -Dexec.mainClass="com.srms.app.NotesApp"
```
(Ensure you have the Maven Exec Plugin configured — it’s included by default in maven-archetype-quickstart projects.)

---
### 💡 Future Enhancements
- 🔍 Add Search Note by keyword
- 🗑️ Delete specific note instead of clearing all
- 🕓 Include timestamps for each note
- 💾 Export notes to CSV or JSON

---
### 👨‍💻 Author
Prashant Saini
