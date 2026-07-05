// Ví dụ minh họa OOP: nền tảng để đọc hiểu API Forge/Fabric/Spigot sau này
public class OOPDemo {

    static abstract class Item {
        protected String name;
        protected int durability;

        public Item(String name, int durability) {
            this.name = name;
            this.durability = durability;
        }

        // Mỗi loại item dùng khác nhau -> bắt buộc lớp con tự cài đặt
        abstract void use();

        boolean isBroken() {
            return durability <= 0;
        }
    }

    static class Sword extends Item {
        public Sword() {
            super("Kiếm sắt", 5);
        }

        @Override
        void use() {
            durability--;
            System.out.println("Chém quái vật! Độ bền còn: " + durability);
        }
    }

    static class Pickaxe extends Item {
        public Pickaxe() {
            super("Cuốc kim cương", 8);
        }

        @Override
        void use() {
            durability--;
            System.out.println("Đào khoáng sản! Độ bền còn: " + durability);
        }
    }

    public static void main(String[] args) {
        Item[] tools = { new Sword(), new Pickaxe() };

        for (Item tool : tools) {
            System.out.println("--- Dùng " + tool.name + " ---");
            while (!tool.isBroken()) {
                tool.use();
            }
            System.out.println(tool.name + " đã hỏng!\n");
        }
    }
}
