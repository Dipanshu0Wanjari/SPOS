import java.util.Scanner;

public class BestFit {
    public static void bestFit(int blockSize[], int m, int processSize[], int n) {
        int allocation[] = new int[n];
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i])
                 {
                    if (bestIdx == -1) 
                    {
                        bestIdx = j;
                    } 
                    else if (blockSize[j] < blockSize[bestIdx])
                    {
                        bestIdx = j;
                    }
                }
            }

            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                blockSize[bestIdx] -= processSize[i];
            }
        }

        System.out.println("Process No.\tProcess Size\tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.print(allocation[i] + 1);
            } else {
                System.out.print("Not Allocated");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter no. of blocks:- ");
        n = sc.nextInt();
        System.out.println("Enter no. of processes:- ");
        m = sc.nextInt();
        int block[] = new int[n];
        int processes[] = new int[m];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the size of " + (i + 1) + " block:- ");
            block[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the size of " + (i + 1) + " process:- ");
            processes[i] = sc.nextInt();
        }
 
        bestFit(block, n, processes, m);
        sc.close();
    }
}