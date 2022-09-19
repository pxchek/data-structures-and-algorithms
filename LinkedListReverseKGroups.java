// Consider a single linked list and an integer k. Write a snippet of code to reverse the list's nodes into k groups.
//e.g 7->4->3->1->8->2->9->0 should become 3->4->7->2->8->1->0->9

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListReverseKGroups {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LinkedList<Integer> list = new LinkedList<>();
        final LinkedList<Integer> result = new LinkedList<>();

        try (scanner) {
            System.out.println("Enter k (groups): ");
            int k = scanner.nextInt();
            System.out.println("Enter the elements: ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    list.add(scanner.nextInt());
                } else {
                    if (scanner.next().equals("done")) {
                        break;
                    }
                }
            }
            reverse(list, result, k);
        }

        System.out.println("Result: ");
        result.forEach(System.out::println);
    }

    private static void reverse(final LinkedList<Integer> list, final LinkedList<Integer> result, final int k) {
        for (int i = 0; i < list.size(); i = i + k) {
            int leftIndex = i;
            int rightIndex = i + 2;
            for (; rightIndex >= leftIndex; rightIndex--) {
                if (rightIndex < list.size()) {
                    int integer = list.get(rightIndex);
                    result.add(integer);
                }
            }
        }
    }
}

