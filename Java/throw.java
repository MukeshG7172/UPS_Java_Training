class customException extends Exception {
  customException(String a) {
    super(a);
  }
}

class A {
  public static void main(String[] args) {
    try {
      int a = 10;
      if (a < 11) {
        throw new customException("Less than 11");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
