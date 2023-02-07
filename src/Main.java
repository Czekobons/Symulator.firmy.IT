public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean working = true;
        TimeManagment time = new TimeManagment();

        Integer dayCount = 1;


        for (int i = 0; i < 3; i++) {
            menu.project[i] = new ProjectGenerator();
        }

        System.out.println("Witaj w symulatorze firmy IT!");
        while (working) {
            System.out.println(time.getGameDay() + "." + time.getGameMonth() + "." + time.getGameYear() + ". Dzien: " + dayCount);

            System.out.println();
            menu.showMenuList();
            time.nextDay();
            dayCount++;
            menu.timeForProjects();
            menu.chceckIfFinished();
            menu.delayedPayments();
            if (time.getGameDay() == 1 && dayCount != 1) {
                if (menu.dealWithBurdens < 2) {
                    System.out.println("Przykro mi ale skarbowka wjechala z kontrola, mozemy zamykac interes. Milo sie z toba pracowalo");
                    System.exit(0);
                } else {
                    menu.dealWithBurdens = 0;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


}