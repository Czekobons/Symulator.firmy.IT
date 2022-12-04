import java.util.Scanner;

public class Menu {
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

        Short choosedAction = scan.nextShort();
        chooseAction(choosedAction);
    }
    public void chooseAction(Short action)  {
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
                System.out.flush();
                showMenuCompanyManagement();
                break;
            case 9:
                System.exit(0);
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
        Short choosedAction = scan.nextShort();
    }

}
