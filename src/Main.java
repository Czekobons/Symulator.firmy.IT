import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean working = true;
        int day = 1;
        int month = 1;
        int year = 2020;
        int dayCount = 1;


        System.out.println("Witaj w symulatorze firmy IT!");
        while(working) {
            System.out.println(day+"."+month+"."+year+". Dzien: "+dayCount);
            ProjectGenerator[] project = new ProjectGenerator[100];
            for(int i=0;i<100;i++) {
                project[i] = new ProjectGenerator();
                System.out.print(project[i].getProjectLevel()+": ");
                for(String x: project[i].choosedBranch) {
                    if(x!=null) {
                        System.out.print(x+" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            menu.showMenuList();
            dayCount++;
        }
    }



}