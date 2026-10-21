import java.util.Scanner;

class firstRepeated {
    public static void main(String[] args) {
        System.out.println("Enter the String: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ' ') continue;
            boolean res = true;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    res = false;
                    break;
                }
            }
            if(res){
                System.out.println("First non-repeated character: " + s.charAt(i));
                return;
            }
        }

        System.out.println("No non-repeated character");
    }
}
