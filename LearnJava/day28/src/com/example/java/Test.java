package com.example.java;

/**
 * @author Yi-27
 * @create 2020-09-24 14:48
 */
public class Test {

    public String print(){

        String a = "aaaa";
        try {
            if(5 > 2){
                a = "bbbb";
            }else{
                return "cccc";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("哈哈哈哈哈");
        }
        return a;

    }

    public String print2(){
        while(true){

            String a = "aaaa";
            try {
                if(5 < 2){
                    a = "bbbb";
                }else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("哈哈哈哈哈");
            }
        }
        return "CCCC";
    }


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.print());
        System.out.println(test.print2());
    }


}

