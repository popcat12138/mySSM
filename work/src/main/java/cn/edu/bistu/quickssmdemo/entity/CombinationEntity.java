package cn.edu.bistu.quickssmdemo.entity;

import java.io.Serializable;

public class CombinationEntity implements Serializable {
    private Integer id;
    private String combName;
    private String otherName;
    private String recipe;
    private String functions;
    private String pre_method;
    private String usages;
    private boolean marked;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCombName() {
        return combName;
    }

    public void setCombName(String combName) {
        this.combName = combName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getPre_method() {
        return pre_method;
    }

    public void setPre_method(String pre_method) {
        this.pre_method = pre_method;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages;
    }
}
