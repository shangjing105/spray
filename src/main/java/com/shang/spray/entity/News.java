package com.shang.spray.entity;

import javax.persistence.Entity;

/**
 * info:
 * Created by shang on 16/7/8.
 */
@Entity
public class News extends BaseEntity{

    /**
     * 所属类别
     */
    private Integer typeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String info;

    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否是链接
     */
    private Boolean explicitLink;
    /**
     * 链接地址
     */
    private String link;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String source;
    /**
     * 来源图片
     */
    private String sourceImage;

    /**
     * 标签
     */
    private String label;

    /**
     * 点赞
     */
    private Integer thumbUp;

    /**
     * 是否置顶
     */
    private Boolean placedTop;

    /**
     * 是否推荐
     */
    private Boolean recommend;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 内容
     */
    private String content;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public Boolean getPlacedTop() {
        return placedTop;
    }

    public void setPlacedTop(Boolean placedTop) {
        this.placedTop = placedTop;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getExplicitLink() {
        return explicitLink;
    }

    public void setExplicitLink(Boolean explicitLink) {
        this.explicitLink = explicitLink;
    }
}
