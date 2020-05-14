package com.adarsh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<String>();
        addInOrder(placeToVisit,"Delhi");
        addInOrder( placeToVisit,"Mumbai");
        addInOrder( placeToVisit, "Bhopal");
        addInOrder(placeToVisit, "Jabalpur");
        addInOrder(placeToVisit, "Indore");
        addInOrder(placeToVisit, "Betul");
        addInOrder(placeToVisit,"Kolkata");
        addInOrder( placeToVisit, "Chennai");
        addInOrder( placeToVisit,"Banglore");
        printList(placeToVisit);
        visit(placeToVisit);

    }
        private static void printList(LinkedList<String> linkedList){
            Iterator<String> i= linkedList.iterator();
            while(i.hasNext()){
                System.out.println("Now visiting " + i.next());
            }
            System.out.println("||||||||||||||||||||||||");
        }

        private static  boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringlistIterator = linkedList.listIterator();
        while(stringlistIterator.hasNext()){
            int comparision = stringlistIterator.next().compareTo(newCity);
            if(comparision==0){
                //equal, do not add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            }
            else if(comparision >0){
                //new city should appear before this use
                //bribane => adeldihide
                stringlistIterator.previous();
                stringlistIterator.add(newCity);
                     return true;

            }
            else if(comparision<0){
                //move on next city
            }
        }
        stringlistIterator.add(newCity);
        return true;
        }
    private static  void visit(LinkedList cities){
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    boolean goingForward = true;

    ListIterator<String >  listIterator = cities.listIterator();
    if(cities.getFirst() == ""){
        System.out.println("No cities int he iternary:");
        return ;
    }
    else{
        System.out.println("Now visiting " + listIterator.next());
        printMenu();

    }
    while(!quit){
        int action= scanner.nextInt();
        scanner.nextLine();
        switch(action){
            case 0:
                System.out.println("holiday vacation over ");
                quit = true;
                break;
            case 1:
                if(!goingForward){
                    if(listIterator.hasNext()){
                        listIterator.next();

                    }
                    goingForward = true;
                }

                if(listIterator.hasNext()) {
                    System.out.println("Now visiting" + listIterator.next());
                }
                else{
                    System.out.println("reached the end of the list");
                    goingForward = false;

                }
                break;
            case 2:
                if(goingForward){
                    if(listIterator.hasPrevious()){
                        listIterator.previous();

                    }
                    goingForward = false;
                }
                if(listIterator.hasPrevious()){
                    System.out.println("Now Visiting "+listIterator.previous());
                }else{
                    System.out.println(" we are at the start of the list");
                    goingForward =true;

                }
                break;
            case 3:
                printMenu();
        }

    }

}
        private static void printMenu(){
            System.out.println("Available action : \n press");
            System.out.println(" 0 - to quit\n"+
                    "1- go to next city\n"+
                    "2- got to prevooius city\n "+
                    "3- print menu options");
    }
}

