/* Datenstruktur fuer das Spiel Tuerme von Hanoi,
 welche einen einzelnen Stab darstellt..
 */
public class HanoiTurm
{
      // jede Scheibe wird durch einen String dargestellt
      // je laenger ein String, desto groesser die Scheibe
      // in values werden somit die Scheiben abgelegt
      private String[] values;
      // position gibt die Position der obersten Scheibe an
      private int position;
      /* Konstruktor (keine Scheibe vorhanden, Stabgroesse ist 1)
      */
      public HanoiTurm()
      {
            position = -1; 
            values = new String[1];
      }
      /* 
        Konstruktor (keine Scheibe vorhanden)
       * @param groesse gibt die Groesse des Stabes an (und somit
        wie viele Scheiben maximal auf diesen gelegt werden koennen)
      */
      public HanoiTurm(int groesse)
      {
            position = -1; 
            values = new String[groesse];
      }
      /*
        Gibt die maximale Anzahl an Scheiben auf dem Stab zurueck.
        @return die max. Anzahl an Scheiben
      */
      public int maxSize()
      {
          return values.length;
      }
      
      public String top(){
            if (position == -1){
                  System.out.println("Zugriff auf leeren Stab");
                  return null;
            }
            else {
                  return values[position];
            }
      }

      public void pop(){
            if (position == -1){
                  System.out.println("Zugriff auf leeren Stab");
            }
            else{
                  position += -1;
            }
      }

      public void push(String scheibe){
            if (position + 1 == maxSize()){
                  System.out.println("maximale Anzahl an Scheiben erreicht");
            }
            else if (position!=-1){
                  if (values[position].length() < scheibe.length()){
                  System.out.println("kleinere Scheibe vorhanden");
                  }
                  else{
                        values[position + 1] = scheibe;
                        position += 1;
                  }    
            }
            else{
                values[position + 1] = scheibe;
                position += 1;
            }
      }

      public int size(){
            return position + 1;
      }
}