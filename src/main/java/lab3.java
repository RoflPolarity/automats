import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.*;

import javax.lang.model.element.Name;
import java.io.File;
import java.io.IOException;
import static guru.nidi.graphviz.attribute.Attributes.attr;
import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.*;
import static guru.nidi.graphviz.model.Link.to;

public class lab3 {
    public static void main(String[] args) throws IOException {
        String[] alf = {"S0","S1","S2"}, count = {"a","b"};
        String[][][] in_count= {{{"S0","S1","S2"},{"S0","S2"}},
                                {{"S0","S1","S2"},{"S0","S2"}},
                                {{},{"S0","S2"}}};
        visual_graph(alf,count,in_count,null);
    }

    public static void visual_graph(String[]alfist,String[]countlist,String[][][]in_countlist,String filename) throws IOException {
        MutableGraph dot = mutGraph("g1").setDirected(true);
        for (int i = 0; i < alfist.length; i++) {
            dot.add(mutNode(alfist[i]));
        }
        for (int i = 0; i < alfist.length; i++) {
            for (int j = 0; j < in_countlist[i].length; j++) {
                String[] val = in_countlist[i][j];
                if (val.length!=0){
                    for (String sym:val) {
                        dot.add(mutNode(alfist[i])
                                .addLink(mutNode(sym).
                                        add(Label.of(countlist[j]))));
                    }
                }
            }
        }
        Graphviz.fromGraph(dot).height(600).width(800).render(Format.PNG).toFile(new File("example/ex1.png"));
    }
}