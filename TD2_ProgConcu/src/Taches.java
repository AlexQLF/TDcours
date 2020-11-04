public class Taches implements Runnable{

    String chaine;

    public Taches(String chaine) {
        this.chaine = chaine;

    }

    public void run(){
        System.out.println(this.chaine);
    }

}
