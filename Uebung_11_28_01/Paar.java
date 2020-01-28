public class Paar<T> {
    private T wert1, wert2;

    public Paar(T w1, T w2){
    	wert1 = w1;
    	wert2 = w2;
    }

    public T getWert1(){
    	return wert1;
    }

    public T getWert2(){
    	return wert2;
    }


    public String toString(){
    	return "(" + wert1.toString() + ", " + wert2.toString() + ")";
    }


    public boolean equals(Object o) {
        if(o instanceof Paar<?>) {
            Paar<?> p = (Paar<?>) o;
            if (this.toString().equals(p.toString())){
            	return true;
            }
            else{
            	return false;
            }
        }
        return false;
    }
}