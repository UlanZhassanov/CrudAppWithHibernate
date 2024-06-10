package com.ulanzhasssanov.CrudAppWithHibernate.controller;

import com.ulanzhasssanov.CrudAppWithHibernate.model.Writer;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.JdbcWriterRepositoryImpl;
import com.ulanzhasssanov.CrudAppWithHibernate.service.WriterService;

import java.util.List;

public class WriterController {
    private WriterService writerService = new WriterService(new JdbcWriterRepositoryImpl());

    public Writer saveWriter(Writer writer){
        return writerService.saveWriter(writer);
    }

    public List<Writer> getAllWriters(){
        return writerService.getAllWriters();
    }

    public Writer getWriterById(Integer id){
        return writerService.getWriterById(id);
    }

    public Writer updateWriter(Writer writer){
        return writerService.updateWriter(writer);
    }

    public void deleteWriter(Integer id){
        writerService.deleteWriterById(id);
    }
}
