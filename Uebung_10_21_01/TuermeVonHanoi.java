public class TuermeVonHanoi{
      static int verschiebungen = 0;
      public static void main(String[] args) {
            int anzahl = Integer.parseInt(args[0]);

            HanoiTurm turm1 = new HanoiTurm(anzahl);
            HanoiTurm turm2 = new HanoiTurm(anzahl);
            HanoiTurm turm3 = new HanoiTurm(anzahl);


            for (int i=anzahl; i>0; i--){
                  String scheibe = "";
                  for (int j=0; j<i; j++){
                        scheibe += "/\\";
                  }
                  turm1.push(scheibe);
            }
            
            umstapeln(anzahl, turm1, turm2, turm3);
            System.out.println(verschiebungen);

            String output = "";
            for (int i=anzahl-1; i>=0; i--){
                  String scheibe = turm3.top();
                  int anzLeer = i;
                  for (int j=0; j<anzLeer;j++){
                        output+=" ";
                  }
                  output += scheibe;
                  output += "\n";
                  turm3.pop();
            }
            System.out.println(output);
      }

      public static void umstapeln(int i, HanoiTurm a, HanoiTurm b, HanoiTurm c){
            if (i > 0) {
                  umstapeln(i-1, a, c, b);
                  String scheibe = a.top();
                  a.pop();
                  c.push(scheibe);
                  verschiebungen+=1;
                  umstapeln(i-1, b, a, c);
            }
      }
}

