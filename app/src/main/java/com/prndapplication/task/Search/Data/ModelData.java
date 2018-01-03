package com.prndapplication.task.Search.Data;

import java.util.List;

/**
 * Created by kiyoungLee on 2018-01-03.
 */

public class ModelData {

    private String absolute_url;
    private int id;
    private String name;
    private List<BrandData> models;

    public String getAbsolute_url() {
        return absolute_url;
    }

    public void setAbsolute_url(String absolute_url) {
        this.absolute_url = absolute_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrandData> getModels() {
        return models;
    }

    public void setModels(List<BrandData> models) {
        this.models = models;
    }
}
