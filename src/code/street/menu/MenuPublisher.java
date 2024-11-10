package code.street.menu;

import code.street.model.House;

import java.util.Scanner;

public class MenuPublisher {
    public int showMainMenu(String streetName) {
        int answer;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n---------------------[Street " + streetName + " Menu]---------------------");
            System.out.println("1. Print street information");
            System.out.println("2. Find shops with your department near the random house");
            System.out.println("3. Remove house by address");
            System.out.println("0. Close the menu");
            System.out.println("-------------------[Street " + streetName + " Menu end]-------------------");
            System.out.print("Enter your choice: ");
            answer = input.nextInt();
            if(answer < 0 || answer > 3){
                System.out.println("Invalid input. Try again.");
            }
        } while (answer < 0 || answer > 3);
        return answer;
    }

    public void showSearchingResult(House[] result){
        System.out.println("\n\n------------------[Searching result]------------------");
        if(result.length == 0){
            System.out.println("Nothing was found.");
        }
        else{
            for (House house : result) {
                house.print();
            }
        }
        System.out.println("----------------[Searching result end]----------------");
    }
}
