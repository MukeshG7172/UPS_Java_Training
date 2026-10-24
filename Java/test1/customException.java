class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(){
        super("Insufficient Balance");
    }
}

class Bank{
    private double balance;

    Bank(double open){
        balance = open;
    }

    public void withdraw(double amount){
        try{
            if (balance < amount) throw new InsufficientBalanceException();
            else balance -= amount;
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

class bankSystem {
    public static void main(String[] args) {
        Bank obj = new Bank(100000);
        obj.withdraw(20000000);
    }
}
