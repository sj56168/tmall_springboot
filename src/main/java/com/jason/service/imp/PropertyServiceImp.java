package com.jason.service.imp;

import com.jason.mapper.PropertyMapper;
import com.jason.pojo.Property;
import com.jason.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 我不管我最帅 on 2019/3/27.
 */
@Service
public class PropertyServiceImp implements PropertyService{
    @Autowired
    PropertyMapper propertyMapper;

    @Override
    public List<Property> listByCategory(int cid) {
        return propertyMapper.listByCategory(cid);
    }

    @Override
    public void add(Property property) {
        propertyMapper.add(property);
    }

    @Override
    public void delete(int id) {
    propertyMapper.delete(id);
    }

    @Override
    public Property getOne(int id) {
        return propertyMapper.getOne(id);
    }

    @Override
    public void update(Property property) {
    propertyMapper.update(property);
    }
}
