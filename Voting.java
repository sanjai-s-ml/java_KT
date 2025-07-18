public class Voting {
    public static void checkMethod(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Age must atleast be 18 to vote");
        }
        else
            System.out.println("You are eligible to vote");
    }

    public static class InvalidAgeException extends Exception { // inner class for Exception
        public InvalidAgeException(String s) {
            super(s);
        }
    }

    public static void main(String[] args)  {
        try{
            Voting.checkMethod(20);
            Voting.checkMethod(12);
        }
        catch(InvalidAgeException e){
            System.out.println("Exception caught : "+ e.getMessage());
        }

    }
}
