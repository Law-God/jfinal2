###首页sql

###首页轮播图
#sql("bannerList")
  select id,picId,title,createTime,updateTime,`order`,`status` from banner order by `order` desc,id desc
#end

###首页文章列表
#sql("articleList")
  select id,title,descript,attachment,createTime,updateTime,`status` from  article where status=1
#end

###首页文章详情
#sql("articleDetail")
  select id,title,descript,content,attachment,createTime,updateTime,`status` from  article where id=?
#end

#sql("userList")
  select * from user order by id desc
#end