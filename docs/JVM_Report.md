# JVM Report

## 1. Class Loader
The Class Loader loads .class files into memory when they are needed.
It works in three phases:
- **Loading**: Reads the .class file and brings it into memory
- **Linking**: Verifies that the bytecode is valid and safe to execute
- **Initialization**: Runs static blocks and initializes static variables

Note: Classes are loaded lazily — only when required, not all at once at startup.

## 2. Runtime Data Areas
The JVM divides memory into four main areas:
- **Heap**: Stores all objects created with the `new` keyword
- **Stack**: Stores local variables and tracks method calls
- **Method Area**: Stores static variables, class metadata, and method bytecode
- **PC Register**: Keeps track of the current instruction being executed

## 3. Execution Engine
The Execution Engine runs the bytecode loaded by the Class Loader.

## 4. JIT Compiler vs Interpreter
- **Interpreter**: Executes bytecode line by line. Simple but slow for repeated code.
- **JIT Compiler**: Detects frequently executed code (hot spots) and compiles
  them to native machine code. This compiled code is cached and reused,
  making execution much faster.

The JVM uses both — interpreter for rarely run code, JIT for hot spots.

## 5. Write Once, Run Anywhere
When we compile a Java file using javac, it produces a .class file
containing bytecode — not machine code. This bytecode is platform-neutral.

Any machine with a JVM installed can run this bytecode. The JVM converts
it to that specific machine's native code. This is why the same Java
program runs on Windows, Mac, and Linux without any changes.