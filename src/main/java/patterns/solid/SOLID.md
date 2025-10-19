
# 🧱 SOLID — Шпаргалка с примерами (Java)

> SOLID — это 5 принципов чистого объектно-ориентированного проектирования, предложенные Робертом Мартином (Uncle Bob).  
> Помогают писать поддерживаемый, расширяемый и тестируемый код.

---

## 🟩 S — Single Responsibility Principle (Принцип единственной ответственности)
**Класс должен иметь только одну причину для изменения.**  
Каждый класс отвечает только за одну задачу.

### ❌ Плохо:
```java
class User {
    void saveToDb() { ... }
    void sendEmail() { ... }
}
```

### ✅ Хорошо:
```java
class UserRepository {
    void save(User user) { ... }
}

class EmailService {
    void sendEmail(User user) { ... }
}
```

---

## 🟨 O — Open/Closed Principle (Принцип открытости/закрытости)
**Код открыт для расширения, но закрыт для изменения.**  
Добавляем новое поведение — не меняем старое.

### ❌ Плохо:
```java
class AreaCalculator {
    double calc(Object shape) {
        if (shape instanceof Circle) return ((Circle) shape).r * ((Circle) shape).r * Math.PI;
        if (shape instanceof Square) return ((Square) shape).a * ((Square) shape).a;
        return 0;
    }
}
```

### ✅ Хорошо:
```java
interface Shape {
    double area();
}

class Circle implements Shape {
    double r;
    public double area() { return Math.PI * r * r; }
}

class Square implements Shape {
    double a;
    public double area() { return a * a; }
}

class AreaCalculator {
    double calc(Shape shape) {
        return shape.area();
    }
}
```

---

## 🟦 L — Liskov Substitution Principle (Принцип подстановки Барбары Лисков)
**Подкласс должен быть взаимозаменяем с родительским классом.**  
Нельзя ломать контракт базового класса.

### ❌ Плохо:
```java
class Bird {
    void fly() { ... }
}

class Ostrich extends Bird {
    void fly() { throw new UnsupportedOperationException(); }
}
```

### ✅ Хорошо:
```java
interface Bird { }

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() { ... }
}

class Ostrich implements Bird { }
```

---

## 🟧 I — Interface Segregation Principle (Принцип разделения интерфейсов)
**Лучше много маленьких интерфейсов, чем один большой.**  
Клиенты не должны зависеть от методов, которые они не используют.

### ❌ Плохо:
```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() { ... }
    public void eat() { throw new UnsupportedOperationException(); }
}
```

### ✅ Хорошо:
```java
interface Workable { void work(); }
interface Eatable { void eat(); }

class Human implements Workable, Eatable {
    public void work() { ... }
    public void eat() { ... }
}

class Robot implements Workable {
    public void work() { ... }
}
```

---

## 🟥 D — Dependency Inversion Principle (Принцип инверсии зависимостей)
**Модули верхнего уровня не должны зависеть от модулей нижнего уровня.**  
Оба должны зависеть от абстракций.

### ❌ Плохо:
```java
class MySQLRepository {
    void save(String data) { ... }
}

class UserService {
    private MySQLRepository repo = new MySQLRepository();
    void saveUser(String data) { repo.save(data); }
}
```

### ✅ Хорошо:
```java
interface Repository {
    void save(String data);
}

class MySQLRepository implements Repository {
    public void save(String data) { ... }
}

class UserService {
    private final Repository repo;
    UserService(Repository repo) { this.repo = repo; }
    void saveUser(String data) { repo.save(data); }
}
```

---

## 💡 Итоговая таблица

| Принцип | Название | Суть | Решает проблему |
|----------|-----------|------|----------------|
| **S** | Single Responsibility | Один класс — одна ответственность | Снижение связанности |
| **O** | Open/Closed | Расширяй, не изменяй | Лёгкость добавления фич |
| **L** | Liskov Substitution | Подкласс не ломает контракт родителя | Надёжное наследование |
| **I** | Interface Segregation | Малые интерфейсы | Меньше ненужных зависимостей |
| **D** | Dependency Inversion | Абстракции важнее реализаций | Гибкость и тестируемость |

---

> 🔥 Совет для собеса:  
> Интервьюер часто просит объяснить на примере кода **2–3 принципа SOLID**, чаще всего SRP, OCP и DIP.  
> Готовь короткие объяснения с примером и антипримером.
