package co.com.t_evolvers.utils;

public class ListProducts {

    public ListProducts() {
    }

    private static final String[] nameProductos = new String[10];
    private static final String[] priceProductos = new String[10];
    private static int count = 0;

    public static void agregarProducto(String objeto, String price){
        nameProductos[count] = objeto;
        priceProductos[count] = price;
        count++;
    }

    public static Boolean obtenerData(String name){
        for(int i=0; i<tamanoData();i++){
            if(nameProductos[i] != null){
                if(nameProductos[i].equalsIgnoreCase(name)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void limpiarData(){
        count = 0;
    }

    public static Boolean eliminarData(String name){
        for(int i=0; i<tamanoData();i++){
            if(nameProductos[i] != null){
                if(nameProductos[i].equalsIgnoreCase(name)){
                    nameProductos[i]="";
                    priceProductos[i]="0";
                    return true;
                }
            }
        }
        return false;
    }

    public static int tamanoData(){
        int con=0;
        for (String nameProducto : nameProductos) {
            if (nameProducto != null) {
                con++;
            }
        }
        return con;
    }

    public static String precioTotal(){
        int con=0, total=0;
        for(int i=0; i<priceProductos.length;i++){
            if(nameProductos[i]!=null){
                total = total + Integer.parseInt(priceProductos[con]);
                con++;
            }
        }
        return ""+total;
    }
}
