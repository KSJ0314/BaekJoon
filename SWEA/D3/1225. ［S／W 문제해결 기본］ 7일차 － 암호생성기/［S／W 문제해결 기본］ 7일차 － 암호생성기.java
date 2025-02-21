import java.io.*;
import java.util.*;
 
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int minIdx;
    static int[] arr;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
        	init(br);
        	divideInit();
        	
        	int cnt = 0;
        	for (int i = 0, oper = 0; ; i++, oper++) {
        		oper %= 5;
        		i %= 8;
        		
        		cnt++;
        		arr[i] -= (oper+1);
        		
        		if (arr[i] <= 0) {
        			arr[i] = 0;
        			break;
        		}
			}

        	sbAppend(cnt);
        }
        System.out.println(sb.toString());
    }
    
    // arr의 각 index가 15로 빼지면 사이클의 시작이 다시 index 0부터 시작한다.
    // arr중 가장 작은 수에서 15를 나눈 몫만큼 모든 수를 빼고 시작하면 불필요한 반복문이 사라진다.
    public static void divideInit() {
    	int oper = (arr[minIdx] / 15) -1;
    	
    	if (oper > 0) {
    		for (int i = 0; i < 8; i++) {
    			arr[i] %= oper;
    		}
    	}
    }
    
    // 결과 값 sb에 저장
    public static void sbAppend(int cnt) {
    	cnt %= 8;
    	for (int i = cnt; i < 8; i++) {
    		sb.append(arr[i]+" ");
		}
    	for (int i = 0; i < cnt; i++) {
    		sb.append(arr[i]+" ");
		}
    	
    	sb.append("\n");
    }
    
    // 입력, 초기화
	public static void init(BufferedReader br) throws IOException {
		sb.append("#"+ br.readLine() + " ");
		arr = new int[8];
    	int i = 0;
    	int min = Integer.MAX_VALUE;
    	for (String str : br.readLine().split(" ")) {
    		int n = Integer.parseInt(str);
    		if (min > n) {
    			minIdx = i;
    		}
    		
    		arr[i++] = n;
    	}
    }
}