//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Dekleration der Variablen und auslesen der Eingabe Werte
        int d = SimpleIO.getInt("Gebe den Start Tag ein: ");
        int m = SimpleIO.getInt("Geben Sie den Start Monat ein: ");
        int j = SimpleIO.getInt("Geben Sie das Start Jahr ein: ");
        int t = SimpleIO.getInt("Geben Sie die Anzahl der Tage an: ");

        //Statische Variable für die Tage am ende zur Ausgabe
        int t_static = t;

        //Laufvariable zur Terminierung der Schleife
        boolean fertig = false;

        //Validierungs Variable der Eingabe
        boolean valideWerte = true;

        //Validierung der Eingabe Werte
        if (!(0 < d || 0 < m || 0 < j || 0 < t || d < 32 || m < 12)) {
            valideWerte = false;
            System.out.println("Keine Valide Eingabe");
        }
        //Tages Differenz der Monate
        int tage[] = {1, -2, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0};

        //Schleife führt aus falls es t>0 und fertig auf False ist
        while(t > 0 && !fertig && valideWerte) {

            //Fall: zu addierende Monate gehen nicht über den Monat hinaus
            if(t + d < 30 + tage[m - 1]){
                d = t + d;
                fertig = true;
            }else{
                //Falls Monats Sprung bzw. Jahressprung
                int bisNM = (30 + tage[m - 1]) - d;
                if(m + 1 > 12){
                    m = 1;
                    j++;
                }else{
                    m++;
                }
                //Update der Tages Variable (Laufvariable)
                d = 1;
                t = t - bisNM - 1;
            }
        }
        //Ausgabe des Datums (Falls Valide Eingaben)
        if (valideWerte) {
            SimpleIO.output("Das Datum " + d + "." + m + "." + j + " befindet sich " + t_static + " Tage " + " nach dem Start Datum");
        }

    }
}