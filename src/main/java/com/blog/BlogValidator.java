package com.blog;

import com.common.model.Blog;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
*  Validator
*/
public class BlogValidator extends Validator {

    protected void validate(Controller controller) {
        
        validateString(true,"blog.title", 1,100,"titleMsg", "标题");

        
            validateText(true,"blog.content", 5592405,"contentMsg", "内容");
    
    }

    protected void handleError(Controller controller) {
        controller.keepModel(Blog.class);
        String actionKey = getActionKey();
        if (actionKey.equals("/blog/save")){
            controller.render("add.html");
        }else if (actionKey.equals("/blog/update")){
            controller.render("edit.html");
        }
    }
}