package cn.goatool.db.sql;

/**
 * Created by Administrator on 2020/1/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/2---18:47
 */
public enum LimitingRowsStrategy {

    NOP {
        @Override
        protected void appendClause(SafeAppendable builder, String offset, String limit) {
            // NOP
        }
    },
    ISO {
        @Override
        protected void appendClause(SafeAppendable builder, String offset, String limit) {
            if (offset != null) {
                builder.append(" OFFSET ").append(offset).append(" ROWS");
            }
            if (limit != null) {
                builder.append(" FETCH FIRST ").append(limit).append(" ROWS ONLY");
            }
        }
    },
    OFFSET_LIMIT {
        @Override
        protected void appendClause(SafeAppendable builder, String offset, String limit) {
            if (limit != null) {
                builder.append(" LIMIT ").append(limit);
            }
            if (offset != null) {
                builder.append(" OFFSET ").append(offset);
            }
        }
    };

    protected abstract void appendClause(SafeAppendable builder, String offset, String limit);
}
