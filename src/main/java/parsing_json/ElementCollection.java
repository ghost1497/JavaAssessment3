package parsing_json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ElementCollection extends ArrayList {
    private ArrayList<Element> elementArrayList = new ArrayList<>();

    public void add(Element e){
        elementArrayList.add(e);
    }

    public Element get(int index) {
        return elementArrayList.get(index);
    }

    public void addAll(List<Element> elements) {
        for (Element element : elements) {
            elementArrayList.add(element);
        }
    }

    public Element findByAtomicNumber(int atomic_number) {
        for (Element element : elementArrayList) {
            if (element.getNumber() == atomic_number) {
                return element;
            }
        }
        return null;
    }

    public Element findByName(String name) {
        for (Element element : elementArrayList) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ArrayList<Element> newCollection = new ArrayList<>();
        for (Element element : elementArrayList) {
            boolean match = seeIfItIsTheValueYouAreLookingFor(fieldName, element, value);
            if(match == true){
                newCollection.add(element);
            }
        }
        ElementCollection elementCollection = new ElementCollection();
        elementCollection.addAll(newCollection);
        return elementCollection;
    }

    public boolean seeIfItIsTheValueYouAreLookingFor(String fieldName , Element element, Object value){
        switch (fieldName.toLowerCase()){
            case "name": if(element.getName().equals(value)){
                return true;
            } break;
            case "appearance": if(element.getAppearance().equals(value)){
                return true;
            } break;
            case "atomic_mass": if(element.getAtomic_mass().equals(value)){
                return true;
            } break;
            case "boil": if(element.getBoil().equals(value)){
                return true;
            } break;
            case "category": if(element.getCategory().equals(value)){
                return true;
            } break;
            case "color": if(element.getColor().equals(value)){
                return true;
            } break;
            case "density": if(element.getDensity().equals(value)){
                return true;
            } break;
            case "discovered_by": if(element.getDiscovered_by().equals(value)){
                return true;
            } break;
            case "melt": if(element.getMelt().equals(value)){
                return true;
            } break;
            case "molar_heat": if(element.getMolar_heat().equals(value)){
                return true;
            } break;
            case "named_by": if(element.getNamed_by().equals(value)){
                return true;
            } break;
            case "number": if(Integer.valueOf(element.getNumber()).equals(value)){
                return true;
            } break;
            case "period": if(Integer.valueOf(element.getPeriod()).equals(value)){
                return true;
            } break;
            case "phase": if(element.getPhase().equals(value)){
                return true;
            } break;
            case "source": if(element.getSource().equals(value)){
                return true;
            } break;
            case "spectral_img": if(element.getSpectral_img().equals(value)){
                return true;
            } break;
            case "summary": if(element.getSummary().equals(value)){
                return true;
            } break;
            case "symbol": if(element.getSymbol().equals(value)){
                return true;
            } break;
            case "xpos": if(Integer.valueOf(element.getXpos()).equals(value)){
                return true;
            } break;
            case "ypos": if(Integer.valueOf(element.getYpos()).equals(value)){
                return true;
            } break;
            case "shells": if(element.getShells().equals(value)){
                return true;
            } break;
        }
        return false;
    }

    public int size(){
        int count = 0;
        for(Element element: elementArrayList){
            count++;
        }
        return count;
    }
}
