class Main {
    public static void main(String[] args) {
        for(int i=1;i<=1000;i++){
            int sum = 0, x = i;
            while(x != 0){
                sum += Math.pow(x%10, 3);
                x/=10;
            }
            if(sum == i) System.out.println(i);
        }
    }
}
