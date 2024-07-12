package com.rookie.im.user.common.annotation;



import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(s)){
            return true;
        }else {
            return MobileValidate.isMobile(s);
        }
    }
}
