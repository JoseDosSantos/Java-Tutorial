public class Medium {
    private String titel;

    public Medium(String titel) {
        this.titel = titel;
    }
    public String toString() {
        return titel;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(titel.equals(m.titel))
                return true;
        }
        return false;
    }
}