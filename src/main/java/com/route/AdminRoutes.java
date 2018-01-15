package com.route;

import com.business.blog.BlogController;
import com.business.book.BookController;
import com.business.item.ItemController;
import com.business.log.LogController;
import com.business.picture.PictureController;
import com.business.test.TestController;
import com.business.user.UserController;
import com.generator.code.CodeController;
import com.jfinal.config.Routes;

/**
 * 后台管理链接
 * Created by zzk on 2018-01-15.
 */
public class AdminRoutes extends Routes{
    @Override
    public void config() {
        addInterceptor(new AdminAuthInterceptor());

        add("/code", CodeController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
        add("/blog", BlogController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
        add("/user", UserController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
        add("/item", ItemController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
        add("/picture", PictureController.class);
        add("/log", LogController.class);
        add("/test", TestController.class);
        add("/book", BookController.class);
    }
}
