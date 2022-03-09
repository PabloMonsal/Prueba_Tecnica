package co.com.t_evolvers.utils;

public class EsperaForzada {

    public EsperaForzada() {
    }

    public static void segundos(int seg){
        try {
            Thread.sleep(seg*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
