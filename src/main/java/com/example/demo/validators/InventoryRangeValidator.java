package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
//import com.example.demo.service.ProductService;
//import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryRangeValidator implements ConstraintValidator<ValidInventoryRange, Part> {

    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidInventoryRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) {
            return true;
        }

        if(context!=null) {
            myContext=context;
        }

        if (part.getInv() < part.getMinInv() || part.getInv() > part.getMaxInv()) {
            return false;
        }
        
        return true;
    }
}
