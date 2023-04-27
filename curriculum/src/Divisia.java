import java.util.ArrayList;
import java.util.Collections;

public class Divisia implements Cloneable, Comparable<Divisia> {
    private ArrayList<String> names;
    private ArrayList<Double> strengths;

    public Divisia() {
        names = new ArrayList<>();
        strengths = new ArrayList<>();
    }

    public void addSoldier(String name, double strength) {
        names.add(name);
        strengths.add(strength);
    }

    public void removeSoldier(String name) {
        int index = names.indexOf(name);
        if (index >= 0) {
            names.remove(index);
            strengths.remove(index);
        }
    }

    public Divisia otborSpecnaz(double strengthThreshold) {
        Divisia specnaz = new Divisia();
        for (int i = 0; i < strengths.size(); i++) {
            if (strengths.get(i) >= strengthThreshold) {
                specnaz.addSoldier(names.get(i), strengths.get(i));
                names.remove(i);
                strengths.remove(i);
                i--;
            }
        }
        return specnaz;
    }

    @Override
    public Divisia clone() {
        try {
            Divisia cloned = (Divisia) super.clone();
            cloned.names = new ArrayList<>(names);
            cloned.strengths = new ArrayList<>(strengths);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i)).append(": ").append(strengths.get(i)).append("\n");
        }
        return sb.toString();
    }

    public double averageStrength() {
        double sum = 0;
        for (double strength : strengths) {
            sum += strength;
        }
        return sum / strengths.size();
    }

    @Override
    public int compareTo(Divisia other) {
        double thisAverage = averageStrength();
        double otherAverage = other.averageStrength();
        if (thisAverage < otherAverage) {
            return -1;
        } else if (thisAverage > otherAverage) {
            return 1;
        } else {
            return 0;
        }
    }
}
