import java.util.Scanner;

public class LRU2{
    public static void main(String[] args) {
        int i, j, k, f, pf=0, hits=0;
        int[] rs = new int[25];   // reference string array
        int[] m = new int[10];   // for number of frames
        int[] time = new int[10];   // time array to keep track of recently used pages
        int n;  // length of the reference string

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the length of reference string -- ");
        n = sc.nextInt();

        System.out.print("\nEnter the reference string -- ");
        for(i = 0; i < n; i++) {
            rs[i] = sc.nextInt();
        }

        System.out.print("\nEnter no. of frames -- ");
        f = sc.nextInt();

        for(i = 0; i < f; i++) {
            m[i] = -1;      // initialise the frame with -1
            time[i] = -1;   // initialise the time with -1
        }

        for(i = 0; i < n; i++) {
            boolean pageFound = false;

            // Check if page is already in memory
            for(k = 0; k < f; k++) {
                if(m[k] == rs[i]) {
                    hits++;
                    pageFound = true;
                    time[k] = i; // Update time of recently used page
                    break;
                }
            }

            // If page is not in memory, find the LRU page
            if(!pageFound) {
                int minTime = Integer.MAX_VALUE;
                int lruPage = -1;

                for(j = 0; j < f; j++) {
                    if(time[j] < minTime) {
                        minTime = time[j];
                        lruPage = j;
                    }
                }

                m[lruPage] = rs[i];
                time[lruPage] = i;
                pf++;    // increment the page fault count
            }
        }

        System.out.println("\nThe number of Page Hits using LRU are " + hits);
        System.out.println("The number of Page Faults using LRU are " + pf);
        System.out.println("Hit Ratio: " + ((double)hits/n));
        System.out.println("Fault Ratio: " + ((double)pf/n));
    }
}
