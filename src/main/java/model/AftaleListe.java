package model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(Aftale.class)
@jakarta.xml.bind.annotation.XmlRootElement
@jakarta.xml.bind.annotation.XmlSeeAlso(Aftale.class)
public class AftaleListe {

    List<Aftale> aftaleliste = new ArrayList<>();

    public List<Aftale> getAftaler() {
        return aftaleliste;
    }

    public void addAftaler(Aftale aftale) {
        aftaleliste.add(aftale);
    }
}
