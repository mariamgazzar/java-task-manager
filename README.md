# Java Task Manager (CLI)

A simple command-line task manager built in Java. Tasks are saved locally so they persist between runs.

## Features
- Add tasks with priority (LOW/MED/HIGH) and optional due date
- List tasks sorted by status, due date, and priority
- Mark tasks as done, delete tasks, and clear completed tasks
- Save/load tasks from a local file (`tasks.txt`)


## Project structure
- `src/Main.java` — main program
- `tasks.txt` — created locally when you run the program (ignored by git)

## How to run

### Requirements
- Java (JDK 11+ recommended)

### Compile
```bash
javac src/Main.java

