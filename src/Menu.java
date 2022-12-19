import java.util.Scanner;

public class Menu {
    ProjectGenerator[] project = new ProjectGenerator[100];
    public void showMenuList() {
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Podpisz umowe na realizacje projektu.");
        System.out.println("2. Szukaj nowych klientow.");
        System.out.println("2. Programuj.");
        System.out.println("3. Testuj kod.");
        System.out.println("4. Oddaj gotowy projekt klientowi.");
        System.out.println("5. Zatrudnij nowego pracownika.");
        System.out.println("6. Zwolnij pracownika.");
        System.out.println("7. Rozlicz się z urzędami.");
        System.out.println("8. Zarzadzaj firma.");
        System.out.println("9. Porzuc swoja firme i zatrudnij sie na etat.");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");

        Short chosedAction = scan.nextShort();
        choseAction1(chosedAction);
    }
    public void choseAction1(Short action)  {
        switch (action) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            case 8:
                System.out.println("\u001B[2J");
                showMenuCompanyManagement();
                break;
            case 9:
                System.exit(0);
                break;
            case 12:
                showProject(project[0]);
                break;
        }
    }
    public void showMenuCompanyManagement() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Sprawdz stan realizacji projektow.");
        System.out.println("2. Przejrzyj dostepne projekty.");
        System.out.println("3. Sprawdz dostepnych pracownikow.");
        System.out.println("4. Sprawdz stan konta firmy.");
        System.out.println("5. Wroc do glownego menu.");
        System.out.print("Wybierz jedno z polecen wybierajac odpowiednia cyfre:");
        Short chosedAction = scan.nextShort();
        choseAction2(chosedAction);
    }
    public void choseAction2(Short action)  {
        switch (action) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                showMenuList();
                break;
        }
    }
    public void showProject(ProjectGenerator project) {
        System.out.println(project.getProjectTitle());
        project.showOursNeeded();
        System.out.println("Czas ukończnia: "+project.getDayToDeadLine()+" dni.");
        System.out.println("Kara za przekroczenie terminu: "+project.getPenalty()+"$.");
        System.out.println("Wartosc projektu: "+project.getProjectValue()+"$.");
        if(project.getProjectLevel()==1) {
            System.out.println("Poziom projektu: latwy.");
        }
        else if(project.getProjectLevel()==2) {
            System.out.println("Poziom projektu: sredni.");
        }
        else {
            System.out.println("Poziom projektu: zlozony.");
        }

    }

}
