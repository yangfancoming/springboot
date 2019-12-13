//import java.sql.Timestamp;
//
///**
// * 物料出入库单
// */
//@Entity
//@Table(name = "INOUT_STORAGE",   catalog = "")
//public class InoutStorage {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "DEFAULT_SEQ")
//    @SequenceGenerator(name = "DEFAULT_SEQ", sequenceName = "DEFAULT_SEQ")
//    @Column(name = "INOUT_STORAGE_ID")
//    private Integer inoutStorageId;
//
//    /**
//     * 出入库单号
//     */
//    private String inoutStorageCode;
//
//    /**
//     * 创建人
//     */
//    private String createUser;
//
//    /**
//     * 创建时间
//     */
//    private Timestamp createTime;
//
//    /**
//     * 发起人
//     */
//    private String initiator;
//
//    /**
//     * 发起时间
//     */
//    private Timestamp initiationTime;
//
//    /**
//     * 其他单号
//     */
//    private String otherCode;
//
//    /**
//     * 出入库标识(0:入库，1：出库)
//     */
//    private String crkType;
//
//    /**
//     * 仓库编码
//     */
//    private String wsCode;
//
//    /**
//     * 仓库名称
//     */
//    private String wsName;
//
//    /**
//     * 出入库单状态
//     */
//    private String state;
//
//    private Integer deleteFlag = 0;
//
//    public Integer getInoutStorageId() {
//        return inoutStorageId;
//    }
//
//    public void setInoutStorageId(Integer inoutStorageId) {
//        this.inoutStorageId = inoutStorageId;
//    }
//
//    @Basic
//    @Column(name = "CREATE_USER")
//    public String getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(String createUser) {
//        this.createUser = createUser;
//    }
//
//    @Basic
//    @Column(name = "CREATE_TIME")
//    public Timestamp getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Timestamp createTime) {
//        this.createTime = createTime;
//    }
//
//    @Basic
//    @Column(name = "CRK_TYPE")
//    public String getCrkType() {
//        return crkType;
//    }
//
//    public void setCrkType(String crkType) {
//        this.crkType = crkType;
//    }
//
//
//    @Basic
//    @Column(name = "OTHER_CODE")
//    public String getOtherCode() {
//        return otherCode;
//    }
//
//    public void setOtherCode(String otherCode) {
//        this.otherCode = otherCode;
//    }
//
//    @Basic
//    @Column(name = "INITIATOR")
//    public String getInitiator() {
//        return initiator;
//    }
//
//    public void setInitiator(String initiator) {
//        this.initiator = initiator;
//    }
//
//    @Basic
//    @Column(name = "INITIATION_TIME")
//    public Timestamp getInitiationTime() {
//        return initiationTime;
//    }
//
//    public void setInitiationTime(Timestamp initiationTime) {
//        this.initiationTime = initiationTime;
//    }
//
//    @Basic
//    @Column(name = "WS_CODE")
//    public String getWsCode() {
//        return wsCode;
//    }
//
//    public void setWsCode(String wsCode) {
//        this.wsCode = wsCode;
//    }
//
//    @Basic
//    @Column(name = "WS_NAME")
//    public String getWsName() {
//        return wsName;
//    }
//
//    public void setWsName(String wsName) {
//        this.wsName = wsName;
//    }
//
//    @Basic
//    @Column(name = "INOUT_STORAGE_CODE")
//    public String getInoutStorageCode() {
//        return inoutStorageCode;
//    }
//
//    public void setInoutStorageCode(String inoutStorageCode) {
//        this.inoutStorageCode = inoutStorageCode;
//    }
//
//    @Basic
//    @Column(name = "STATE")
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    @Basic
//    @Column(name = "DELETE_FLAG")
//    public Integer getDeleteFlag() {
//        return deleteFlag;
//    }
//
//    public void setDeleteFlag(Integer deleteFlag) {
//        this.deleteFlag = deleteFlag;
//    }
//}
