import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Divisia divisia = new Divisia();
        divisia.addSoldier("Josehp", 14);
        divisia.addSoldier("Heinrich", 88);
        divisia.addSoldier("Erwin", 88);
        System.out.println(divisia);

        Divisia specnaz = divisia.otborSpecnaz(85);
        System.out.println("Specnaz:");
        System.out.println(specnaz);
        System.out.println("Divisia:");
        System.out.println(divisia);

        Divisia clonedDivisia = divisia.clone();
        System.out.println("Cloned divisia:");
        System.out.println(clonedDivisia);

        System.out.println("Sorting by average strength:");
        ArrayList<Divisia> divisions = new ArrayList<>();
        divisions.add(clonedDivisia);
        divisions.add(divisia);
        divisions.add(specnaz);
        Collections.sort(divisions);
        for (Divisia division : divisions) {
            System.out.println(division);
        }
    }

}