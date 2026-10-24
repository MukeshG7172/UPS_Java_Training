import java.util.Scanner;

class anagram{
    public static void main(String[] args) {
        String s1, s2;
        System.out.println("Enter the two strings: ");
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        int[] frq = new int[26];
   
        String ss1 = s1.toLowerCase();
        String ss2 = s2.toLowerCase();
        // System.out.println(ss2);

        for(int i=0;i<ss1.length();i++){
            char ch = ss1.charAt(i);
            if(ch == ' ') continue;
            int a = ch - 97;
            // System.out.println(a);
            frq[a]++;
            // System.out.println(frq[a]);
        }
        for(int i=0;i<ss2.length();i++){
            char ch = ss2.charAt(i);
            if(ch == ' ') continue;
            int a = ch - 97;
            frq[a]--;
            // System.out.println(ch + " " + frq[a]);
        }

        boolean ans = true;
        for(int i=0;i<26;i++){
            // System.out.println(i+ " " + frq[i]);
            if(frq[i] != 0){
                ans = false;
                break;
            }
        }

        if(ans) System.out.println("The strings are anagram");
        else System.out.println("The strings are not anagram");
    }
}
