import java.util.Scanner;

public class WorstFit {
    public static int worstFit(int[] blockSize, int m, int[] processSize, int n) {
        int[] allocation = new int[n];
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int worstIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (worstIdx == -1 || blockSize[j] > blockSize[worstIdx]) {
                        worstIdx = j;
                    }
                }
            }
            if (worstIdx != -1) {
                allocation[i] = worstIdx;
                blockSize[worstIdx] -= processSize[i];
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            System.out.println("\n\n");
            System.out.print(blockSize[i] + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println("Allocated" + "\t\t");
                count++;
            } else {
                System.out.println("Not Allocated");
            }
        }

        return count;
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

        int result = worstFit(processes, m, block, n); // Swap the sizes of blockSize and processSize
        System.out.println("Number of allocated processes: " + result);
        sc.close();
    }
}