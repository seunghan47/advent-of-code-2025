import java.io.BufferedReader;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) {
        String fp = "src/input2";
        int start = 50;
        int ans = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fp))){
            String line;
            while ((line = br.readLine()) != null) {
                char direction = line.charAt(0);
                int amount = Integer.parseInt(line.substring(1));
                if (direction == 'R') {
                    ans += (start + amount) / 100;
                    start = (start + amount) % 100;
                } else {
                    if (amount > start) {
                        if (start == 0) ans --;
                        start -= amount;
                        ans += (int) Math.ceil((double) start / -100);
                        start = start % 100;
                        if (start < 0) start += 100;
                        if (start == 0) ans++;
                    } else if (amount == start) {
                        ans++;
                        start = 0;
                    } else {
                        start -= amount;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("hello + "  + e.getMessage());
        }
        System.out.println(ans);
    }
}
