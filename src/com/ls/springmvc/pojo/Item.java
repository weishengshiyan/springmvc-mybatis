package com.ls.springmvc.pojo;

import java.util.Date;

public class Item {
  

	private Integer id;

    private String name;

    private Float price;

    private String detail;

    private String pic;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Override
  	public String toString() {
  		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", pic=" + pic
  				+ ", createtime=" + createtime + "]";
  	}
}