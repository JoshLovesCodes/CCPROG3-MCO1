import java.util.ArrayList;

public class AutomateNaming {
    
    private ArrayList<String> names;
    private boolean availability[];
    
    public AutomateNaming() {
        this.names = new ArrayList<String>();
        this.availability = new boolean[50];


        int ctr = 0;

        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 10; j++) {
                String name = String.format("%d%02d", i, j);
                this.names.add(name);
                this.availability[ctr] = true;
                ctr++;
            }
        }
    }
    
    public String getName() {
        for(int i = 0; i < this.names.size(); i++) {
            if(this.availability[i]) {
                this.availability[i] = false;
                return this.names.get(i);
            }
        }
    
        return null;
    }

    public void setAvailability(String name) {
        int index = this.names.indexOf(name);
        this.availability[index] = true;
    }
}
