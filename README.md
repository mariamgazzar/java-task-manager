# Java Task Manager (CLI)

A simple command-line task manager built in Java. Tasks are saved locally so they persist between runs.

## Features
- Add tasks
- List tasks (`[ ]` / `[x]`)
- Mark tasks as done
- Delete tasks
- Clear completed tasks
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

