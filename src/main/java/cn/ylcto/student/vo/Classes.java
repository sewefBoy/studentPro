package cn.ylcto.student.vo;

import java.io.Serializable;

/**
 * Created by sewef on 2017/8/13.
 */
public class Classes implements Serializable{
    private Integer cid;
    private String cname;
    private String note;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
