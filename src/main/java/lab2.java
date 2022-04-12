import java.util.*;

public class lab2 {
    static List<String> comb = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            print();
            int control = scanner.nextInt();
            if(control==1){
                task1();
            }else if(control==2){
                task2();
            }else if(control == 3){
                break;
            }
        }
    }
    public static void task1(){
        int n = 5, count = 0;
        String E = "01";
        List<String> posl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            comb.clear();
            combinationsWithReplacements(E, n, "");
            for (String j : comb) {
                List<String> permutations = permutations(j);
                for (String e : permutations) {
                    posl.add(e);
                }
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < posl.size(); i++) {
            set.add(posl.get(i));
        }
        posl = Arrays.asList(set.toArray(new String[0]));
        Collections.sort(posl);
        List<String> posl_c = new ArrayList<>();
        for (String i : posl) {
            if (!"101".equals(i)) {
                posl_c.add(i);
            }
        }
        System.out.println(posl_c);
    }
    public static void task2(){
        int n = 5, count = 0;
        String E = "01";
        List<String> posl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            comb.clear();
            combinationsWithReplacements(E, n, "");
            for (String j : comb) {
                List<String> permutations = permutations(j);
                for (String e : permutations) {
                    posl.add(e);
                }
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < posl.size(); i++) {
            set.add(posl.get(i));
        }
        posl = Arrays.asList(set.toArray(new String[0]));
        Collections.sort(posl);
        StringBuilder sb = new StringBuilder();
        List<String> posl_c = new ArrayList<>();
        for (String i:posl) {
            char [] arr = new char[5];
            for (int j = 0; j < arr.length; j++)arr[j] = i.charAt(j);
            for (char j:arr){
                sb.append(j);
                if (j=='1'){
                    sb.append(',');
                }
            }
            posl_c.add(sb.toString());
            sb = new StringBuilder();
        }
        System.out.println(posl_c);
    }
    public static void combinationsWithReplacements(String arr, int k, String str) {
        if (str.length() == k) {
            comb.add(str);
            return;
        }
        for (int i = 0; i < arr.length(); i++) {
            combinationsWithReplacements(arr, k, str + arr.charAt(i));
        }
    }
    public static List<String> permutations(String str) {
        StringBuilder sb;
        List<String> permutations = new ArrayList<>();
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        int k = arr.length - 1, n = 1;
        for (; ; ) {
            sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            permutations.add(sb.toString());
            int i = k - 1;
            for (; i >= 0; i--) {
                if (arr[i] < n - 1) {
                    break;
                }
            }
            if (i < 0) {
                break;
            }
            arr[i] += 1;
            i = i + 1;
            for (; i < k; ) {
                arr[i] = 0;
                i += 1;
            }
        }
        return permutations;
    }
    public static void print(){
        System.out.println("1. Задание 1");
        System.out.println("2. Задание 2");
        System.out.println("3. Выход");
    }
}