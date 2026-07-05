# Chương 01: Java cơ bản

## 1.1 Biến & Kiểu dữ liệu

```java
int level = 10;              // số nguyên
double health = 20.0;        // số thực
boolean isAlive = true;      // đúng/sai
char rank = 'A';             // ký tự
String playerName = "Steve"; // chuỗi
```

Java là ngôn ngữ **kiểu tĩnh** (static typing) — khai báo biến phải có kiểu rõ ràng.

## 1.2 Toán tử & Điều kiện

```java
int gold = 50;
if (gold >= 100) {
    System.out.println("Đủ tiền mua kiếm diamond");
} else if (gold >= 50) {
    System.out.println("Đủ tiền mua kiếm iron");
} else {
    System.out.println("Chưa đủ tiền");
}
```

Switch hiện đại (Java 14+):

```java
String item = switch (rank) {
    case 'S' -> "Netherite Sword";
    case 'A' -> "Diamond Sword";
    default -> "Wooden Sword";
};
```

## 1.3 Vòng lặp

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Spawn quái vật đợt " + i);
}

int hp = 5;
while (hp > 0) {
    hp--;
    System.out.println("HP còn: " + hp);
}
```

## 1.4 Mảng & Chuỗi

```java
String[] inventory = {"Sword", "Shield", "Potion"};
for (String item : inventory) {
    System.out.println("Vật phẩm: " + item);
}

String msg = "Hello Minecraft";
System.out.println(msg.toUpperCase());   // HELLO MINECRAFT
System.out.println(msg.length());         // 15
System.out.println(msg.contains("Mine")); // true
```

## 1.5 Lập trình hướng đối tượng (OOP) — phần quan trọng nhất

Toàn bộ Forge/Fabric/Spigot API đều được thiết kế theo OOP: bạn sẽ **kế thừa (extends)** hoặc **triển khai (implements)** các class/interface có sẵn của họ. Hiểu chắc phần này = đọc hiểu code mod của người khác.

### Class & Object

```java
public class Player {
    private String name;
    private int hp;

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void takeDamage(int amount) {
        this.hp -= amount;
        System.out.println(name + " mất " + amount + " máu, còn " + hp);
    }
}
```

Sử dụng:

```java
Player steve = new Player("Steve", 20);
steve.takeDamage(5);
```

### Kế thừa (Inheritance)

```java
public class Zombie extends Player {
    public Zombie() {
        super("Zombie", 20);
    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage(amount);
        System.out.println("Zombie gầm gừ!");
    }
}
```

### Interface — cực kỳ quan trọng cho modding

```java
public interface Damageable {
    void takeDamage(int amount);
    boolean isDead();
}
```

Khi Forge/Fabric bắt bạn "implements Listener" hay "implements ItemLike", đó chính là kỹ thuật này.

### Abstract class

```java
public abstract class Entity {
    abstract void tick(); // bắt buộc lớp con phải cài đặt

    void printInfo() {
        System.out.println("Đây là 1 Entity trong thế giới game");
    }
}
```

## 1.6 Bài tập

1. Viết class `Item` có tên, độ bền (durability), phương thức `use()` giảm độ bền đi 1.
2. Viết class `Sword` và `Pickaxe` kế thừa từ `Item`, mỗi loại override `use()` in ra hành động khác nhau.
3. Chạy thử với vòng lặp `for` gọi `use()` 10 lần và in độ bền còn lại.

Code mẫu tham khảo: [`vi-du/OOPDemo.java`](./vi-du/OOPDemo.java)

➡️ Tiếp theo: [Chương 02 - Java nâng cao](../02-nang-cao)
