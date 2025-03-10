import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set set = new HashSet<>();
        
        br.readLine();
        for (String str : br.readLine().split(" ")){
            set.add(Integer.parseInt(str));
        }

        br.readLine();
        for (String str : br.readLine().split(" ")){
            int result = set.contains(Integer.parseInt(str)) ? 1 : 0;
            sb.append(result).append("\n");
        }
    
        System.out.println(sb);
    }
    
}