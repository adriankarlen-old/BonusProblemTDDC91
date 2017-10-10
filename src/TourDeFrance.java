import java.util.ArrayList;

public class TourDeFrance {
    private static ArrayList<Integer> frontArray = new ArrayList<>();
    private static ArrayList<Integer> backArray = new ArrayList<>();
    private static ArrayList<Double> driveRatios = new ArrayList<>();


    private double maxSpread(int amntFront, int amntBack) {
        double maxSpread = 0.00;
        for (int i = 0; i < amntFront; i++) {
            for (int j = 0; j < amntBack; j++) {
                double driveRatio = (double)backArray.get(j) / frontArray.get(i);
                driveRatios.add(driveRatio);
                //SORTERA IN ELEMENTET FÖFAN
            }
        }
        //LOOPA IGENOM ARRAYFANET
            //HITTA MAXTEMP
        return maxSpread;
    }

    public static void main(String[] args) {
        Kattio input = new Kattio(System.in);
        int amntFront = input.getInt();
        int amntBack = input.getInt();
        for (int i = 0; i < amntFront; i++) {
            frontArray.add(input.getInt());
        }
        for (int j = 0; j < amntBack; j++) {
            backArray.add(input.getInt());
        }
        TourDeFrance tourDeFrance = new TourDeFrance();
        double result = tourDeFrance.maxSpread(amntFront, amntBack);
        System.out.println(result);
    }
}
