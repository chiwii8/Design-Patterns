package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ComponentPacket.java
 * <p>
 * Description: Composition of the {@link Component} Interface
 *
 * @author aleja
 * @since 02/01/2026
 */

public class CompoundPacket implements Component{
    private List<Component> componentList;

    public CompoundPacket(){
        this.componentList = new ArrayList<>();
    }

    public void addComponent(Component product){
        componentList.add(product);
    }

    public void removeComponent(Component component){
        componentList.remove(component);
    }
    @Override
    public void Read() {
        System.out.println(this.toString());
    }

    @Override
    public double TotalPrice() {
        return componentList.stream()
                .mapToDouble(Component::TotalPrice)
                .sum();
    }

    ///Override method to return the list of component in the packet with name and individual price
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Packet List:\n");
        if(componentList.isEmpty())
            builder.append("Empty");
        else
            builder.append(
                    componentList.stream()
                    .map(Object::toString)
                            .collect(Collectors.joining("\n"))
            );

        return  builder.toString();
    }
}
