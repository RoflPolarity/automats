import java.util.*;

public class lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            print();
            System.out.println("Введите номер пункта меню");
            int control = scan.nextInt();
            if(control==1) {
                System.out.println("Введите алфавит.\nБез пробелов!");
                String alphabet = scan.next();
                System.out.println("Введите слово");
                String slovo = scan.next();
                System.out.println("Номер слова - "+getNumOfWord(getAlphabet(alphabet), getWord(slovo, getAlphabet(alphabet))));
            }else if(control == 2){
                System.out.println("Введите алфавит.\nБез пробелов!");
                String alphabet = scan.next();
                System.out.println("Введите номер слова");
                int num = scan.nextInt();
                getWordOfNum(getAlphabet(alphabet),num);

            }else if(control == 3){
                break;
            }
        }
    }
    public static void print(){
        System.out.println("1. Узнать номер слова");
        System.out.println("2. Узнать слово по номеру");
        System.out.println("3. Выход");
    }

    public static Set<Character> getAlphabet(String str){
        Set<Character> alphabet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            alphabet.add(str.charAt(i));
        }
        return alphabet;
    }

    public static List<Character> getWord(String str, Set<Character> aphabet){
        List<Character> slovo = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            slovo.add(str.charAt(i));
        }
        char[] slovoArr = new char[slovo.size()];
        for (int i = 0; i < slovoArr.length; i++) {
            slovoArr[i] = slovo.get(i);
        }
        for (int i = 0; i < slovoArr.length; i++) {
            if(!aphabet.contains(slovoArr[i])){
                System.out.println("Символ " + slovoArr[i] + " не содержится в алфавите и будет удален из слова");
                slovoArr[i] = '%';
            }
        }
        slovo = new ArrayList<>();
        for (int i = 0; i < slovoArr.length; i++) {
            if(!(slovoArr[i]=='%')){
                slovo.add(slovoArr[i]);
            }
        }
        System.out.println(slovo);
        return slovo;
    }

    public static int getNumOfWord(Set<Character> alphabet, List<Character> word){
        List<Character> alph = new ArrayList<>();
        Character[] arr = alphabet.toArray(new Character[0]);
        List<Integer> r = new ArrayList<>();
        int k = word.size(), count = 0, Num = 0;
        for (int i = 0; i < arr.length; i++) {
            alph.add(arr[i]);
        }
        for (char i : word) {
            r.add(alph.indexOf(i)+1);
        }
        while(k!=0){
            k -= 1;
            Num += Math.pow(alphabet.size(),k)*r.get(count);
            count++;
        }
        return Num;
    }

    public static void getWordOfNum(Set<Character> alphabet, int numOfWord){
        Object[] alph = alphabet.toArray(new Character[0]);
        int n = alph.length, N  = numOfWord;
        List<Integer> k = new ArrayList<>();
        StringBuilder k1 = new StringBuilder();
        while (N>alph.length){
            int r = 0;
            if(N%n==0){
                r = n;
                N -= r;
                k.add(r);
            }else {
                while (N % n != 0){
                    r += 1;
                    N -= 1;
                }
                k.add(r);
            }
            N /= n;
        }
        k.add(N);
        Collections.reverse(k);
        for (int i:k) {
            k1.append(alph[i-1]);
        }
        System.out.println("Закодированное слово - " + k1.toString());
    }
}