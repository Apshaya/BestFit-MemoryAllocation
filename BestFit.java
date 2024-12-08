public class BestFit {

    static void bestFit(int[] blockSize, int[] processSize) {
        // Number of processes
        int n = processSize.length;

        // Number of memory blocks
        int m = blockSize.length;

        // Array to store the allocation of each process.
        int[] allocation = new int[n];
        for (int i = 0; i < n; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int bestIdx = -1; 

            // Check all blocks to find the best-fit block for the current process
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1 || blockSize[j] < blockSize[bestIdx]) {
                        bestIdx = j; 
                    }
                }
            }

            // If a suitable block is found, allocate it to the current process
            if (bestIdx != -1) {
                allocation[i] = bestIdx; 
                blockSize[bestIdx] -= processSize[i]; // Reduce the size of the allocated block
            }
        }

        // Print the allocation results
        System.out.println("\nProcess No.\tProcess Size\tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + processSize[i] + "\t\t" +
                    (allocation[i] != -1 ? (allocation[i] + 1) : "Not Allocated"));
        }
    }

    // Main method to test the Best-Fit algorithm
    public static void main(String[] args) {
        int[] blockSize = {100, 500, 200, 300, 600};

        int[] processSize = {212, 417, 112, 426};

        bestFit(blockSize, processSize);
    }
}
