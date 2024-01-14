/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teguh4;

/**
 *
 * @author ansha
 */
class PrintNameThread implements Runnable { 
    Thread thread; 
    PrintNameThread(String name) { 
        thread = new Thread(this, name); 
        thread.start(); 
    } 
    public void run() { 
        String name = thread.getName(); 
        for (int i = 0; i < 100; i++) { 
            System.out.print(name); 
           } 
        } 
    } 
    class TestThread {
    public static void main(String args[]) { 
        System.out.println("Mulai");
        PrintNameThread pnt1 = new PrintNameThread("A"); 
        PrintNameThread pnt2 = new PrintNameThread("B"); 
        PrintNameThread pnt3 = new PrintNameThread("C"); 
        PrintNameThread pnt4 = new PrintNameThread("D"); 
        System.out.println("Selasai");
        try { 
            pnt1.thread.join(); 
            pnt2.thread.join(); 
            pnt3.thread.join(); 
            pnt4.thread.join(); 
        } catch (InterruptedException ie) { 
        } 
         System.out.println("Threads killed."); //dicetak terakhir 
    } 
} 
