package com.common;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.business.blog.BlogController;
import com.business.book.BookController;
import com.business.item.ItemController;
import com.business.log.LogController;
import com.business.picture.PictureController;
import com.business.test.TestController;
import com.business.user.UserController;
import com.generator.code.CodeController;
import com.generator.upload.UploadController;
import com.index.IndexController;
import com.index.IndexInterceptor;
import com.index.article.ArticleController;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.druid.IDruidStatViewAuth;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;
import com.login.LoginController;
import com.route.AdminRoutes;
import org.apache.zookeeper.Login;

import javax.servlet.http.HttpServletRequest;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * API引导式配置
 */
public class JfinalGlobalConfig extends JFinalConfig {
	
	/**
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 * 
	 * 使用本方法启动过第一次以后，会在开发工具的 debug、run config 中自动生成
	 * 一条启动配置，可对该自动生成的配置再添加额外的配置项，例如 VM argument 可配置为：
	 * -XX:PermSize=64M -XX:MaxPermSize=256M
	 */
	public static void main(String[] args) {
		/**
		 * 特别注意：Eclipse 之下建议的启动方式
		 */
		//JFinal.start("src/main/webapp", 80, "/", 5);
		
		/**
		 * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
		 */
		 JFinal.start("src/main/webapp", 80, "/");
	}
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("dataSource.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setBaseUploadPath(PropKit.get("baseUploadPath"));//设置文件上传路径
		me.setBaseDownloadPath(PropKit.get("baseUploadPath"));//设置文件下载路径
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);	// 第三个参数为该Controller的视图存放路径
		me.add("/index/article", ArticleController.class);	// 第三个参数为该Controller的视图存放路径
		me.add("/upload", UploadController.class);	// 文件处理
		me.add("/login", LoginController.class);
		me.add(new AdminRoutes());
	}
	
	public void configEngine(Engine me) {
		me.addSharedFunction("/common/_layout.html");
		me.addSharedFunction("/common/_paginate.html");
	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置 druid 数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());

		/**配置druid监控**/
		druidPlugin.addFilter(new StatFilter());
		WallFilter wall=new WallFilter();
		wall.setDbType("mysql");
		druidPlugin.addFilter(wall);
		me.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);

		//配置sql模块
		arp.setBaseSqlTemplatePath(PathKit.getRootClassPath()+"/sql");
		arp.addSqlTemplate("all.sql");


		//配置ehcache
		me.add(new EhCachePlugin());

		//定时任务
		//Cron4jPlugin cp = new Cron4jPlugin();
		//cp.addTask("* * * * *",new SolrDataDeltaImportScheduler());
		Cron4jPlugin cp = new Cron4jPlugin("cronConfig.txt");
		me.add(cp);
	}
	
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new SessionInViewInterceptor());
		me.add(new IndexInterceptor());
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		DruidStatViewHandler dvh=new DruidStatViewHandler("/druid",new IDruidStatViewAuth(){
			public boolean isPermitted(HttpServletRequest request) {
				// 这里只是简单的判断访问者是否登录，还可以做更加细致的权限控制
				/*User user=(User) request.getSession().getAttribute("user");
				if(user==null){
					return false;
				}
					return "admin".equals(user.getStr("uname"));
				}*/
				return true;
			}
		});
		me.add(dvh);
	}
}
