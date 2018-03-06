package com.nie.nieapp.treeview;

import android.databinding.BaseObservable;

/**
 * Element类
 *
 * @author carrey
 */
public class Element extends BaseObservable {
    /**
     * 0 normal  1 error
     */
    public boolean treeType;
    /**
     * 节点名称
     */
    public String treeName;

    /**
     * 节点状态描述图标
     */
    public int treeStateIcon;

    /**
     * 节点详细说明
     */
    public String treeDescription;

    /**
     * 包含子节点数量
     */
    public int treeNum;

    /**
     * 在tree中的层级
     */
    public int level;
    /**
     * 元素的id
     */
    public int id;
    /**
     * 父元素的id
     */
    public int parendId;
    /**
     * 是否有子元素
     */
    public boolean hasChildren;
    /**
     * item是否展开
     */
    public boolean isExpanded;

    /**
     * 表示该节点没有父元素，也就是level为0的节点
     */
    public static final int NO_PARENT = -1;
    /**
     * 表示该元素位于最顶层的层级
     */
    public static final int TOP_LEVEL = 0;

    public Element(boolean treeType, String treeName, int level, int id, int parendId,
                   boolean hasChildren, boolean isExpanded) {
        super();
        this.treeName = treeName;
        this.level = level;
        this.id = id;
        this.parendId = parendId;
        this.hasChildren = hasChildren;
        this.isExpanded = isExpanded;
        this.treeType = treeType;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParendId() {
        return parendId;
    }

    public void setParendId(int parendId) {
        this.parendId = parendId;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getTreeDescription() {
        return treeDescription;
    }

    public void setTreeDescription(String treeDescription) {
        this.treeDescription = treeDescription;
    }

    public int getTreeStateIcon() {
        return treeStateIcon;
    }

    public void setTreeStateIcon(int treeStateIcon) {
        this.treeStateIcon = treeStateIcon;
    }

    public boolean isTreeType() {
        return treeType;
    }

    public void setTreeType(boolean treeType) {
        this.treeType = treeType;
    }

    public int getTreeNum() {
        return treeNum;
    }

    public void setTreeNum(int treeNum) {
        this.treeNum = treeNum;
    }
}
