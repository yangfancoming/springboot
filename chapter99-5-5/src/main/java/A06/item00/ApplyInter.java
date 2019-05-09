package A06.item00;

import java.util.Arrays;

/**
 *  使用接口的接口案例
 */
interface ProcessorInter {
    String name();
    Object process(Object input);
}

class UpcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class SplitcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

