package com.ulanzhasssanov.CrudAppWithHibernate.controller;

import com.ulanzhasssanov.CrudAppWithHibernate.model.Label;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.hibernate.HibernateLabelRepositoryImpl;
import com.ulanzhasssanov.CrudAppWithHibernate.service.LabelService;

import java.util.List;

public class LabelController {
    private LabelService labelService = new LabelService(new HibernateLabelRepositoryImpl());

    public Label saveLabel(Label label){
        return labelService.saveLabel(label);
    }

    public List<Label> getAllLabels(){
        return labelService.getAllLabels();
    }

    public Label getLabelById(Integer id){
        return labelService.getLabelById(id);
    }

    public Label updateLabel(Label label){
        return labelService.updateLabel(label);
    }

    public void deleteLabel(Integer id){
        labelService.deleteLabelById(id);
    }
}
