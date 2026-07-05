import java.util.*;
import java.util.stream.*;

public class AdvancedDemo {

    static class NotEnoughGoldException extends Exception {
        public NotEnoughGoldException(String message) {
            super(message);
        }
    }

    static class Player {
        String name;
        int score;
        int gold;

        Player(String name, int score, int gold) {
            this.name = name;
            this.score = score;
            this.gold = gold;
        }

        void buyItem(int price) throws NotEnoughGoldException {
            if (gold < price) {
                throw new NotEnoughGoldException(name + " không đủ vàng để mua món đồ giá " + price);
            }
            gold -= price;
            System.out.println(name + " đã mua thành công, còn lại " + gold + " vàng");
        }
    }

    public static void main(String[] args) {
        // --- Map làm kho đồ ---
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Sword", 1);
        inventory.merge("Arrow", 10, Integer::sum);
        inventory.merge("Arrow", 5, Integer::sum); // cộng dồn thay vì ghi đè
        System.out.println("Kho đồ: " + inventory);

        // --- Stream lọc người chơi điểm cao ---
        List<Player> players = List.of(
                new Player("Steve", 80, 100),
                new Player("Alex", 40, 50),
                new Player("Notch", 95, 200)
        );

        List<String> topPlayers = players.stream()
                .filter(p -> p.score > 50)
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("Người chơi điểm cao: " + topPlayers);

        // --- Custom Exception ---
        try {
            players.get(1).buyItem(999); // Alex không đủ vàng
        } catch (NotEnoughGoldException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
