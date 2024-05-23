package gad.sortingHeaps;

public class HeapVisualizer {

    public static void printHeap(int[] heap, int heapSize) {
        // Calculate the number of levels in the heap
        int levels = (int) (Math.log(heapSize) / Math.log(2)) + 1;

        int currentLevel = 0;
        int itemsThisLevel = 1;

        int index = 0;

        while (index < heapSize) {
            // Calculate spacing based on levels remaining
            int indent = (int) Math.pow(2, (levels - currentLevel - 1)) - 1;

            // Print leading spaces
            printSpaces(indent);

            // Print elements at the current level
            for (int i = 0; i < itemsThisLevel && index < heapSize; i++) {
                System.out.print(heap[index++]);

                // Print space between elements in the same level
                if (i < itemsThisLevel - 1) {
                    printSpaces(indent * 2 + 1);
                }
            }

            // Move to the next level
            System.out.println();
            currentLevel++;
            itemsThisLevel *= 2;
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Result result = new StudentResult();
        NaryHeap heap = new NaryHeap(new int[]{10, 15, 20, 17, 25},2,result);
        printHeap(heap.getHeap(), heap.getHeap().length);
    }
}
