import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long ans = 0;
        String fp = "src/input.txt";
        Set<String> set;
        try (BufferedReader br = new BufferedReader(new FileReader(fp))) {
            String line;
            while ((line = br.readLine()) != null) {
                String [] arr = line.split(",");
                for (String s : arr) {
                    String [] arr2 = s.split("-");
                    long start = Long.parseLong(arr2[0]);
                    long end = Long.parseLong(arr2[1]);
                    for (long i = start; i <= end; i++) {
                        String check = String.valueOf(i);
                        int n = check.length() / 2;
                        for (int j = 1; j <= n; j++) {
                            if (check.length() % j == 0) {
                                set = new HashSet<>();
                                set.add(check.substring(0, j));
                                for (int k = j; k < check.length(); k+=j) {
                                    set.add(check.substring(k, k + j));
                                }
                                if (set.size() == 1) {
                                    ans += Long.parseLong(check);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ans);
    }
}
