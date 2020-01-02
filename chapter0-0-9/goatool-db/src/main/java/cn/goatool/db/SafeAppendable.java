package cn.goatool.db;

import java.io.IOException;

/**
 * Created by Administrator on 2020/1/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/2---18:40
 */
public class SafeAppendable {

    private final Appendable a;
    private boolean empty = true;

    public SafeAppendable(Appendable a) {
        super();
        this.a = a;
    }

    public SafeAppendable append(CharSequence s) {
        try {
            if (empty && s.length() > 0) {
                empty = false;
            }
            a.append(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public boolean isEmpty() {
        return empty;
    }

}
