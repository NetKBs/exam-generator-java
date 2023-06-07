
import java.util.ArrayList;
import java.util.List;

abstract class SitioWeb {

    // método para renderizar página web
    abstract public void pintar();
}

class CMS extends SitioWeb {

    String[] sitios_webs;
    String[] plantillas;
    String[] items;
    String[] imagenes;

    public CMS(String[] sitios_webs, String[] plantillas, String[] imagenes, String items[]) {
        this.sitios_webs = sitios_webs;
        this.plantillas = plantillas;
        this.imagenes = imagenes;
        this.items = items;
    }

    // Retorna datos de un sitio web
    public String getSite(int indice) {
        return sitios_webs[indice];
    }

    // Retorna la cantidad de sitios web que existen
    public int getCantSite() {
        return sitios_webs.length;
    }

    public void desplegarSitio() {
    for (String sitio : sitios_webs) {
        String[] datos = sitio.split(",");
        String nombreSitio = datos[0];
        String tipoSitio = datos[4].equals("C") ? "Comercial" : "Patrocinado";
        
        String[] datosPlantilla = plantillas[Integer.parseInt(datos[1]) - 1].split("-");
        String nombrePlantilla = datosPlantilla[0];

        System.out.println(tipoSitio + " - " + nombreSitio);
        System.out.println(nombrePlantilla);
  
        int cantidadItems = Integer.parseInt(datos[3]);
        for (int i = 0; i < cantidadItems; i++) {
            String[] itemDatos = items[i].split("#");
            System.out.println(itemDatos[1]);
        }
    }
}

    public String[] getMenuItems(int idPlantilla) {
        List<String> items = new ArrayList<String>();
        for (String item : this.items) {
            String[] datosItem = item.split("#");
            if (Integer.parseInt(datosItem[2]) == idPlantilla) {
                items.add(datosItem[1]);
            }
        }
        return items.toArray(new String[0]);
    }

    public String getMenu(String[] menuItems, boolean isHorizontalMenu) {
        String menuSeparator = isHorizontalMenu ? " " : "\n";
        String menu = "";
        for (String item : menuItems) {
            menu += item + menuSeparator;
        }
        return menu;
    }

    public void listadoSitiosComerciales() {
        for (String sitio : sitios_webs) {
            String[] partes = sitio.split(",");
            if (partes[partes.length - 1].trim().equals("C")) {
                desplegarSitio();
            }
        }
    }

    public void plantillaMasUtilizada() {
        int[] conteoPlantillas = new int[plantillas.length];
        for (String sitio : sitios_webs) {
            String[] campos = sitio.split(",");
            String idPlantilla = campos[1];
            for (int i = 0; i < plantillas.length; i++) {
                String[] camposPlantilla = plantillas[i].split("-");
                if (camposPlantilla[1].equals(idPlantilla)) {
                    conteoPlantillas[i]++;
                    break;
                }
            }
        }
        int max = conteoPlantillas[0];
        int idxMax = 0;
        for (int i = 1; i < conteoPlantillas.length; i++) {
            if (conteoPlantillas[i] > max) {
                max = conteoPlantillas[i];
                idxMax = i;
            }
        }
        String[] camposMax = plantillas[idxMax].split("-");
        System.out.println("La plantilla más utilizada es " + camposMax[0] + " (id " + camposMax[1] + ")");
    }

    public void bytesRequeridosPorSitio() {
        for (String sitio : sitios_webs) {
            String[] camposSitio = sitio.split(",");
            int cantImgs = Integer.parseInt(camposSitio[2]);
            int tamSiteBytes = camposSitio[3].equals("C") ? 500 : 200;
            int imgBytes = 0;
            System.out.printf("\n%15s %2s %7s\n", camposSitio[0], "", "Cantidad(bytes)");
            for (int i = 0; i < cantImgs; i++) {
                String[] camposImg = imagenes[i].split("#");
                int tamBytes = Integer.parseInt(camposImg[2]);
                imgBytes += tamBytes;
                System.out.printf("\n%15s %5s %5s\n", camposImg[3], "", tamBytes);
            }
            int totalBytes = tamSiteBytes + imgBytes;
            System.out.printf("\n%10s %5s\n\n", "", "Total: " + totalBytes + " bytes");
        }
    }

    @Override
    public void pintar() {
    }

}

public class Version2 {

    public static void main(String[] args) {
        // nombre - id plantilla - cantidad imgs, cantidad items
        String[] sitios_webs = {
            "Sport site,1,2,2,C",
            "Blog de cocina,2,5,3,P,Fubica",
            "Gucci,2,3,4,C",
            "HolaSoyGerman,3,2,4,P,Youtube"
        };
        // nombre - id plantilla - localizacion - precio 
        String[] plantillas = {
            "Mambo-1-1-23.4",
            "Bootstrap-2-2-28.0",
            "Azura-3-2-34.2"
        };
        // imagenes id, ruta tamaño en bytes nombre del archivo, columna y fila
        String[] imagenes = {
            "1#/etc/#23#imagen1.jpg#50#100",
            "2#./.config/local/#40#imagen2.jpg#150#200",
            "3#./imagenes/#30#imagen3.png#70#70",
            "4#/home/user/#50#imagen4.jpg#100#100",
            "5#/home/cache/#30#imagen5.jpg#100#100",
            "6#/home/user/images/#24#imagen6.jpg#100#100",
            "7#/home/user/images/#14#imagen7.jpg#100#100"
        };
        // id, nombre, localización 
        String[] items = {
            "1#Item1#2",
            "2#Item2#1",
            "3#Item3#3",
            "4#Item4#2",
            "5#Item5#3",
            "6#Item6#1",
            "7#Item6#1",
            "8#Item6#2",
            
        };

        CMS cms = new CMS(sitios_webs, plantillas, imagenes, items);

        System.out.println("Listado de sitios webs comerciales");
        cms.listadoSitiosComerciales();

        System.out.println("\n\nIndicando el id y el nombre de la plantilla más utilizada en las páginas web");
        cms.plantillaMasUtilizada();

        System.out.println("\n\nCalcular y mostrar la cantidad de bytes requeridos por cada sitio web");
        cms.bytesRequeridosPorSitio();

        cms.desplegarSitio();
    }
}
