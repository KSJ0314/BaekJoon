import java.util.*;
import java.io.*;

class Main {
	static class Shark{
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R, C;
	static Shark[][] sharks;
	static HashSet<Shark> sharkList;
	
    public static void main(String[] args) throws IOException {
        init();
        
        int total = 0;
        for (int i = 1; i <= C; i++) {
			//낚시왕 이동 + 낚시
        	for (int j = 1; j <= R; j++) {
				if (sharks[j][i] != null) {
					total += sharks[j][i].z;
					sharkList.remove(sharks[j][i]);
					sharks[j][i] = null;
					break;
				}
			}
        	
        	// 상어 이동 + 삭제
        	Shark[][] moveSharks = new Shark[R+1][C+1];
        	HashSet<Shark> removeSharkList = new HashSet<>();
        	for (Shark shark : sharkList) {
        		int nr = shark.r;
        		int nc = shark.c;

        		if (shark.d == 1 || shark.d == 2) {
        		    int len = R - 1;

        		    int pos;
        		    if (shark.d == 2) pos = shark.r - 1;
        		    else pos = 2 * len - (shark.r - 1);

        		    pos = (pos + shark.s) % (2 * len);

        		    if (pos <= len) {
        		        nr = pos + 1;
        		        shark.d = 2;
        		    } else {
        		        nr = 2 * len - pos + 1;
        		        shark.d = 1;
        		    }
        		} else {
        		    int len = C - 1;

        		    int pos;
        		    if (shark.d == 3) pos = shark.c - 1;
        		    else pos = 2 * len - (shark.c - 1);

        		    pos = (pos + shark.s) % (2 * len);

        		    if (pos <= len) {
        		        nc = pos + 1;
        		        shark.d = 3;
        		    } else {
        		        nc = 2 * len - pos + 1;
        		        shark.d = 4;
        		    }
        		}
        		
        		shark.r = nr;
        		shark.c = nc;
        		if (moveSharks[nr][nc] != null) {
        			if (moveSharks[nr][nc].z > shark.z) {
        		        removeSharkList.add(shark);
        		        continue;
        		    } else {
        		        removeSharkList.add(moveSharks[nr][nc]);
        		    }
        		}
        		moveSharks[nr][nc] = shark;
        	}

        	for (Shark shark : removeSharkList) {
        		sharkList.remove(shark);
        	}
        	sharks = moveSharks;
		}
        
        System.out.println(total);
    }

	public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputs;
    	
    	inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[2]);
        
        sharks = new Shark[R+1][C+1];
        sharkList = new HashSet<>();
        for (int i = 0; i < M; i++) {
        	inputs = br.readLine().split(" ");
        	int r = Integer.parseInt(inputs[0]);
        	int c = Integer.parseInt(inputs[1]);
        	int s = Integer.parseInt(inputs[2]);
        	int d = Integer.parseInt(inputs[3]);
        	int z = Integer.parseInt(inputs[4]);
        	
        	Shark shark = new Shark(r, c, s, d, z);
        	sharks[r][c] = shark;
        	sharkList.add(shark);
		}
    }
}