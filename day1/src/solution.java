import java.io.BufferedReader;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) {
        String fp = "src/input2.txt";
        int start = 50;
        int ans = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fp))){
            String line;
            while ((line = br.readLine()) != null) {
                char direction = line.charAt(0);
                int amount = Integer.parseInt(line.substring(1)) % 100;
                if (direction == 'R') {
                    start += amount;
                    start = start % 100;
                } else {
                    start -= amount;
                    start = start % 100;
                    if (start < 0) start += 100;
                }
                if (start == 0) ans++;
            }
        } catch (Exception e) {
            System.out.println("hello + "  + e.getMessage());
        }
        System.out.println(ans);
    }
}
