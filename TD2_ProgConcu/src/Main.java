public class Main {

    public static void main (String[] args) throws InterruptedException {

        String chaine1 = "Souvent, pour s'amuser, les hommes d'équipage";
        String chaine2 = "Prennent des goélands, vastes oiseaux des mers,";
        String chaine3 = "Qui suivent, indolents compagnons de voyage,";
        String chaine4 = "Le navire glissant sur les gouffres amers.";

        Thread t1 = new Thread(new Taches(chaine1));
        Thread t2 = new Thread(new Taches(chaine2));
        Thread t3 = new Thread(new Taches(chaine3));
        Thread t4 = new Thread(new Taches(chaine4));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.start();
        t4.join();

    }
}
