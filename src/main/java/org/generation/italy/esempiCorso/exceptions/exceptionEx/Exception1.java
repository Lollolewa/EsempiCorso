package org.generation.italy.esempiCorso.exceptions.exceptionEx;

import java.util.Arrays;

public class Exception1 {
    public static void main(String[] args) {

        int[] nums = new int[4];
        for(int i = 0; i <= 10; i++) {
            try {
                System.out.println(nums[i]);
                System.out.println("dentro try");

            } catch (ArrayIndexOutOfBoundsException f) {
                System.out.println(Arrays.stream(f.getStackTrace()).toList());
                System.out.println("Lunghezza superata");
                System.out.println(f);
                System.out.println(f.getCause());

            } catch (Exception e) {
                System.out.println(e);

            } finally {
                System.out.println("dentro finally");

            }
            System.out.println("fuori tutto");
        }

        int maxprice = 200;
        int userInput = 400;
        if(userInput > maxprice){

            try{
                throw new OverPriceException();

            } catch (OverPriceException e){
                System.out.println(e);
                userInput = maxprice;

            } finally {
                System.out.println(userInput - maxprice);
            }


        }
    }
}
