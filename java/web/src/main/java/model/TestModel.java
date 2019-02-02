package model;

/**
 * Created by lichuangjian on 16/7/21.
 * desprition:
 */
public class TestModel {

    private int id;
    private Integer packageId;
    private String createTime;


    public int id() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public TestModel() {
    }


}
