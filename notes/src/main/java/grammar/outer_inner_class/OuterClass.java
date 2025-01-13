package grammar.outer_inner_class;

import lombok.Data;

@Data
public class OuterClass {

    private static int outerStaticVar = 10;

    static class StaticInnerClass {
        public void printOuterStaticVar() {
            System.out.println(outerStaticVar);
        }
    }

}
