package com.example.common.conveter;

import com.example.common.dto.DO;
import com.example.common.model.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DOConverter {


    private DOConverter() {
        // 无需实现
    }

    public static List<Model> toModelList(List<DO> dOList) {
        if (dOList == null) {
            return Collections.emptyList();
        }
        List<Model> modelList = new ArrayList<>();
        for (DO dO : dOList) {
            modelList.add(toModel(dO));
        }
        return modelList;
    }

    public static Model toModel(DO dO) {
        if (dO == null) {
            return null;
        }
        Model model = new Model();
        model.setId(dO.getId());
        return model;
    }

    public static List<DO> toDOList(List<Model> modelList) {
        if (modelList == null) {
            return Collections.emptyList();
        }
        List<DO> dOList = new ArrayList<>();
        for (Model model : modelList) {
            dOList.add(toDO(model));
        }
        return dOList;
    }

    public static DO toDO(Model model) {
        if (model == null) {
            return null;
        }
        DO dO = new DO();
        dO.setId(model.getId());
        return dO;
    }
}
