package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="aftaleListe")
@XmlSeeAlso(Aftale.class)
@XmlAccessorType(XmlAccessType.FIELD)
@jakarta.xml.bind.annotation.XmlRootElement
@jakarta.xml.bind.annotation.XmlSeeAlso(Aftale.class)
public class AftaleListe {

    @XmlElement(name="Aftale")
    List<Aftale> aftaleliste = new ArrayList<>();

    public List<Aftale> getAftaler() {
        return aftaleliste;
    }

    public void addAftaler(Aftale aftale) {
        aftaleliste.add(aftale);
    }
}
