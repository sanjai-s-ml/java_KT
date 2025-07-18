public class ZeroDivision {
    public static void zeroDivisionError(int value1,int value2){
        int result;
        try{
            result=value1/value2;
            System.out.println("Result : "+result);
        }
        catch(ArithmeticException e){
            System.out.println("Exception caught : "+ e.getMessage());
        }
        finally{
            System.out.println("Operation Completed");
        }
        System.out.println("---------------------------------------------");
    }
    public static void main(String[] args) {
        ZeroDivision.zeroDivisionError(10,5);
        ZeroDivision.zeroDivisionError(5,0);
    }
}
