//priority non preemptive
import java.util.*;
public class PriorityCPUScheduling {
     int burstTime[];
    int priority[];
    int arrivalTime[];
    String[] processId;
    int numberOfProcess;
    void getProcessData(Scanner input) 
    {
        System.out.print("Enter the number of Process for Scheduling: ");
         numberOfProcess = input.nextInt();
        burstTime = new int[numberOfProcess];
        priority = new int[numberOfProcess];
        arrivalTime = new int[numberOfProcess];
        processId = new String[numberOfProcess];
        String st = "P";
        for (int i = 0; i < numberOfProcess; i++) 
        {
            processId[i] = st.concat(Integer.toString(i));
            System.out.print("Enter the burst time   for Process - " + (i+1) + " : ");
            burstTime[i] = input.nextInt();
            System.out.print("Enter the arrival time for Process - " + (i+1) + " : ");
            arrivalTime[i] = input.nextInt();
            System.out.print("Enter the priority     for Process - " + (i+1) + " : ");
            priority[i] = input.nextInt();
        }
    }
    void SORT(int[] at, int[] bt, int[] prt, String[] pid) 
    {
        int temp;
        String stemp;
        for (int i = 0; i < numberOfProcess; i++) 
        {
            for (int j = 0; j < numberOfProcess - i - 1; j++) 
            {
                if (at[j] > at[j + 1]) 
                {
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    temp = prt[j];
                    prt[j] = prt[j + 1];
                    prt[j + 1] = temp;

                    stemp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = stemp;
                }
                if (at[j] == at[j + 1]) 
                {
                    if (prt[j] > prt[j + 1]) 
                    {
                        temp = at[j];
                        at[j] = at[j + 1];
                        at[j + 1] = temp;

                        temp = bt[j];
                        bt[j] = bt[j + 1];
                        bt[j + 1] = temp;

                        temp = prt[j];
                        prt[j] = prt[j + 1];
                        prt[j + 1] = temp;

                        stemp = pid[j];
                        pid[j] = pid[j + 1];
                        pid[j + 1] = stemp;
                    }
                }
            }
        }
    }
    void priorityNonPreemptiveAlgorithm() 
    {
        int CT[] = new int[numberOfProcess];
        int bt[] = burstTime.clone();
        int at[] = arrivalTime.clone();
        int prt[] = priority.clone();
        String pid[] = processId.clone();
        int WT[] = new int[numberOfProcess];
        int TAT[] = new int[numberOfProcess];
        SORT(at, bt, prt, pid);
        CT[0] = at[0] + bt[0];
        TAT[0] = CT[0] - at[0];
        WT[0] = TAT[0] - bt[0];
        for (int i = 1; i < numberOfProcess; i++) 
        {
            CT[i] = bt[i] + CT[i - 1];
            TAT[i] = CT[i] - at[i];
            WT[i] = TAT[i] - bt[i];
        }
        float sum = 0;
        for (int n : WT) 
        {
            sum += n;
        }
        float averageWaitingTime = sum / numberOfProcess;
        sum = 0;
        for (int n : TAT) 
        {
            sum += n;
        }
        float averageTurnAroundTime = sum / numberOfProcess;
        System.out.println("Priority Scheduling Algorithm : ");
        System.out.println("\nPid\tAT\tBT\tPri\tCT\tTAT\tWT");
        for (int i = 0; i < numberOfProcess; i++) {
            System.out.println(pid[i]+"\t"+at[i]+"\t" +bt[i]+"\t"+ prt[i]+"\t"+ CT[i]+"\t"+TAT[i]+"\t"+WT[i] );
        }
        System.out.println("Average WT="+averageWaitingTime);
        System.out.println("Average TAT="+averageTurnAroundTime);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        PriorityCPUScheduling obj = new PriorityCPUScheduling();
        obj.getProcessData(input);
        obj.priorityNonPreemptiveAlgorithm();
    }
}

