import java.util.*;

public class CodingInterviewSolutions {
    
    // ==================== ARRAY QUESTIONS ====================
    
    // 1. Find Missing Number (1-100)
    public static int findMissingNumber(int[] arr, int n) {
        // Method 1: Using sum formula
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    
    // Alternative: Using XOR
    public static int findMissingNumberXOR(int[] arr, int n) {
        int xorAll = 0;
        int xorArr = 0;
        
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }
        for (int num : arr) {
            xorArr ^= num;
        }
        return xorAll ^ xorArr;
    }
    
    // 2. Find Duplicate Number
    public static int findDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // No duplicate found
    }
    
    // Floyd's Cycle Detection (for array containing 1 to n)
    public static int findDuplicateFloyd(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        
        // Find intersection point
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        
        // Find entrance to cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
    
    // 3. Find Largest and Smallest
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }
    
    // 4. Find Pairs with Given Sum
    public static List<int[]> findPairsWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();
        
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                pairs.add(new int[]{complement, num});
            }
            seen.add(num);
        }
        return pairs;
    }
    
    // 5. Find All Duplicates
    public static List<Integer> findAllDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        return new ArrayList<>(duplicates);
    }
    
    // 6. Remove Duplicates (returns new array)
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    // 7. QuickSort In-Place
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // 8. Remove Duplicates In-Place (for sorted array)
    public static int removeDuplicatesInPlace(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int writeIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }
        return writeIndex; // new length
    }
    
    // 9. Reverse Array In-Place
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    // ==================== LINKED LIST QUESTIONS ====================
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
        }
    }
    
    // 1. Find Middle Element
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // 2. Detect Cycle
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    // Find Cycle Start
    public static ListNode findCycleStart(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return null; // No cycle
        }
        
        // Find start of cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    // 3. Reverse Linked List (Iterative)
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    
    // 4. Reverse Linked List (Recursive)
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    // 5. Remove Duplicates from Unsorted List
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        
        Set<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null) {
            if (seen.contains(current.val)) {
                prev.next = current.next;
            } else {
                seen.add(current.val);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
    
    // 6. Find Length
    public static int getLength(ListNode head) {
        int count = 0;
        ListNode current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // 7. Find Nth Node from End
    public static ListNode findNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        
        // Move both until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    // ==================== STRING QUESTIONS ====================
    
    // 1. Print Duplicate Characters
    public static List<Character> printDuplicates(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        List<Character> duplicates = new ArrayList<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }
    
    // 2. Check if Anagrams
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    // Alternative using HashMap
    public static boolean areAnagramsHashMap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s2.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    
    // 3. First Non-Repeated Character
    public static Character firstNonRepeated(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    // 4. Reverse String Using Recursion
    public static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    // 5. Check if String Contains Only Digits
    public static boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    // 7. Count Vowels and Consonants
    public static int[] countVowelsConsonants(String str) {
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        int consonantCount = 0;
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        return new int[]{vowelCount, consonantCount};
    }
    
    // 8. Count Occurrence of Character
    public static int countOccurrence(String str, char target) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }
    
    // 9. String Permutations
    public static List<String> permutations(String str) {
        List<String> result = new ArrayList<>();
        permutationsHelper(str, "", result);
        return result;
    }
    
    private static void permutationsHelper(String str, String prefix, List<String> result) {
        if (str.length() == 0) {
            result.add(prefix);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permutationsHelper(remaining, prefix + c, result);
        }
    }
    
    // 10. Reverse Words in Sentence
    public static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    
    // 11. Check if Strings are Rotation
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenated = s2 + s2;
        return concatenated.contains(s1);
    }
    
    // 12. Check Palindrome
    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // ==================== BINARY TREE QUESTIONS ====================
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // 2. Preorder Traversal (Recursive)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }
    
    // 3. Preorder Traversal (Iterative)
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
    
    // 4. Inorder Traversal (Recursive)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
    
    // 5. Inorder Traversal (Iterative)
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
    
    // 6. Postorder Traversal (Recursive)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    private static void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }
    
    // 7. Postorder Traversal (Iterative)
    public static List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return result;
    }
    
    // 9. Count Leaf Nodes
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    // 10. Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
    
    // ==================== MISCELLANEOUS QUESTIONS ====================
    
    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }
    
    // 3. Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    // 4. Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    
    // 8. Swap Without Third Variable
    public static void swapWithoutTemp(int[] arr, int i, int j) {
        // Method 1: Using arithmetic
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
        
        // Method 2: Using XOR
        // arr[i] = arr[i] ^ arr[j];
        // arr[j] = arr[i] ^ arr[j];
        // arr[i] = arr[i] ^ arr[j];
    }
    
    // 9. Check Rectangle Overlap
    public static boolean rectanglesOverlap(int[] r1, int[] r2) {
        // r1 and r2: [x1, y1, x2, y2]
        // (x1, y1) is bottom-left, (x2, y2) is top-right
        
        // Check if one rectangle is to the left, right, above, or below the other
        return !(r1[2] <= r2[0] ||  // r1 is left of r2
                 r1[0] >= r2[2] ||  // r1 is right of r2
                 r1[3] <= r2[1] ||  // r1 is below r2
                 r1[1] >= r2[3]);   // r1 is above r2
    }
    
    // ==================== MAIN METHOD FOR TESTING ====================
    
    public static void main(String[] args) {
        // Test Array Functions
        System.out.println("=== ARRAY TESTS ===");
        int[] arr1 = {1, 2, 3, 5, 6, 7, 8};
        System.out.println("Missing number: " + findMissingNumber(arr1, 8));
        
        int[] arr2 = {1, 2, 3, 4, 2, 5, 6};
        System.out.println("Duplicate: " + findDuplicate(arr2));
        
        int[] arr3 = {5, 2, 9, 1, 7, 6};
        int[] minMax = findMinMax(arr3);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);
        
        // Test String Functions
        System.out.println("\n=== STRING TESTS ===");
        System.out.println("Are 'listen' and 'silent' anagrams? " + 
                         areAnagrams("listen", "silent"));
        
        System.out.println("First non-repeated in 'stress': " + 
                         firstNonRepeated("stress"));
        
        System.out.println("Is 'racecar' a palindrome? " + 
                         isPalindrome("racecar"));
        
        // Test Linked List Functions
        System.out.println("\n=== LINKED LIST TESTS ===");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode middle = findMiddle(head);
        System.out.println("Middle element: " + (middle != null ? middle.val : "null"));
        
        System.out.println("List length: " + getLength(head));
        
        // Test Binary Search
        System.out.println("\n=== BINARY SEARCH TEST ===");
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Index of 7: " + binarySearch(sortedArr, 7));
        
        // Test Sorting
        System.out.println("\n=== SORTING TESTS ===");
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(unsorted);
        System.out.println("Bubble sorted: " + Arrays.toString(unsorted));
        
        int[] unsorted2 = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(unsorted2);
        System.out.println("Merge sorted: " + Arrays.toString(unsorted2));
    }
}