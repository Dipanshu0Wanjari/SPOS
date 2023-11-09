import java.util.Scanner;

public class FIFO {
                                                                                                                                                                
    public static void main(String[] args) {
        int i, j, k, f, pf=0, count=0, hits=0;
        int[] rs = new int[25];   //reference string array
        int[] m = new int[10];      //for number of frames
        int n;  //length of the reference string

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
            m[i] = -1;      //initialise the frame with -1
        }

        System.out.println("\nThe Page Replacement Process is -- \n");

        for(i = 0; i < n; i++) {
            for(k = 0; k < f; k++) {
                if(m[k] == rs[i]) {
                    hits++;
                    break;  //if page already present there is a page hit
                }
            }

            if(k == f) {
                m[count++] = rs[i];
                pf++;    //increment the page fault count
            }

            /*for(j = 0; j < f; j++) {
                System.out.print("\t" + m[j]);
            }

            if(k == f) {
                System.out.print("\tPF No. " + pf);
            }

            System.out.println();
            */

            if(count == f) {
                count = 0;
            }
        }

        System.out.println("\nThe number of Page Hits using FIFO are " + hits);
        System.out.println("The number of Page Faults using FIFO are " + pf);
        System.out.println("Hit Ratio: " + ((double)hits/n));
        System.out.println("Fault Ratio: " + ((double)pf/n));
    }
}
